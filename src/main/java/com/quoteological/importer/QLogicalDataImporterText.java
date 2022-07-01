package com.quoteological.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import com.quoteological.Quoteological;
import com.quoteological.RBRPlugIn;
import com.quoteological.data.StandardizedFormatData;

public class QLogicalDataImporterText
{
	public static final String DATA_DIRECTORY_DATA_RAW = "dataraw";
	public static final String DATA_DIRECTORY_DATABASE = "database";
	
	public static final String FILE_INPUT_BIBLE_ENG_VPL__ZIP_FILE = "eng-web_vpl.zip";
	public static final String FILE_INPUT_BIBLE_ENG_VPL__ZIP_ENTRY = "eng-web_vpl.txt";
	
	
	public static final String FILE_OUTPUT_BIBLE_STD__ZIP_FILE = "stdinput_bible_eng.zip";
	public static final String FILE_OUTPUT_BIBLE_STD__ZIP_ENTRY = "bible_eng.txt";
	
	
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
	
	public File getStandardizedFile() {
		
		File file = new File( getDatabasePath(), FILE_OUTPUT_BIBLE_STD__ZIP_FILE );
		
		return file;
	}
	
	public boolean processRawInputFile( File inputFile, File outputFile ) {
		boolean results = false;
		
		if ( !inputFile.exists() ) {
			Quoteological.getInstance().logError( 
					"Error: QLogicalDataImporterText.parseZipFile: Input File does not exist: %s ",
					inputFile.getAbsolutePath()
					);
			return false;
		}
		
		if ( outputFile.exists() ) {
			Quoteological.getInstance().logError( 
					"Error: QLogicalDataImporterText.parseZipFile: Output File exists and will be replaced: %s ",
					outputFile.getAbsolutePath()
					);
		}
		
//		String message1 = "This is a test message. inputFile: " + inputFile.getName() + 
//						" outputFile: " + outputFile.getName();
//		
//		String message2 = String.format( 
//				"This is a test message. inputFile: %-20s size: %12d outputFile: %s", 
//				inputFile.getName(),
//				inputFile.length(),
//				outputFile.getName() );
//		
		
		try ( 
				ZipFile zin = new ZipFile( inputFile );
				
				ZipOutputStream zout = new ZipOutputStream( new FileOutputStream( outputFile ) );
			)
		{
//			ZipEntry zEntry = zin.getEntry( FILE_INPUT_BIBLE_ENG_VPL__ZIP_ENTRY );

			Enumeration<? extends ZipEntry> zipEntries = zin.entries();
			
			ZipEntry zEntryOut = new ZipEntry( FILE_OUTPUT_BIBLE_STD__ZIP_ENTRY );
			
			zout.putNextEntry(zEntryOut);
			
			while ( zipEntries.hasMoreElements() ) {
				
				
				ZipEntry zEntry = zipEntries.nextElement();
				
				if ( zEntry.getName().equalsIgnoreCase( FILE_INPUT_BIBLE_ENG_VPL__ZIP_ENTRY ) ) {
					
					// We have the ZipEntry that we need to process!  :)
					
					try (
							BufferedReader br = new BufferedReader( new InputStreamReader( zin.getInputStream( zEntry )));
						) {
						
						int rows = 0;
						String line = br.readLine();
						while ( line != null ) {
							
							// Process the data:
							int pos1 = line.indexOf( ' ' );
							int pos2 = pos1 == -1 ? -1 : line.indexOf( ':', pos1 );
							int pos3 = pos2 == -1 ? -1 : line.indexOf( ' ', pos2 );
							
							if ( pos1 != -1 && pos2 != -1 && pos3 != -1 ) {
								String book = line.substring( 0, pos1 );
								String chapter = line.substring( pos1 + 1, pos2 );
								String verse = line.substring( pos2 + 1, pos3 );
								String text = line.substring( pos3 + 1 );
								
//								System.out.println( String.format( 
//										"Book: %s  Chapter: %s  Verse: %s  TextLen: %d ", 
//										book, chapter, verse, text.length() ));
								
								// Create new data object
								StandardizedFormatData data = new StandardizedFormatData( 
										"Bible", "English", rows++, book, chapter, verse, text );
								
								// Convert to TSV
								String outputTsv = data.toTsv();
								
								// Convert to byte array
								byte[] output = outputTsv.getBytes();
								
								// write to output stream:
								zout.write(output, 0, output.length );
								
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
