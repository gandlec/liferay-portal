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

package com.liferay.portlet.documentlibrary.util;

import com.liferay.document.library.kernel.util.WkHtmlToPdf;
import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.process.ProcessUtil;
import com.liferay.portal.kernel.util.OSDetector;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsUtil;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

import javax.portlet.PortletPreferences;

/**
 * @author Istvan Andras Dezsi
 */
public class WkHtmlToPdfImpl implements WkHtmlToPdf {

	@Override
	public Future<?> execute(List<String> commandArguments) throws Exception {
		LinkedList<String> arguments = new LinkedList<>();

		if (!isEnabled()) {
			StringBundler sb = new StringBundler(6);

			sb.append("Cannot execute the wkhtmtopdf command. Please ");
			sb.append("install wkhtmtopdf and enable wkhtmtopdf in ");
			sb.append("portal-ext.properties or in the Server ");
			sb.append("Administration section of the Control Panel at: ");
			sb.append("http://<server>/group/control_panel/manage/-/server/");
			sb.append("external-services");

			throw new IllegalStateException(sb.toString());
		}

		arguments.add(_commandPath);
		arguments.addAll(commandArguments);

		if (_log.isInfoEnabled()) {
			StringBundler sb = new StringBundler(arguments.size() * 2);

			for (String argument : arguments) {
				sb.append(argument);
				sb.append(StringPool.SPACE);
			}

			_log.info("Excecuting command '" + sb.toString() + "'");
		}

		return ProcessUtil.execute(
			ProcessUtil.LOGGING_OUTPUT_PROCESSOR, arguments);
	}

	@Override
	public String getGlobalSearchPath() throws Exception {
		PortletPreferences preferences = PrefsPropsUtil.getPreferences(true);

		String globalSearchPath = preferences.getValue(
			PropsKeys.WKHTMLTOPDF_GLOBAL_SEARCH_PATH, null);

		if (Validator.isNotNull(globalSearchPath)) {
			return globalSearchPath;
		}

		String filterName = null;

		if (OSDetector.isApple()) {
			filterName = "apple";
		}
		else if (OSDetector.isWindows()) {
			filterName = "windows";
		}
		else {
			filterName = "unix";
		}

		return PropsUtil.get(
			PropsKeys.WKHTMLTOPDF_GLOBAL_SEARCH_PATH, new Filter(filterName));
	}

	@Override
	public boolean isEnabled() {
		boolean enabled = false;

		try {
			enabled = PrefsPropsUtil.getBoolean(PropsKeys.WKHTMLTOPDF_ENABLED);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		if (!enabled && !_warned && _log.isWarnEnabled()) {
			StringBundler sb = new StringBundler(7);

			sb.append("Liferay is not configured to use wkhtmltopdf. ");
			sb.append("For better quality HTML to PDF conversion, ");
			sb.append("install wkhtmltopdf. Enable wkhtmltopdf in ");
			sb.append("portal-ext.properties or or in the Server ");
			sb.append("Administration section of the Control Panel at: ");
			sb.append("http://<server>/group/control_panel/manage/-/server/");
			sb.append("external-services");

			_log.warn(sb.toString());

			_warned = true;
		}

		return enabled;
	}

	@Override
	public void reset() {
		if (isEnabled()) {
			try {
				_globalSearchPath = getGlobalSearchPath();

				_commandPath = getCommandPath();
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
	}

	protected String getCommandPath() throws Exception {
		String[] dirNames = _globalSearchPath.split(File.pathSeparator);

		for (String dirName : dirNames) {
			if (OSDetector.isWindows()) {
				File file = new File(dirName, _WKHTMLTOPDF_COMMAND + ".exe");

				if (file.exists()) {
					return file.getCanonicalPath();
				}
			}
			else {
				File file = new File(dirName, _WKHTMLTOPDF_COMMAND);

				if (file.exists()) {
					return file.getCanonicalPath();
				}
			}

			StringBundler sb = new StringBundler(4);

			sb.append("Unable to find the wkhtmltopdf command. Please verify ");
			sb.append("the path specified in the Server Administration ");
			sb.append("control panel at: http://<server>/group/control_panel/");
			sb.append("manage/-/server/external-services");

			throw new FileNotFoundException(sb.toString());
		}

		return null;
	}

	private static final String _WKHTMLTOPDF_COMMAND = "wkhtmltopdf";

	private static final Log _log = LogFactoryUtil.getLog(
		WkHtmlToPdfImpl.class);

	private String _commandPath;
	private String _globalSearchPath;
	private boolean _warned;

}