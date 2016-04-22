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

package com.liferay.document.library.kernel.util;

import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author Istvan Andras Dezsi
 */
public class WkHtmlToPdfUtil {

	public static Future<?> execute(List<String> arguments) throws Exception {
		return getWkHtmlToPdf().execute(arguments);
	}

	public static String getGlobalSearchPath() throws Exception {
		return getWkHtmlToPdf().getGlobalSearchPath();
	}

	public static WkHtmlToPdf getWkHtmlToPdf() {
		PortalRuntimePermission.checkGetBeanProperty(WkHtmlToPdfUtil.class);

		return _wkHtmlToPdf;
	}

	public static boolean isEnabled() {
		return getWkHtmlToPdf().isEnabled();
	}

	public static void reset() {
		getWkHtmlToPdf().reset();
	}

	public void setWkHtmlToPdf(WkHtmlToPdf wkHtmlToPdf) {
		PortalRuntimePermission.checkSetBeanProperty(getClass());

		_wkHtmlToPdf = wkHtmlToPdf;
	}

	private static WkHtmlToPdf _wkHtmlToPdf;

}