package com.ly.bean;

import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.util.Log;

import com.ly.handler.LoginHandler;



public class LoginBean {
	String result="";
	public String password( InputStream in){
		SAXParserFactory sf = SAXParserFactory.newInstance();
//		StringBuilder sb = new StringBuilder();
		try {
			
			XMLReader xr = sf.newSAXParser().getXMLReader();
			LoginHandler vh = new LoginHandler();
			Log.d("ly", "0id:" + vh.getId() + "name:" + vh.getName());
			xr.setContentHandler(vh);
			
			Log.d("ly", "1id:" + vh.getId() + "name:" + vh.getName());
			xr.parse(new InputSource(in));
			Log.d("ly", "2id:" + vh.getId() + "name:" + vh.getName());
			if(vh.getError()!=null){
				result="error";
			}else{
				result =vh.getId()+","+vh.getName()+","+vh.getUname();
			}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

	
}
