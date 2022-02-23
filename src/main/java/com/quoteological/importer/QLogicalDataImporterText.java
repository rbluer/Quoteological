package com.quoteological.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.quoteological.Quoteological;
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

	
	public File getRawFile() {

		File file = new File( getDataRawPath(), FILE_INPUT_BIBLE_ENG_VPL__ZIP_FILE );
		
		return file;
	}
	
	public boolean parseZipFile( File file ) {
		boolean results = false;
		
		int maxRecords = 10;
		
		if ( !file.exists() ) {
			Quoteological.getInstance().logError( 
					"Error: QLogicalDataImporterText.parseZipFile: File does not exist: %s ",
					file.getAbsolutePath()
					);
			return false;
		}
		
		try ( 
				ZipFile zin = new ZipFile( file );
			)
		{
			Enumeration<? extends ZipEntry> zipEntries = zin.entries();
			
			while ( zipEntries.hasMoreElements() ) {
				
				ZipEntry zEntry = zipEntries.nextElement();
				
				if ( zEntry.getName().equalsIgnoreCase( FILE_INPUT_BIBLE_ENG_VPL__ZIP_ENTRY ) ) {
					
					// We have the ZipEntry that we need to process!  :)
					
					try (
							BufferedReader br = new BufferedReader( new InputStreamReader( zin.getInputStream( zEntry )));
						) {
						
						int rows = 0;
						String line = br.readLine();
						while ( line != null && rows++ < maxRecords ) {
							
							// Process the data:
							int pos1 = line.indexOf( ' ' );
							int pos2 = pos1 == -1 ? -1 : line.indexOf( ':', pos1 );
							int pos3 = pos2 == -1 ? -1 : line.indexOf( ' ', pos2 );
							
							if ( pos1 != -1 && pos2 != -1 && pos3 != -1 ) {
								String book = line.substring( 0, pos1 );
								String chapter = line.substring( pos1 + 1, pos2 );
								String verse = line.substring( pos2 + 1, pos3 );
								String text = line.substring( pos3 + 1 );
								
								System.out.println( String.format( 
										"Book: %s  Chapter: %s  Verse: %s  TextLen: %d ", 
										book, chapter, verse, text.length() ));
							}
							
							line = br.readLine();
						}
						
					}
				}
			}
			
			results = true; // If we get here, then no errors occurred and reading was successful
		}
		catch ( FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		
		return results;
	}
	

	public File getDataRawPath() {
		return dataRawPath;
	}

	public File getDatabasePath() {
		return databasePath;
	}
	
}
