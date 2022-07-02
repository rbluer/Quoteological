package com.quoteological.blues.commands.handlers;

import org.bukkit.command.CommandSender;

import com.quoteological.blues.commands.CommandArgument;
import com.quoteological.blues.commands.TransformError;
import com.quoteological.blues.messages.CommandMessages;
import com.quoteological.blues.messages.CommandMessages.Messages;

public class DoubleClassArgumentHandler 
		extends NumberArgumentHandler<Double> {

    public DoubleClassArgumentHandler() {
    }

    @Override 
    public Double transform(CommandSender sender, CommandArgument argument, String value)
    		throws TransformError {
    	Double results = null;
    
    	if ( value != null ) {
    		
    		value = value.replaceAll("$|%", "");
    		if ( value.trim().length() > 0 ) {
    			try {
    				results = Double.parseDouble(value);
    			} catch (NumberFormatException e) {
    				throw new TransformError(
    						CommandMessages.getMessage( sender, 
    	                			Messages.mgpq_commands_numberParseError, value )
    	            	);
    			}
    		}
    	}
    	return results;
    }

}
