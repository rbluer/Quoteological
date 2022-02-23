package com.quoteological.importer;

import java.io.File;

import com.quoteological.RBRPlugIn;

public class QLogicalDataImporterText
{
	public static final String DATA_DIRECTORY_DATA_RAW = "dataraw";
	public static final String DATA_DIRECTORY_DATABASE = "database";
	
	public static final String FILE_INPUT_BIBLE_ENG_VPL__ZIP_FILE = "eng-web_vpl.zip";
	public static final String FILE_INPUT_BIBLE_ENG_VPL__ZIP_ENTRY = "eng-web_vpl.txt";
	
	
	private File dataRawPath;
	private File databasePath;
	
	private RBRPlugIn plugin;

	public QLogicalDataImporterText( RBRPlugIn plugin ) {
		super();
		
		this.plugin = plugin;
		
		initialize();
	}
	
	
	private void initialize() {
		
		// create folders
		File projectPath = plugin.getDataFolder();
		
		this.dataRawPath = new File( projectPath, DATA_DIRECTORY_DATA_RAW );
		this.databasePath = new File( projectPath, DATA_DIRECTORY_DATABASE );
		
		if ( !dataRawPath.exists() ) {
			dataRawPath.mkdirs();
		}
		if ( !databasePath.exists() ) {
			databasePath.mkdirs();
		}
		
	}

	

	public File getDataRawPath() {
		return dataRawPath;
	}

	public File getDatabasePath() {
		return databasePath;
	}
	
}
