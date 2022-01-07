package com.quoteological.commands.handlers;

import org.bukkit.command.CommandSender;

import com.quoteological.commands.CommandArgument;
import com.quoteological.commands.TransformError;
import com.quoteological.messages.MgpqMessages;
import com.quoteological.messages.MgpqMessages.Messages;

public class IntegerClassArgumentHandler 
		extends NumberArgumentHandler<Integer> {

    public IntegerClassArgumentHandler() {
    }

    @Override public Integer transform(CommandSender sender, CommandArgument argument, String value)
    		throws TransformError {
    	Integer results = null;
    
    	if ( value != null ) {
    		
    		//value = value.replaceAll("$|%", "");
    		if ( value.trim().length() > 0 ) {
    			try {
    				results = Integer.parseInt(value);
    			} catch (NumberFormatException e) {
    				throw new TransformError(
    					MgpqMessages.getMessage( sender, 
    	                			Messages.mgpq_commands_numberParseError, value )
    	            	);
    			}
    		}
    	}
    	return results;
    }
}
