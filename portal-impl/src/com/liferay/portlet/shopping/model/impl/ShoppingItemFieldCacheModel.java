/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.shopping.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.portlet.shopping.model.ShoppingItemField;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ShoppingItemField in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemField
 * @generated
 */
public class ShoppingItemFieldCacheModel implements CacheModel<ShoppingItemField>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{itemFieldId=");
		sb.append(itemFieldId);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", values=");
		sb.append(values);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ShoppingItemField toEntityModel() {
		ShoppingItemFieldImpl shoppingItemFieldImpl = new ShoppingItemFieldImpl();

		shoppingItemFieldImpl.setItemFieldId(itemFieldId);
		shoppingItemFieldImpl.setItemId(itemId);

		if (name == null) {
			shoppingItemFieldImpl.setName(StringPool.BLANK);
		}
		else {
			shoppingItemFieldImpl.setName(name);
		}

		if (values == null) {
			shoppingItemFieldImpl.setValues(StringPool.BLANK);
		}
		else {
			shoppingItemFieldImpl.setValues(values);
		}

		if (description == null) {
			shoppingItemFieldImpl.setDescription(StringPool.BLANK);
		}
		else {
			shoppingItemFieldImpl.setDescription(description);
		}

		shoppingItemFieldImpl.resetOriginalValues();

		return shoppingItemFieldImpl;
	}

	public void readExternal(ObjectInput objectInput) throws IOException {
		itemFieldId = objectInput.readLong();
		itemId = objectInput.readLong();
		name = objectInput.readUTF();
		values = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemFieldId);
		objectOutput.writeLong(itemId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (values == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(values);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long itemFieldId;
	public long itemId;
	public String name;
	public String values;
	public String description;
}