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

package com.liferay.fragment.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.fragment.exception.DuplicateFragmentEntryException;
import com.liferay.fragment.exception.FragmentEntryContentException;
import com.liferay.fragment.exception.FragmentEntryNameException;
import com.liferay.fragment.model.FragmentCollection;
import com.liferay.fragment.model.FragmentEntry;
import com.liferay.fragment.service.FragmentCollectionServiceUtil;
import com.liferay.fragment.service.FragmentEntryServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.rule.SynchronousDestinationTestRule;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerTestRule;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jürgen Kappler
 */
@RunWith(Arquillian.class)
@Sync
public class FragmentEntryServiceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerTestRule.INSTANCE,
			SynchronousDestinationTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test(expected = DuplicateFragmentEntryException.class)
	public void testAddDuplicateFragmentEntries() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FragmentCollection fragmentCollection =
			FragmentCollectionServiceUtil.addFragmentCollection(
				_group.getGroupId(), "Fragment Collection", StringPool.BLANK,
				serviceContext);

		FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			"Fragment Entry", serviceContext);

		FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			"Fragment Entry", serviceContext);
	}

	@Test
	public void testAddFragmentEntry() throws PortalException {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FragmentCollection fragmentCollection =
			FragmentCollectionServiceUtil.addFragmentCollection(
				_group.getGroupId(), "Fragment Collection", StringPool.BLANK,
				serviceContext);

		FragmentEntry fragmentEntry = FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			"Fragment Entry", serviceContext);

		Assert.assertEquals("Fragment Entry", fragmentEntry.getName());
	}

	@Test(expected = FragmentEntryContentException.class)
	public void testAddFragmentEntryWithEmptyHTML() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FragmentCollection fragmentCollection =
			FragmentCollectionServiceUtil.addFragmentCollection(
				_group.getGroupId(), "Fragment Collection", StringPool.BLANK,
				serviceContext);

		FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			"Fragment Entry", null, null, null, serviceContext);
	}

	@Test(expected = FragmentEntryNameException.class)
	public void testAddFragmentEntryWithEmptyName() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FragmentCollection fragmentCollection =
			FragmentCollectionServiceUtil.addFragmentCollection(
				_group.getGroupId(), "Fragment Collection", StringPool.BLANK,
				serviceContext);

		FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			StringPool.BLANK, serviceContext);
	}

	@Test(expected = FragmentEntryNameException.class)
	public void testAddFragmentEntryWithNullName() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FragmentCollection fragmentCollection =
			FragmentCollectionServiceUtil.addFragmentCollection(
				_group.getGroupId(), "Fragment Collection", StringPool.BLANK,
				serviceContext);

		FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			null, serviceContext);
	}

	@Test
	public void testAddMultipleFragmentEntries() throws PortalException {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FragmentCollection fragmentCollection =
			FragmentCollectionServiceUtil.addFragmentCollection(
				_group.getGroupId(), "Fragment Collection", StringPool.BLANK,
				serviceContext);

		List<FragmentEntry> originalFragmentEntries =
			FragmentEntryServiceUtil.fetchFragmentEntries(
				fragmentCollection.getFragmentCollectionId());

		FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			"Fragment Entry 1", serviceContext);

		FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			"Fragment Entry 2", serviceContext);

		List<FragmentEntry> actualFragmentEntries =
			FragmentEntryServiceUtil.fetchFragmentEntries(
				fragmentCollection.getFragmentCollectionId());

		Assert.assertEquals(
			actualFragmentEntries.toString(),
			originalFragmentEntries.size() + 2, actualFragmentEntries.size());
	}

	@Test
	public void testDeleteFragmentEntry() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FragmentCollection fragmentCollection =
			FragmentCollectionServiceUtil.addFragmentCollection(
				_group.getGroupId(), "Fragment Collection", StringPool.BLANK,
				serviceContext);

		FragmentEntry fragmentEntry = FragmentEntryServiceUtil.addFragmentEntry(
			_group.getGroupId(), fragmentCollection.getFragmentCollectionId(),
			"Fragment Entry", serviceContext);

		FragmentEntryServiceUtil.deleteFragmentEntry(
			fragmentEntry.getFragmentEntryId());

		Assert.assertNull(
			FragmentEntryServiceUtil.fetchFragmentEntry(
				fragmentEntry.getFragmentEntryId()));
	}

	@DeleteAfterTestRun
	private Group _group;

}