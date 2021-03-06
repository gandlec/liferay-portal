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

package com.liferay.apio.architect.routes;

import static com.liferay.apio.architect.routes.RoutesTestUtil.FORM_BUILDER_FUNCTION;
import static com.liferay.apio.architect.routes.RoutesTestUtil.IDENTIFIER_FUNCTION;
import static com.liferay.apio.architect.routes.RoutesTestUtil.PROVIDE_FUNCTION;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;

import static java.util.Collections.singletonMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.liferay.apio.architect.alias.routes.DeleteItemConsumer;
import com.liferay.apio.architect.alias.routes.GetItemFunction;
import com.liferay.apio.architect.alias.routes.UpdateItemFunction;
import com.liferay.apio.architect.routes.ItemRoutes.Builder;
import com.liferay.apio.architect.single.model.SingleModel;
import com.liferay.apio.architect.uri.Path;

import java.util.Map;
import java.util.Optional;

import org.junit.Test;

/**
 * @author Alejandro Hernández
 */
public class ItemRoutesTest {

	@Test
	public void testEmptyBuilderBuildsEmptyRoutes() {
		Builder<String, Long> builder = new Builder<>(
			String.class, PROVIDE_FUNCTION, IDENTIFIER_FUNCTION);

		ItemRoutes<String> itemRoutes = builder.build();

		Optional<DeleteItemConsumer> deleteItemConsumerOptional =
			itemRoutes.getDeleteConsumerOptional();

		assertThat(deleteItemConsumerOptional, is(emptyOptional()));

		Optional<GetItemFunction<String>> getItemFunctionOptional =
			itemRoutes.getItemFunctionOptional();

		assertThat(getItemFunctionOptional, is(emptyOptional()));

		Optional<UpdateItemFunction<String>> updateItemFunctionOptional =
			itemRoutes.getUpdateItemFunctionOptional();

		assertThat(updateItemFunctionOptional, is(emptyOptional()));
	}

	@Test
	public void testFiveParameterBuilderMethodsCreatesValidRoutes() {
		Builder<String, Long> builder = new Builder<>(
			String.class, PROVIDE_FUNCTION, IDENTIFIER_FUNCTION);

		ItemRoutes<String> itemRoutes = builder.addGetter(
			this::_testAndReturnFourParameterGetterRoute, String.class,
			Long.class, Boolean.class, Integer.class
		).addRemover(
			this::_testFourParameterRemoverRoute, String.class, Long.class,
			Boolean.class, Integer.class
		).addUpdater(
			this::_testAndReturnFourParameterUpdaterRoute, String.class,
			Long.class, Boolean.class, Integer.class, FORM_BUILDER_FUNCTION
		).build();

		_testItemRoutes(itemRoutes);
	}

	@Test
	public void testFourParameterBuilderMethodsCreatesValidRoutes() {
		Builder<String, Long> builder = new Builder<>(
			String.class, PROVIDE_FUNCTION, IDENTIFIER_FUNCTION);

		ItemRoutes<String> itemRoutes = builder.addGetter(
			this::_testAndReturnThreeParameterGetterRoute, String.class,
			Long.class, Boolean.class
		).addRemover(
			this::_testThreeParameterRemoverRoute, String.class, Long.class,
			Boolean.class
		).addUpdater(
			this::_testAndReturnThreeParameterUpdaterRoute, String.class,
			Long.class, Boolean.class, FORM_BUILDER_FUNCTION
		).build();

		_testItemRoutes(itemRoutes);
	}

	@Test
	public void testOneParameterBuilderMethodsCreatesValidRoutes() {
		Builder<String, Long> builder = new Builder<>(
			String.class, PROVIDE_FUNCTION, IDENTIFIER_FUNCTION);

		ItemRoutes<String> itemRoutes = builder.addGetter(
			this::_testAndReturnNoParameterGetterRoute
		).addRemover(
			this::_testAndReturnNoParameterRemoverRoute
		).addUpdater(
			this::_testAndReturnNoParameterUpdaterRoute, FORM_BUILDER_FUNCTION
		).build();

		_testItemRoutes(itemRoutes);
	}

	@Test
	public void testThreeParameterBuilderMethodsCreatesValidRoutes() {
		Builder<String, Long> builder = new Builder<>(
			String.class, PROVIDE_FUNCTION, IDENTIFIER_FUNCTION);

		ItemRoutes<String> itemRoutes = builder.addGetter(
			this::_testAndReturnTwoParameterGetterRoute, String.class,
			Long.class
		).addRemover(
			this::_testTwoParameterRemoverRoute, String.class, Long.class
		).addUpdater(
			this::_testAndReturnTwoParameterUpdaterRoute, String.class,
			Long.class, FORM_BUILDER_FUNCTION
		).build();

		_testItemRoutes(itemRoutes);
	}

	@Test
	public void testTwoParameterBuilderMethodsCreatesValidRoutes() {
		Builder<String, Long> builder = new Builder<>(
			String.class, PROVIDE_FUNCTION, IDENTIFIER_FUNCTION);

		ItemRoutes<String> itemRoutes = builder.addGetter(
			this::_testAndReturnOneParameterGetterRoute, String.class
		).addRemover(
			this::_testOneParameterRemoverRoute, String.class
		).addUpdater(
			this::_testAndReturnOneParameterUpdaterRoute, String.class,
			FORM_BUILDER_FUNCTION
		).build();

		_testItemRoutes(itemRoutes);
	}

