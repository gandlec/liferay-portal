(function() {

	var API_KEY = Liferay.googleConfiguration.API_KEY;

	var CLIENT_ID = Liferay.googleConfiguration.CLIENT_ID;

	var SCOPE = [
	    'https://www.googleapis.com/auth/drive.readonly',
	    'https://www.googleapis.com/auth/photos.upload'
	];

	CKEDITOR.plugins.add(
		'googledocs',
		{
			init: function(editor) {
				var instance = this;

				editor.addCommand(
					'googledocsselector',
					{
						canUndo: false,
						exec: function(editor) {

							var onGoogleDocSelectedFn = AUI().bind(
								'_onGoogleDocSelected',
								instance,
								editor
							);

							Liferay.once('googleDocSelected', onGoogleDocSelectedFn);

							instance._openPicker();
						}
					}
				);

				if (editor.ui.addButton) {
					editor.ui.addButton(
						'GoogleDocsSelector',
						{
							command: 'googledocsselector',
							icon: instance.path + 'assets/google_docs.png',
							label: Liferay.Language.get('googledocs')
						}
					);
				}
			},

			_openPicker: function() {
				var instance = this;

				instance._createPicker();

				if (!instance._authAPILoaded) {
					gapi.load(
						'auth',
						{
							'callback': instance._onAuthAPILoad.bind(instance)
						}
					);
				}

				if (!instance._pickerAPILoaded) {
					gapi.load(
						'picker',
						{
							'callback': instance._onPickerAPILoad.bind(instance)
						}
					);
				}
			},

			_createPicker: function() {
				var instance = this;

				if (instance._pickerAPILoaded && instance._authAPILoaded) {
					var viewId = google.picker.ViewId;

					var groupDocuments = new google.picker.ViewGroup(viewId.DOCS);

					groupDocuments.addView(viewId.DOCUMENTS);
					groupDocuments.addView(viewId.SPREADSHEETS);
					groupDocuments.addView(viewId.PRESENTATIONS);

					var groupPhotos = new google.picker.ViewGroup(viewId.PHOTOS);

					groupPhotos.addView(viewId.PHOTO_UPLOAD);
					groupPhotos.addView(viewId.WEBCAM);

					var picker = new google.picker.PickerBuilder();

					picker.addViewGroup(groupDocuments);
					picker.addViewGroup(groupPhotos);

					picker.addView(viewId.RECENTLY_PICKED);

					picker.setOAuthToken(instance._oauthToken);
					picker.setDeveloperKey(API_KEY);
					picker.setCallback(instance._pickerCallback);

					picker.build().setVisible(true);
				}
			},

			_onAuthAPILoad: function() {
				var instance = this;

				window.gapi.auth.authorize(
					{
						'client_id': CLIENT_ID,
						'immediate': false,
						'scope': SCOPE
					},
					function(authResult) {
						if (authResult && !authResult.error) {
							instance._oauthToken = authResult.access_token;

							instance._authAPILoaded = true;

							instance._createPicker();
						}
					}
				);
			},

			_onPickerAPILoad: function() {
				var instance = this;

				instance._pickerAPILoaded = true;

				instance._createPicker();
			},

			_pickerCallback: function(data) {
				if (data[google.picker.Response.ACTION] === google.picker.Action.PICKED) {
					var doc = data[google.picker.Response.DOCUMENTS][0];

					var googlePickerDoc = google.picker.Document;

					var embeddable_url = doc[googlePickerDoc.EMBEDDABLE_URL];

					Liferay.fire('googleDocSelected',
						{
							url: embeddable_url
						}
					);
				}
			},

			_onGoogleDocSelected: function(editor, event) {
				var embeddable_url = event.url;

				var el = CKEDITOR.dom.element.createFromHtml('<iframe frameborder="0" height="300" src="' + embeddable_url + '" width="90%"></iframe>');

				editor.insertElement(el);

				editor.focus();
			}
		}
	);

	window.onGoogleAPILoad = function() {
		Liferay.fire('googleAPILoaded');
	};

	if (!window.gapi && !document.getElementById('googleAPILoader')) {
		var scriptNode = document.createElement('script');

		scriptNode.id = 'googleAPILoader';
		scriptNode.src = 'https://apis.google.com/js/api.js?onload=onGoogleAPILoad';

		document.body.appendChild(scriptNode);
	}
	else if (window.gapi) {
		Liferay.fire('googleAPILoaded');
	}
})();