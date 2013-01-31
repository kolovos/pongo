package org.googlecode.pongo.runtime;

import com.mongodb.DBObject;

public class Pongo {
	
	protected DBObject dbObject;
	
	protected String parseString(String str, String def) {
		if (str == null) return def;
		else return str;
	}
	
	protected int parseInteger(String str, int def) {
		if (str == null) return def;
		else {
			try {
				return Integer.parseInt(str);
			}
			catch (Exception ex) {
				return def;
			}
		}
	}
	
	protected long parseLong(String str, long def) {
		if (str == null) return def;
		else {
			try {
				return Long.parseLong(str);
			}
			catch (Exception ex) {
				return def;
			}
		}
	}
	
	protected boolean parseBoolean(String str, boolean def) {
		if (str == null) return def;
		else {
			try {
				return Boolean.parseBoolean(str);
			}
			catch (Exception ex) {
				return def;
			}
		}
	}
	
}
