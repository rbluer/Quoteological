package com.quoteological.command;

import org.bukkit.command.CommandSender;

import com.quoteological.Quoteological;
import com.quoteological.commands.BaseCommands;
import com.quoteological.commands.Command;

public class CommandsMgpqCore
		extends BaseCommands
{
	
	public CommandsMgpqCore() {
		super("core" );
	}
	
	
	@Command( identifier = "pq version", 
				description = "Displays this plugins version and other details",
				onlyPlayers = false )
	public void versionInformationCommand( CommandSender sender ) {
		
		String message = String.format( "Mini-Game Player Queue: version %s ", 
				Quoteological.getInstance().getPluginVersion() );
		
		sender.sendMessage( message );
		Quoteological.getInstance().log( message );
	}
	
	
	@Command( identifier = "pq pets cats",
			aliases = {"cute kittens", "cats"},
			onlyPlayers = false )
	public void pqCatsCommand( CommandSender sender ) {
		sender.sendMessage( "oof cats" );
	}
	@Command( identifier = "pq pets dogs",
			aliases = {"cute puppies", "dogs", "pq pets doggos"},
			onlyPlayers = false )
	public void pqDogsCommand( CommandSender sender ) {
		sender.sendMessage( "oof dogs" );
	}

	
	@Command( identifier = "mgpq test", 
			description = "Just another command to test the command handler",
			onlyPlayers = false )
	public void mgpqTest1Command( CommandSender sender ) {
		
		String message = "### simple test ###";
		
		sender.sendMessage( message );
		Quoteological.getInstance().log( message );
	}
	
	@Command( identifier = "mgpq more", 
			description = "Just another command to test the command handler",
			onlyPlayers = false )
	public void mgpqTest2Command( CommandSender sender ) {
		
		String message = "### simple test - more ###";
		
		sender.sendMessage( message );
		Quoteological.getInstance().log( message );
	}
	
	
	@Command( identifier = "mgpq more stuff", 
			description = "Just another command to test the command handler",
			onlyPlayers = false )
	public void mgpqTest3Command( CommandSender sender ) {
		
		String message = "### simple test - more stuff ###";
		
		sender.sendMessage( message );
		Quoteological.getInstance().log( message );
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
