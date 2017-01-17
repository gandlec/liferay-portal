/* global React, AlloyEditor */

(function () {
	'use strict';

	var React = AlloyEditor.React;

	var ButtonUnderline = React.createClass(
		{
			mixins: [AlloyEditor.ButtonStyle, AlloyEditor.ButtonStateClasses, AlloyEditor.ButtonCommand, AlloyEditor.ButtonKeystroke],

			propTypes: {
				editor: React.PropTypes.object.isRequired,
				label: React.PropTypes.string,
				tabIndex: React.PropTypes.number
			},

			statics: {
				key: 'underline'
			},

			getDefaultProps: function() {
				return {
					command: 'underline',
					keystroke: {
						fn: 'execCommand',
						keys: CKEDITOR.CTRL + 85 /*U*/
					},
					style: 'coreStyles_underline'
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
						'aria-label': AlloyEditor.Strings.underline,
						'aria-pressed': cssClass.indexOf('pressed') !== -1,
						className: cssClass,
						'data-type': 'button-underline',
						disabled: isDisabled,
						onClick: this.execCommand,
						tabIndex: this.props.tabIndex,
						title: AlloyEditor.Strings.underline
					},
					React.createElement(
						'span',
						{
							className: 'ae-icon-underline'
						}
					)
				);
			}
		}
	);

	AlloyEditor.Buttons[ButtonUnderline.key] = AlloyEditor.ButtonUnderline = ButtonUnderline;
}());