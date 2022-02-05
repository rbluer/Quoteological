package com.quoteological.data;

public class QLogicCollectionFileConfig {
	private String category;

	private String collection;

	private String dataSourceDescription;

	private String dataSourceUrl;

	private String dataSourceRetrivalDate;

	private String dataParser;

	public QLogicCollectionFileConfig() {
		super();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getDataSourceDescription() {
		return dataSourceDescription;
	}

	public void setDataSourceDescription(String dataSourceDescription) {
		this.dataSourceDescription = dataSourceDescription;
	}

	public String getDataSourceUrl() {
		return dataSourceUrl;
	}

	public void setDataSourceUrl(String dataSourceUrl) {
		this.dataSourceUrl = dataSourceUrl;
	}

	public String getDataSourceRetrivalDate() {
		return dataSourceRetrivalDate;
	}

	public void setDataSourceRetrivalDate(String dataSourceRetrivalDate) {
		this.dataSourceRetrivalDate = dataSourceRetrivalDate;
	}

	public String getDataParser() {
		return dataParser;
	}

	public void setDataParser(String dataParser) {
		this.dataParser = dataParser;
	}

}