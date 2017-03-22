/* global React, AlloyEditor */

(function() {
	'use strict';

	var React = AlloyEditor.React;

	var ButtonGoogleDocs = React.createClass(
		{
			mixins: [AlloyEditor.ButtonCommand],

			displayName: 'ButtonGoogleDocs',

			propTypes: {
				editor: React.PropTypes.object.isRequired
			},

			getDefaultProps: function() {
				return {
					command: 'googledocsselector'
				};
			},

			statics: {
				key: 'googledocs'
			},

			render: function() {
				return React.createElement(
					'button',
					{
						className: 'ae-button',
						'data-type': 'button-googledocs',
						onClick: this._handleClick,
						tabIndex: this.props.tabIndex
					},
					React.createElement(
						'span',
						{
							className: 'icon-file'
						}
					)
				);
			},

			_handleClick: function() {
				this.execCommand(null);
			}
		}
	);

	AlloyEditor.Buttons[ButtonGoogleDocs.key] = AlloyEditor.ButtonGoogleDocs = ButtonGoogleDocs;
}());