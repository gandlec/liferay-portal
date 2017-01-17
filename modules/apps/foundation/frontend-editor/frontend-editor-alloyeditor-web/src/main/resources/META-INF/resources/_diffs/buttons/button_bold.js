/* global React, AlloyEditor */

(function () {
	'use strict';

	var React = AlloyEditor.React;

	var ButtonBold = React.createClass(
		{
			mixins: [AlloyEditor.ButtonStyle, AlloyEditor.ButtonStateClasses, AlloyEditor.ButtonCommand, AlloyEditor.ButtonKeystroke],

			propTypes: {
				editor: React.PropTypes.object.isRequired,
				label: React.PropTypes.string,
				tabIndex: React.PropTypes.number
			},

			statics: {
				key: 'bold'
			},

			getDefaultProps: function() {
				return {
					command: 'bold',
					keystroke: {
						fn: 'execCommand',
						keys: CKEDITOR.CTRL + 66 /*B*/
					},
					style: 'coreStyles_bold'
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
						'aria-label': AlloyEditor.Strings.bold,
						'aria-pressed': cssClass.indexOf('pressed') !== -1,
						className: cssClass,
						'data-type': 'button-bold',
						disabled: isDisabled,
						onClick: this.execCommand,
						tabIndex: this.props.tabIndex,
						title: AlloyEditor.Strings.bold
					},
					React.createElement(
						'span',
						{
							className: 'ae-icon-bold'
						}
					)
				);
			}
		}
	);

	AlloyEditor.Buttons[ButtonBold.key] = AlloyEditor.ButtonBold = ButtonBold;
}());