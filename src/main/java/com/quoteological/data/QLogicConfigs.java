package com.quoteological.data;

import java.util.TreeMap;

public class QLogicConfigs
{
	private TreeMap<String, QLogicCategoryConfig> categories;
	
	public QLogicConfigs() {
		super();
		
		this.categories = new TreeMap<>();
	}

	public TreeMap<String, QLogicCategoryConfig> getCategories()
	{
		return categories;
	}

	public void setCategories( TreeMap<String, QLogicCategoryConfig> categories )
	{
		this.categories = categories;
	}
	
}
