
package com.company.productappfrontend.domain;

import java.io.Serializable;


public class Category implements Serializable
{
	
	private String uuid;
	private String categoryName;
	
	public Category()
	{

	}

	public Category(final String name)
	{
		this.setCategoryName(name);
	}
	
	public String getCategoryUuid()
	{
		return this.uuid;
	}
	
	public void setCategoryUuid(final String uuid)
	{
		this.uuid = uuid;
	}
	
	public String getCategoryName()
	{
		return this.categoryName;
	}
	
	public void setCategoryName(final String name)
	{
		this.categoryName = name;
	}
	
}
