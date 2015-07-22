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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.UserTrackerPath;
import com.liferay.portal.model.UserTrackerPathModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the UserTrackerPath service. Represents a row in the &quot;UserTrackerPath&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UserTrackerPathModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserTrackerPathImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerPathImpl
 * @see UserTrackerPath
 * @see UserTrackerPathModel
 * @generated
 */
@ProviderType
public class UserTrackerPathModelImpl extends BaseModelImpl<UserTrackerPath>
	implements UserTrackerPathModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user tracker path model instance should use the {@link UserTrackerPath} interface instead.
	 */
	public static final String TABLE_NAME = "UserTrackerPath";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "userTrackerPathId", Types.BIGINT },
			{ "userTrackerId", Types.BIGINT },
			{ "path_", Types.VARCHAR },
			{ "pathDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userTrackerPathId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userTrackerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("path_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pathDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table UserTrackerPath (mvccVersion LONG default 0,userTrackerPathId LONG not null primary key,userTrackerId LONG,path_ STRING null,pathDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table UserTrackerPath";
	public static final String ORDER_BY_JPQL = " ORDER BY userTrackerPath.userTrackerPathId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY UserTrackerPath.userTrackerPathId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.UserTrackerPath"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.UserTrackerPath"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.UserTrackerPath"),
			true);
	public static final long USERTRACKERID_COLUMN_BITMASK = 1L;
	public static final long USERTRACKERPATHID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.UserTrackerPath"));

	public UserTrackerPathModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userTrackerPathId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserTrackerPathId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userTrackerPathId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserTrackerPath.class;
	}

	@Override
	public String getModelClassName() {
		return UserTrackerPath.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("userTrackerPathId", getUserTrackerPathId());
		attributes.put("userTrackerId", getUserTrackerId());
		attributes.put("path", getPath());
		attributes.put("pathDate", getPathDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long userTrackerPathId = (Long)attributes.get("userTrackerPathId");

		if (userTrackerPathId != null) {
			setUserTrackerPathId(userTrackerPathId);
		}

		Long userTrackerId = (Long)attributes.get("userTrackerId");

		if (userTrackerId != null) {
			setUserTrackerId(userTrackerId);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Date pathDate = (Date)attributes.get("pathDate");

		if (pathDate != null) {
			setPathDate(pathDate);
		}
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getUserTrackerPathId() {
		return _userTrackerPathId;
	}

	@Override
	public void setUserTrackerPathId(long userTrackerPathId) {
		_userTrackerPathId = userTrackerPathId;
	}

	@Override
	public long getUserTrackerId() {
		return _userTrackerId;
	}

	@Override
	public void setUserTrackerId(long userTrackerId) {
		_columnBitmask |= USERTRACKERID_COLUMN_BITMASK;

		if (!_setOriginalUserTrackerId) {
			_setOriginalUserTrackerId = true;

			_originalUserTrackerId = _userTrackerId;
		}

		_userTrackerId = userTrackerId;
	}

	public long getOriginalUserTrackerId() {
		return _originalUserTrackerId;
	}

	@Override
	public String getPath() {
		if (_path == null) {
			return StringPool.BLANK;
		}
		else {
			return _path;
		}
	}

	@Override
	public void setPath(String path) {
		_path = path;
	}

	@Override
	public Date getPathDate() {
		return _pathDate;
	}

	@Override
	public void setPathDate(Date pathDate) {
		_pathDate = pathDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UserTrackerPath.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserTrackerPath toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserTrackerPath)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserTrackerPathImpl userTrackerPathImpl = new UserTrackerPathImpl();

		userTrackerPathImpl.setMvccVersion(getMvccVersion());
		userTrackerPathImpl.setUserTrackerPathId(getUserTrackerPathId());
		userTrackerPathImpl.setUserTrackerId(getUserTrackerId());
		userTrackerPathImpl.setPath(getPath());
		userTrackerPathImpl.setPathDate(getPathDate());

		userTrackerPathImpl.resetOriginalValues();

		return userTrackerPathImpl;
	}

	@Override
	public int compareTo(UserTrackerPath userTrackerPath) {
		long primaryKey = userTrackerPath.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserTrackerPath)) {
			return false;
		}

		UserTrackerPath userTrackerPath = (UserTrackerPath)obj;

		long primaryKey = userTrackerPath.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		UserTrackerPathModelImpl userTrackerPathModelImpl = this;

		userTrackerPathModelImpl._originalUserTrackerId = userTrackerPathModelImpl._userTrackerId;

		userTrackerPathModelImpl._setOriginalUserTrackerId = false;

		userTrackerPathModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserTrackerPath> toCacheModel() {
		UserTrackerPathCacheModel userTrackerPathCacheModel = new UserTrackerPathCacheModel();

		userTrackerPathCacheModel.mvccVersion = getMvccVersion();

		userTrackerPathCacheModel.userTrackerPathId = getUserTrackerPathId();

		userTrackerPathCacheModel.userTrackerId = getUserTrackerId();

		userTrackerPathCacheModel.path = getPath();

		String path = userTrackerPathCacheModel.path;

		if ((path != null) && (path.length() == 0)) {
			userTrackerPathCacheModel.path = null;
		}

		Date pathDate = getPathDate();

		if (pathDate != null) {
			userTrackerPathCacheModel.pathDate = pathDate.getTime();
		}
		else {
			userTrackerPathCacheModel.pathDate = Long.MIN_VALUE;
		}

		return userTrackerPathCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", userTrackerPathId=");
		sb.append(getUserTrackerPathId());
		sb.append(", userTrackerId=");
		sb.append(getUserTrackerId());
		sb.append(", path=");
		sb.append(getPath());
		sb.append(", pathDate=");
		sb.append(getPathDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.UserTrackerPath");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userTrackerPathId</column-name><column-value><![CDATA[");
		sb.append(getUserTrackerPathId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userTrackerId</column-name><column-value><![CDATA[");
		sb.append(getUserTrackerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pathDate</column-name><column-value><![CDATA[");
		sb.append(getPathDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = UserTrackerPath.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			UserTrackerPath.class
		};
	private long _mvccVersion;
	private long _userTrackerPathId;
	private long _userTrackerId;
	private long _originalUserTrackerId;
	private boolean _setOriginalUserTrackerId;
	private String _path;
	private Date _pathDate;
	private long _columnBitmask;
	private UserTrackerPath _escapedModel;
}