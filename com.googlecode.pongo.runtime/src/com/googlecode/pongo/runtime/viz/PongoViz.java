package com.googlecode.pongo.runtime.viz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public abstract class PongoViz {
	
	protected DBCollection collection;
	
	public PongoViz() {  }
	
	public PongoViz(DBCollection collection) {
		this.collection = collection;
	}
	
	public void setProjectCollection(DBCollection collection) {
		this.collection = collection;
	}
	
	abstract public String getViz(String type);
	
	/**
	 * FIXME: Currently tightly integrated with HMPs (i.e. __date)
	 * @param seriesKind
	 * @param seriesLabel
	 * @param xaxis
	 * @param yaxis
	 * @return
	 */
	protected String createDataTable(String seriesKind, String seriesLabel, String xaxis, String yaxis) {
		
		Iterator<DBObject> it = collection.find().iterator();
		
		List<List<Object>> dataTable = new ArrayList<List<Object>>();
		List<Object> headerRow = new ArrayList<Object>();
		dataTable.add(headerRow);
		
		while (it.hasNext()) {
			List<Object> row = new ArrayList<Object>();
			dataTable.add(row);
			
			// x-axis
			if (!headerRow.contains("\"Date\"")) headerRow.add("\"Date\"");
			DBObject dbobj = it.next();
			
			String x = (String)dbobj.get(xaxis);
			row.add(x);
			BasicDBList rd = (BasicDBList) dbobj.get(seriesKind);
			
			for (BasicDBObject bdbo : rd.toArray(new BasicDBObject[0])) {
				Object srs;
				if (seriesLabel.equals("")) {
					srs = "Series " + rd.indexOf(bdbo); 
				} else {
					srs = bdbo.get(seriesLabel);
				}
				String hdrName = "\"" + srs.toString() + "\"";
				if (!headerRow.contains(hdrName)) headerRow.add(hdrName);
				row.add(bdbo.get(yaxis));
			}
		}
		return dataTable.toString(); //FIXME: properly format this
	}
}
