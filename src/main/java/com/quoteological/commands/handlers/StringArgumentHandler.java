/*
 *  Prison is a Minecraft plugin for the prison game mode.
 *  Copyright (C) 2017-2020 The Prison Team
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.quoteological.commands.handlers;

import org.bukkit.command.CommandSender;

import com.quoteological.commands.ArgumentHandler;
import com.quoteological.commands.ArgumentVerifier;
import com.quoteological.commands.CommandArgument;
import com.quoteological.commands.InvalidVerifyArgument;
import com.quoteological.commands.TransformError;
import com.quoteological.messages.MgpqMessages;
import com.quoteological.messages.MgpqMessages.Messages;

public class StringArgumentHandler 
		extends ArgumentHandler<String> {

    public StringArgumentHandler() {
        addVerifier("min", new ArgumentVerifier<String>() {
            @Override
            public void verify(CommandSender sender, CommandArgument argument, String verifyName,
                String[] verifyArgs, String value, String valueRaw) throws VerifyError {
                if (verifyArgs.length != 1) {
                    throw new InvalidVerifyArgument(argument.getName());
                }

                try {
                    int min = Integer.parseInt(verifyArgs[0]);
                    if (value.length() < min) {
                        throw new VerifyError(
                        	MgpqMessages.getMessage( sender, 
                            			Messages.mgpq_commands_tooFewCharacters,
                            			valueRaw, String.valueOf(min) )
                                );
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidVerifyArgument(argument.getName());
                }
            }
        });

        addVerifier("max", new ArgumentVerifier<String>() {
            @Override
            public void verify(CommandSender sender, CommandArgument argument, String verifyName,
                String[] verifyArgs, String value, String valueRaw) throws VerifyError {
                if (verifyArgs.length != 1) {
                    throw new InvalidVerifyArgument(argument.getName());
                }

                try {
                    int max = Integer.parseInt(verifyArgs[0]);
                    if (value.length() > max) {
                        throw new VerifyError(
                        	MgpqMessages.getMessage( sender, 
                            			Messages.mgpq_commands_tooManyCharacters,
                            			valueRaw, String.valueOf(max) )
                                );
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidVerifyArgument(argument.getName());
                }
            }
        });
    }

    @Override 
    public String transform(CommandSender sender, CommandArgument argument, String value)
        throws TransformError {
        return value;
    }
}
