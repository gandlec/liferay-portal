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

package com.liferay.fragment.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.fragment.model.FragmentEntryInstanceLink;
import com.liferay.fragment.model.FragmentEntryInstanceLinkModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the FragmentEntryInstanceLink service. Represents a row in the &quot;FragmentEntryInstanceLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link FragmentEntryInstanceLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FragmentEntryInstanceLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FragmentEntryInstanceLinkImpl
 * @see FragmentEntryInstanceLink
 * @see FragmentEntryInstanceLinkModel
 * @generated
 */
@ProviderType
public class FragmentEntryInstanceLinkModelImpl extends BaseModelImpl<FragmentEntryInstanceLink>
	implements FragmentEntryInstanceLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fragment entry instance link model instance should use the {@link FragmentEntryInstanceLink} interface instead.
	 */
	public static final String TABLE_NAME = "FragmentEntryInstanceLink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "fragmentEntryInstanceLinkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "fragmentEntryId", Types.BIGINT },
			{ "layoutPageTemplateEntryId", Types.BIGINT },
			{ "position", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("fragmentEntryInstanceLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fragmentEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("layoutPageTemplateEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("position", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table FragmentEntryInstanceLink (fragmentEntryInstanceLinkId LONG not null primary key,groupId LONG,fragmentEntryId LONG,layoutPageTemplateEntryId LONG,position INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table FragmentEntryInstanceLink";
	public static final String ORDER_BY_JPQL = " ORDER BY fragmentEntryInstanceLink.fragmentEntryInstanceLinkId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY FragmentEntryInstanceLink.fragmentEntryInstanceLinkId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.fragment.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.fragment.model.FragmentEntryInstanceLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.fragment.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.fragment.model.FragmentEntryInstanceLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.fragment.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.fragment.model.FragmentEntryInstanceLink"),
			true);
	public static final long FRAGMENTENTRYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long LAYOUTPAGETEMPLATEENTRYID_COLUMN_BITMASK = 4L;
	public static final long FRAGMENTENTRYINSTANCELINKID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.fragment.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.fragment.model.FragmentEntryInstanceLink"));

	public FragmentEntryInstanceLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fragmentEntryInstanceLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFragmentEntryInstanceLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fragmentEntryInstanceLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FragmentEntryInstanceLink.class;
	}

	@Override
	public String getModelClassName() {
		return FragmentEntryInstanceLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fragmentEntryInstanceLinkId",
			getFragmentEntryInstanceLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("fragmentEntryId", getFragmentEntryId());
		attributes.put("layoutPageTemplateEntryId",
			getLayoutPageTemplateEntryId());
		attributes.put("position", getPosition());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fragmentEntryInstanceLinkId = (Long)attributes.get(
				"fragmentEntryInstanceLinkId");

		if (fragmentEntryInstanceLinkId != null) {
			setFragmentEntryInstanceLinkId(fragmentEntryInstanceLinkId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long fragmentEntryId = (Long)attributes.get("fragmentEntryId");

		if (fragmentEntryId != null) {
			setFragmentEntryId(fragmentEntryId);
		}

		Long layoutPageTemplateEntryId = (Long)attributes.get(
				"layoutPageTemplateEntryId");

		if (layoutPageTemplateEntryId != null) {
			setLayoutPageTemplateEntryId(layoutPageTemplateEntryId);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}
	}

	@Override
	public long getFragmentEntryInstanceLinkId() {
		return _fragmentEntryInstanceLinkId;
	}

	@Override
	public void setFragmentEntryInstanceLinkId(long fragmentEntryInstanceLinkId) {
		_fragmentEntryInstanceLinkId = fragmentEntryInstanceLinkId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getFragmentEntryId() {
		return _fragmentEntryId;
	}

	@Override
	public void setFragmentEntryId(long fragmentEntryId) {
		_columnBitmask |= FRAGMENTENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFragmentEntryId) {
			_setOriginalFragmentEntryId = true;

			_originalFragmentEntryId = _fragmentEntryId;
		}

		_fragmentEntryId = fragmentEntryId;
	}

	public long getOriginalFragmentEntryId() {
		return _originalFragmentEntryId;
	}

	@Override
	public long getLayoutPageTemplateEntryId() {
		return _layoutPageTemplateEntryId;
	}

	@Override
	public void setLayoutPageTemplateEntryId(long layoutPageTemplateEntryId) {
		_columnBitmask |= LAYOUTPAGETEMPLATEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalLayoutPageTemplateEntryId) {
			_setOriginalLayoutPageTemplateEntryId = true;

			_originalLayoutPageTemplateEntryId = _layoutPageTemplateEntryId;
		}

		_layoutPageTemplateEntryId = layoutPageTemplateEntryId;
	}

	public long getOriginalLayoutPageTemplateEntryId() {
		return _originalLayoutPageTemplateEntryId;
	}

	@Override
	public int getPosition() {
		return _position;
	}

	@Override
	public void setPosition(int position) {
		_position = position;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FragmentEntryInstanceLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FragmentEntryInstanceLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FragmentEntryInstanceLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FragmentEntryInstanceLinkImpl fragmentEntryInstanceLinkImpl = new FragmentEntryInstanceLinkImpl();

		fragmentEntryInstanceLinkImpl.setFragmentEntryInstanceLinkId(getFragmentEntryInstanceLinkId());
		fragmentEntryInstanceLinkImpl.setGroupId(getGroupId());
		fragmentEntryInstanceLinkImpl.setFragmentEntryId(getFragmentEntryId());
		fragmentEntryInstanceLinkImpl.setLayoutPageTemplateEntryId(getLayoutPageTemplateEntryId());
		fragmentEntryInstanceLinkImpl.setPosition(getPosition());

		fragmentEntryInstanceLinkImpl.resetOriginalValues();

		return fragmentEntryInstanceLinkImpl;
	}

	@Override
	public int compareTo(FragmentEntryInstanceLink fragmentEntryInstanceLink) {
		long primaryKey = fragmentEntryInstanceLink.getPrimaryKey();

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

		if (!(obj instanceof FragmentEntryInstanceLink)) {
			return false;
		}

		FragmentEntryInstanceLink fragmentEntryInstanceLink = (FragmentEntryInstanceLink)obj;

		long primaryKey = fragmentEntryInstanceLink.getPrimaryKey();

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
		FragmentEntryInstanceLinkModelImpl fragmentEntryInstanceLinkModelImpl = this;

		fragmentEntryInstanceLinkModelImpl._originalGroupId = fragmentEntryInstanceLinkModelImpl._groupId;

		fragmentEntryInstanceLinkModelImpl._setOriginalGroupId = false;

		fragmentEntryInstanceLinkModelImpl._originalFragmentEntryId = fragmentEntryInstanceLinkModelImpl._fragmentEntryId;

		fragmentEntryInstanceLinkModelImpl._setOriginalFragmentEntryId = false;

		fragmentEntryInstanceLinkModelImpl._originalLayoutPageTemplateEntryId = fragmentEntryInstanceLinkModelImpl._layoutPageTemplateEntryId;

		fragmentEntryInstanceLinkModelImpl._setOriginalLayoutPageTemplateEntryId = false;

		fragmentEntryInstanceLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FragmentEntryInstanceLink> toCacheModel() {
		FragmentEntryInstanceLinkCacheModel fragmentEntryInstanceLinkCacheModel = new FragmentEntryInstanceLinkCacheModel();

		fragmentEntryInstanceLinkCacheModel.fragmentEntryInstanceLinkId = getFragmentEntryInstanceLinkId();

		fragmentEntryInstanceLinkCacheModel.groupId = getGroupId();

		fragmentEntryInstanceLinkCacheModel.fragmentEntryId = getFragmentEntryId();

		fragmentEntryInstanceLinkCacheModel.layoutPageTemplateEntryId = getLayoutPageTemplateEntryId();

		fragmentEntryInstanceLinkCacheModel.position = getPosition();

		return fragmentEntryInstanceLinkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{fragmentEntryInstanceLinkId=");
		sb.append(getFragmentEntryInstanceLinkId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", fragmentEntryId=");
		sb.append(getFragmentEntryId());
		sb.append(", layoutPageTemplateEntryId=");
		sb.append(getLayoutPageTemplateEntryId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.fragment.model.FragmentEntryInstanceLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fragmentEntryInstanceLinkId</column-name><column-value><![CDATA[");
		sb.append(getFragmentEntryInstanceLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fragmentEntryId</column-name><column-value><![CDATA[");
		sb.append(getFragmentEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutPageTemplateEntryId</column-name><column-value><![CDATA[");
		sb.append(getLayoutPageTemplateEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = FragmentEntryInstanceLink.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			FragmentEntryInstanceLink.class
		};
	private long _fragmentEntryInstanceLinkId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _fragmentEntryId;
	private long _originalFragmentEntryId;
	private boolean _setOriginalFragmentEntryId;
	private long _layoutPageTemplateEntryId;
	private long _originalLayoutPageTemplateEntryId;
	private boolean _setOriginalLayoutPageTemplateEntryId;
	private int _position;
	private long _columnBitmask;
	private FragmentEntryInstanceLink _escapedModel;
}