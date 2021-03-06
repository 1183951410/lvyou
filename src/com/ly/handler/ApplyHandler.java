package com.ly.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class ApplyHandler extends DefaultHandler {

	private String val = "";
	private String[] loginfo;
	private ArrayList<String[]> list = new ArrayList<String[]>();
	private String error;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (localName.equals("fid")) {
			loginfo = new String[5];
		}
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		Log.d("ly", localName + "===");
		// TODO Auto-generated method stub
		if (localName.equals("fid")) {
			loginfo[0] = val;
			// Log.d("ly", "fid: "+loginfo[0]);

		}
		if (localName.equals("uid")) {
			loginfo[1] = val;
			// Log.d("ly", "uid: "+loginfo[1]);

		}

		if (localName.equals("uname")) {
			loginfo[2] = val;
			// Log.d("ly", "name: "+loginfo[2]);
		}
		if (localName.equals("ueid")) {
			loginfo[3] = val;
			// Log.d("ly", "ueid: "+loginfo[3]);

		}
		if (localName.equals("fname")) {
			loginfo[4] = val;
			// Log.d("ly", "fame: "+loginfo[4]);
		}
		if (localName.equals("error")) {
			this.error = val;
		}
		if (localName.equals("fname")) {
			list.add(loginfo);
		}

		val = "";
		super.endElement(uri, localName, qName);
	}

	public String[] getLoginfo() {
		return loginfo;
	}

	public void setLoginfo(String[] loginfo) {
		this.loginfo = loginfo;
	}

	public ArrayList<String[]> getList() {
		return list;
	}

	public void setList(ArrayList<String[]> list) {
		this.list = list;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub

		val += new String(ch, start, length);
		super.characters(ch, start, length);

	}

}
