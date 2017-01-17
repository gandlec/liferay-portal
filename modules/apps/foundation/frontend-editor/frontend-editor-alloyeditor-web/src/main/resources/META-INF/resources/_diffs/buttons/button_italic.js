/* global React, AlloyEditor */

(function () {
	'use strict';

	var React = AlloyEditor.React;

	var ButtonItalic = React.createClass(
		{
			mixins: [AlloyEditor.ButtonStyle, AlloyEditor.ButtonStateClasses, AlloyEditor.ButtonCommand, AlloyEditor.ButtonKeystroke],

			propTypes: {
				editor: React.PropTypes.object.isRequired,
				label: React.PropTypes.string,
				tabIndex: React.PropTypes.number
			},

			statics: {
				key: 'italic'
			},

			getDefaultProps: function() {
				return {
					command: 'italic',
					keystroke: {
						fn: 'execCommand',
						keys: CKEDITOR.CTRL + 73 /*I*/
					},
					style: 'coreStyles_italic'
				};
			},

			isDisabled: function() {
				var result;

				var editor = this.props.editor.get('nativeEditor');

				var elementPath = editor.elementPath();

				var headings = ['h1', 'h2', 'h3', 'h4', 'h5', 'h6'];

				result = elementPath.contains(headings);

				return result;
			},

			render: function() {
				var cssClass = "ae-button " + this.getStateClasses();

				var isDisabled = this.isDisabled();

				return React.createElement(
					'button',
					{
						'aria-label': AlloyEditor.Strings.italic,
						'aria-pressed': cssClass.indexOf('pressed') !== -1,
						className: cssClass,
						'data-type': 'button-italic',
						disabled: isDisabled,
						onClick: this.execCommand,
						tabIndex: this.props.tabIndex,
						title: AlloyEditor.Strings.italic
					},
					React.createElement(
						'span',
						{
							className: 'ae-icon-italic'
						}
					)
				);
			}
		}
	);

	AlloyEditor.Buttons[ButtonItalic.key] = AlloyEditor.ButtonItalic = ButtonItalic;
}());