	private String _testAndReturnFourParameterGetterRoute(
		Long identifier, String string, Long aLong, Boolean aBoolean,
		Integer integer) {

		assertThat(integer, is(equalTo(2017)));

		return _testAndReturnThreeParameterGetterRoute(
			identifier, string, aLong, aBoolean);
	}

	private String _testAndReturnFourParameterUpdaterRoute(
		Long identifier, Map<String, Object> body, String string, Long aLong,
		Boolean aBoolean, Integer integer) {

		assertThat(integer, is(equalTo(2017)));

		return _testAndReturnThreeParameterUpdaterRoute(
			identifier, body, string, aLong, aBoolean);
	}

	private String _testAndReturnNoParameterGetterRoute(Long identifier) {
		assertThat(identifier, is(equalTo(42L)));

		return "Apio";
	}

	private void _testAndReturnNoParameterRemoverRoute(Long identifier) {
		assertThat(identifier, is(equalTo(42L)));
	}

	private String _testAndReturnNoParameterUpdaterRoute(
		Long identifier, Map<String, Object> body) {

		assertThat(identifier, is(equalTo(42L)));
		assertThat(body, is(equalTo(_body)));

		return "Updated";
	}

	private String _testAndReturnOneParameterGetterRoute(
		Long identifier, String string) {

		assertThat(string, is(equalTo("Apio")));

		return _testAndReturnNoParameterGetterRoute(identifier);
	}

	private String _testAndReturnOneParameterUpdaterRoute(
		Long identifier, Map<String, Object> body, String string) {

		assertThat(string, is(equalTo("Apio")));

		return _testAndReturnNoParameterUpdaterRoute(identifier, body);
	}

	private String _testAndReturnThreeParameterGetterRoute(
		Long identifier, String string, Long aLong, Boolean aBoolean) {

		assertThat(aBoolean, is(true));

		return _testAndReturnTwoParameterGetterRoute(identifier, string, aLong);
	}

	private String _testAndReturnThreeParameterUpdaterRoute(
		Long identifier, Map<String, Object> body, String string, Long aLong,
		Boolean aBoolean) {

		assertThat(aBoolean, is(true));

		return _testAndReturnTwoParameterUpdaterRoute(
			identifier, body, string, aLong);
	}

	private String _testAndReturnTwoParameterGetterRoute(
		Long identifier, String string, Long aLong) {

		assertThat(aLong, is(equalTo(42L)));

		return _testAndReturnOneParameterGetterRoute(identifier, string);
	}

	private String _testAndReturnTwoParameterUpdaterRoute(
		Long identifier, Map<String, Object> body, String string, Long aLong) {

		assertThat(aLong, is(equalTo(42L)));

		return _testAndReturnOneParameterUpdaterRoute(identifier, body, string);
	}

	private void _testFourParameterRemoverRoute(
		Long identifier, String string, Long aLong, Boolean aBoolean,
		Integer integer) {

		assertThat(integer, is(equalTo(2017)));

		_testThreeParameterRemoverRoute(identifier, string, aLong, aBoolean);
	}

	private void _testItemRoutes(ItemRoutes<String> itemRoutes) {
		Path path = new Path("name", "42");

		Optional<DeleteItemConsumer> deleteItemConsumerOptional =
			itemRoutes.getDeleteConsumerOptional();

		DeleteItemConsumer deleteItemConsumer =
			deleteItemConsumerOptional.get();

		deleteItemConsumer.apply(
			null
		).accept(
			path
		);

		Optional<GetItemFunction<String>> getItemFunctionOptional =
			itemRoutes.getItemFunctionOptional();

		GetItemFunction<String> getItemFunction = getItemFunctionOptional.get();

		SingleModel<String> singleModel = getItemFunction.apply(
			null
		).apply(
			path
		);

		assertThat(singleModel.getModelClass(), is(equalTo(String.class)));
		assertThat(singleModel.getModel(), is(equalTo("Apio")));

		Optional<UpdateItemFunction<String>> updateItemFunctionOptional =
			itemRoutes.getUpdateItemFunctionOptional();

		UpdateItemFunction<String> updateItemFunction =
			updateItemFunctionOptional.get();

		SingleModel<String> updatedSingleModel = updateItemFunction.apply(
			null
		).apply(
			path
		).apply(
			_body
		);

		assertThat(
			updatedSingleModel.getModelClass(), is(equalTo(String.class)));
		assertThat(updatedSingleModel.getModel(), is(equalTo("Updated")));
	}

	private void _testOneParameterRemoverRoute(Long identifier, String string) {
		assertThat(string, is(equalTo("Apio")));

		_testAndReturnNoParameterRemoverRoute(identifier);
	}

	private void _testThreeParameterRemoverRoute(
		Long identifier, String string, Long aLong, Boolean aBoolean) {

		assertThat(aBoolean, is(true));

		_testTwoParameterRemoverRoute(identifier, string, aLong);
	}

	private void _testTwoParameterRemoverRoute(
		Long identifier, String string, Long aLong) {

		assertThat(aLong, is(equalTo(42L)));

		_testOneParameterRemoverRoute(identifier, string);
	}

	private final Map<String, Object> _body = singletonMap("key", "value");

}