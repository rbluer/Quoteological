package com.quoteological.data;

/**
 * <p>This enum will identify what the source of the settings.  If it's 
 * through the plugin, it will be marked as QLogic and will be subject to
 * auto updates.  If it's custom, then no updates or changes will be applied;
 * that entry will be ignored
 * </p>
 */
public enum QLogicSourceType {

	QLogic,
	
	custom;
}
