package com.quoteological.data;

public class StandardizedFormatData {

	private String category;
	private String collection;
	private int row;
	private String group;
	private String section;
	private String line;
	private String text;
	
	/**
	 * category = Bible
		collection = kjv
		row = row
		group = book
		section = chapter
		line = verse
		text = text

	 */
	public StandardizedFormatData( String category, String collection, int row,
					String group, String section, String line, String text ) {
		super();
		
		this.category = category;
		this.collection = collection;
		
		this.row = row;
		this.group = group;
		this.section = section;
		this.line = line;
		this.text = text;
	}

	public String toTsv() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( getCategory() ).append( "\t" );
		sb.append( getCollection() ).append( "\t" );
		sb.append( getRow() ).append( "\t" );
		sb.append( getGroup() ).append( "\t" );
		sb.append( getSection() ).append( "\t" );
		sb.append( getLine() ).append( "\t" );
		sb.append( getText() ).append( "\n" );
		
		return sb.toString();
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

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
