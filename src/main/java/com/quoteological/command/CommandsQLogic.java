package com.quoteological.command;

import org.bukkit.command.CommandSender;

import com.quoteological.Quoteological;
import com.quoteological.commands.BaseCommands;
import com.quoteological.commands.Command;
import com.quoteological.importer.QLogicalDataImporterText;


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
