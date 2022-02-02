package com.quoteological.data;

/**
 * 
 * POJO - Plain Old Java Object 
 * Java Bean
 * Black box
 *
 */
public class QLogicCategoryConfig
{
	private String name;
	
	private String description;
	
	private QLogicSourceType sourceType;
	
	private String categoryDescription;   // ie. Bible 
	private String collectionDescription; // ie. Translations
	private String groupDescription;      // ie. Book
	private String sectionDescription;    // ie. Chapter
	private String lineDescription;       // ie. Verse
	
	public QLogicCategoryConfig() {
		super();
		
		this.sourceType = QLogicSourceType.QLogic;
	}

	public String getName() {
		return name;
	}
	public void setName( String name ) {		
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription( String description ) {
		this.description = description;
	}

	public QLogicSourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType( QLogicSourceType sourceType ) {
		this.sourceType = sourceType;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription( String categoryDescription ) {
		this.categoryDescription = categoryDescription;
	}

	public String getCollectionDescription() {
		return collectionDescription;
	}
	public void setCollectionDescription( String collectionDescription ) {
		this.collectionDescription = collectionDescription;
	}

	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription( String groupDescription ) {
		this.groupDescription = groupDescription;
	}

	public String getSectionDescription() {
		return sectionDescription;
	}
	public void setSectionDescription( String sectionDescription ) {
		this.sectionDescription = sectionDescription;
	}

	public String getLineDescription() {
		return lineDescription;
	}
	public void setLineDescription( String lineDescription ) {
		this.lineDescription = lineDescription;
	}
}
