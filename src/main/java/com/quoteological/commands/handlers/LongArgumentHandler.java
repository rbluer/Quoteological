package com.quoteological.commands.handlers;

import org.bukkit.command.CommandSender;

import com.quoteological.commands.CommandArgument;
import com.quoteological.commands.TransformError;
import com.quoteological.messages.MgpqMessages;
import com.quoteological.messages.MgpqMessages.Messages;

public class LongArgumentHandler 
		extends NumberArgumentHandler<Long> {

    public LongArgumentHandler() {
    }

    @Override 
    public Long transform(CommandSender sender, CommandArgument argument, String value)
        throws TransformError {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new TransformError(
            		MgpqMessages.getMessage( sender, 
                			Messages.mgpq_commands_numberParseError, value )
            	);
        }
    }

}
