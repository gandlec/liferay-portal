AUI.add(
	'document-library-document',
	function(A) {
		var STR_DESCRIPTION_INPUT_LOCALIZED = 'descriptionInputLocalized';

		var STR_TITLE_INPUT_LOCALIZED = 'titleInputLocalized';

		var STR_TRANSLATION_MANAGER = 'translationManager';

		var Document = A.Component.create(
			{
				ATTRS: {
					descriptionInputLocalized: {
					},

					titleInputLocalized: {
					},

					translationManager: {
					}
				},

				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'document',

				prototype: {
					initializer: function(config) {
						var instance = this;

						instance._bindUI();
						instance._renderUI();
					},

					destructor: function() {
						var instance = this;

						(new A.EventHandle(instance._eventHandles)).detach();
					},

					_afterDeletingAvailableLocale: function(event) {
						var instance = this;

						var descriptionInputLocalized = instance.get(STR_DESCRIPTION_INPUT_LOCALIZED);

						var titleInputLocalized = instance.get(STR_TITLE_INPUT_LOCALIZED);

						var locale = event.locale;

						descriptionInputLocalized.removeInputLanguage(locale);

						titleInputLocalized.removeInputLanguage(locale);
					},

					_afterEditingLocaleChange: function(event) {
						var instance = this;

						var descriptionInputLocalized = instance.get(STR_DESCRIPTION_INPUT_LOCALIZED);

						var titleInputLocalized = instance.get(STR_TITLE_INPUT_LOCALIZED);

						var items = descriptionInputLocalized.get('items');

						var editingLocale = event.newVal;

						var selectedIndex = items.indexOf(editingLocale);

						descriptionInputLocalized.set('selected', selectedIndex);
						descriptionInputLocalized.selectFlag(editingLocale);

						titleInputLocalized.set('selected', selectedIndex);
						titleInputLocalized.selectFlag(editingLocale);
					},

					_bindUI: function() {
						var instance = this;

						var eventHandles = [];

						var translationManager = instance.get(STR_TRANSLATION_MANAGER);

						if (translationManager) {
							eventHandles.push(
								translationManager.on('deleteAvailableLocale', instance._afterDeletingAvailableLocale.bind(instance))
							);
							eventHandles.push(
								translationManager.after('editingLocaleChange', instance._afterEditingLocaleChange, instance)
							);
						}

						instance._eventHandles = eventHandles;
					},

					_getPrincipalForm: function(formName) {
						var instance = this;

						return instance.one('form[name=' + instance.ns(formName || 'fm1') + ']');
					},

					_renderUI: function() {
						var instance = this;

						instance.get(STR_DESCRIPTION_INPUT_LOCALIZED).render();
						instance.get(STR_TITLE_INPUT_LOCALIZED).render();
					}
				}
			}
		);

		Liferay.Portlet.Document = Document;
	},
	'',
	{
		requires: ['aui-base', 'liferay-portlet-base']
	}
);