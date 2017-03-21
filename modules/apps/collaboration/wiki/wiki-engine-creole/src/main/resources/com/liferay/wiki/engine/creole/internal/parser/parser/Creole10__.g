lexer grammar Creole10;
options {
  language=Java;

}
@header {
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

 package com.liferay.wiki.engine.creole.internal.parser.parser;
}

T42 : ':' ;
T43 : 'C' ;
T44 : '2' ;
T45 : 'D' ;
T46 : 'o' ;
T47 : 'k' ;
T48 : 'u' ;
T49 : 'W' ;
T50 : 'i' ;
T51 : 'F' ;
T52 : 'l' ;
T53 : 'c' ;
T54 : 'r' ;
T55 : 'G' ;
T56 : 'g' ;
T57 : 'e' ;
T58 : 'J' ;
T59 : 'S' ;
T60 : 'P' ;
T61 : 'M' ;
T62 : 'a' ;
T63 : 't' ;
T64 : 'b' ;
T65 : 'd' ;
T66 : 'n' ;
T67 : 'O' ;
T68 : 'm' ;
T69 : 's' ;
T70 : 'h' ;
T71 : 'p' ;
T72 : 'R' ;
T73 : 'x' ;
T74 : 'T' ;
T75 : 'y' ;
T76 : 'U' ;
T77 : 'X' ;
T78 : '<<TableOfContents>>' ;
T79 : '<<TableOfContents title=' ;
T80 : '\"' ;
T81 : '>>' ;

// $ANTLR src "Creole10.g" 1166
ESCAPE					: '~';
// $ANTLR src "Creole10.g" 1167
NOWIKI_BLOCK_CLOSE		: NEWLINE  '}}}';
// $ANTLR src "Creole10.g" 1168
NEWLINE					: ( CR )?  LF
						| CR;
// $ANTLR src "Creole10.g" 1170
fragment CR				: '\r';
// $ANTLR src "Creole10.g" 1171
fragment LF				: '\n';

// $ANTLR src "Creole10.g" 1173
BLANKS					: ( SPACE | TABULATOR )+;
// $ANTLR src "Creole10.g" 1174
fragment SPACE			: ' ';
// $ANTLR src "Creole10.g" 1175
fragment TABULATOR		: '\t';

// $ANTLR src "Creole10.g" 1177
BRACE_CLOSE				: NEWLINE '}';
// $ANTLR src "Creole10.g" 1178
COLON_SLASH				: ':'  '/';
// $ANTLR src "Creole10.g" 1179
ITAL					: '//';
// $ANTLR src "Creole10.g" 1180
NOWIKI_OPEN				: '{{{';
// $ANTLR src "Creole10.g" 1181
NOWIKI_CLOSE			: '}}}';
// $ANTLR src "Creole10.g" 1182
LINK_OPEN				: '[[';
// $ANTLR src "Creole10.g" 1183
LINK_CLOSE				: ']]';
// $ANTLR src "Creole10.g" 1184
IMAGE_OPEN				: '{{';
// $ANTLR src "Creole10.g" 1185
IMAGE_CLOSE				: '}}';
// $ANTLR src "Creole10.g" 1186
FORCED_LINEBREAK		: '\\\\';
// $ANTLR src "Creole10.g" 1187
EQUAL					: '=';
// $ANTLR src "Creole10.g" 1188
PIPE					: '|';
// $ANTLR src "Creole10.g" 1189
POUND					: '#';
// $ANTLR src "Creole10.g" 1190
DASH					: '-';
// $ANTLR src "Creole10.g" 1191
STAR					: '*';
// $ANTLR src "Creole10.g" 1192
SLASH					: '/';
// $ANTLR src "Creole10.g" 1193
EXTENSION				: '@@';
// $ANTLR src "Creole10.g" 1194
IFRAME					: '$$';

// $ANTLR src "Creole10.g" 1196
INSIGNIFICANT_CHAR		: .;