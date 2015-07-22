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

package com.liferay.portlet.expando.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ExpandoColumn service. Represents a row in the &quot;ExpandoColumn&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.expando.model.impl.ExpandoColumnModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.expando.model.impl.ExpandoColumnImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoColumn
 * @see com.liferay.portlet.expando.model.impl.ExpandoColumnImpl
 * @see com.liferay.portlet.expando.model.impl.ExpandoColumnModelImpl
 * @generated
 */
@ProviderType
public interface ExpandoColumnModel extends BaseModel<ExpandoColumn> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a expando column model instance should use the {@link ExpandoColumn} interface instead.
	 */

	/**
	 * Returns the primary key of this expando column.
	 *
	 * @return the primary key of this expando column
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this expando column.
	 *
	 * @param primaryKey the primary key of this expando column
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the column ID of this expando column.
	 *
	 * @return the column ID of this expando column
	 */
	public long getColumnId();

	/**
	 * Sets the column ID of this expando column.
	 *
	 * @param columnId the column ID of this expando column
	 */
	public void setColumnId(long columnId);

	/**
	 * Returns the company ID of this expando column.
	 *
	 * @return the company ID of this expando column
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this expando column.
	 *
	 * @param companyId the company ID of this expando column
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the table ID of this expando column.
	 *
	 * @return the table ID of this expando column
	 */
	public long getTableId();

	/**
	 * Sets the table ID of this expando column.
	 *
	 * @param tableId the table ID of this expando column
	 */
	public void setTableId(long tableId);

	/**
	 * Returns the name of this expando column.
	 *
	 * @return the name of this expando column
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this expando column.
	 *
	 * @param name the name of this expando column
	 */
	public void setName(String name);

	/**
	 * Returns the type of this expando column.
	 *
	 * @return the type of this expando column
	 */
	public int getType();

	/**
	 * Sets the type of this expando column.
	 *
	 * @param type the type of this expando column
	 */
	public void setType(int type);

	/**
	 * Returns the default data of this expando column.
	 *
	 * @return the default data of this expando column
	 */
	@AutoEscape
	public String getDefaultData();

	/**
	 * Sets the default data of this expando column.
	 *
	 * @param defaultData the default data of this expando column
	 */
	public void setDefaultData(String defaultData);

	/**
	 * Returns the type settings of this expando column.
	 *
	 * @return the type settings of this expando column
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this expando column.
	 *
	 * @param typeSettings the type settings of this expando column
	 */
	public void setTypeSettings(String typeSettings);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.portlet.expando.model.ExpandoColumn expandoColumn);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.portlet.expando.model.ExpandoColumn> toCacheModel();

	@Override
	public com.liferay.portlet.expando.model.ExpandoColumn toEscapedModel();

	@Override
	public com.liferay.portlet.expando.model.ExpandoColumn toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}