package com.quoteological.command;

import java.io.File;

import org.bukkit.command.CommandSender;

import com.quoteological.Quoteological;
import com.quoteological.importer.QLogicalDataImporterText;
import com.royalblueranger.blues.commands.BaseCommands;
import com.royalblueranger.blues.commands.Command;


public class CommandsQLogic
	extends BaseCommands
{
	
	public CommandsQLogic()
	{
		super( "qLogic" );
	}



	@Command( identifier = "quote test dirs", 
			description = "Simple test of directories",
			onlyPlayers = false )
	public void quoteTestDirCommand( CommandSender sender ) {
		
		String message = "### simple quoteological test Dirs ###";
		sender.sendMessage( message );
		
		QLogicalDataImporterText dImport = 
				new QLogicalDataImporterText( Quoteological.getInstance() );
		
		
		sender.sendMessage( dImport.getDataRawPath().getAbsolutePath() );
		sender.sendMessage( dImport.getDatabasePath().getAbsolutePath() );
		
		
//		Quoteological.getInstance().log( message );
	}
	
	@Command( identifier = "quote test parse", 
			description = "Simple test of directories",
			onlyPlayers = false )
	public void quoteTestParseCommand( CommandSender sender ) {
		
		String message = "### simple quoteological test Dirs ###";
		sender.sendMessage( message );
		
		QLogicalDataImporterText dImport = 
				new QLogicalDataImporterText( Quoteological.getInstance() );
		
		File inputFile = dImport.getRawFile();
		File outputFile = dImport.getStandardizedFile();
		
		dImport.processRawInputFile( inputFile, outputFile );

		
		
//		Quoteological.getInstance().log( message );
	}
	
	
	
	@Command( identifier = "quote test one", 
			description = "Just another command to test the command handler",
			onlyPlayers = false, 
			aliases = {"qu test one", "qu one", "qot one"} )
	public void quoteTestCommand( CommandSender sender ) {
		
		String message = "### simple quoteological test ###";
		
		sender.sendMessage( message );
		Quoteological.getInstance().log( message );
	}
	
	
}
