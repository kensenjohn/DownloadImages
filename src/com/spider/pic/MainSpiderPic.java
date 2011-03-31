package com.spider.pic;

import org.apache.log4j.Logger;

public class MainSpiderPic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting SpiderPic");
		
		String sPropFile = "";
		if(args!=null && args.length>0)
		{
			sPropFile = args[0];
		}
		else
		{
			sPropFile = "props/spiderpic.properties";
		}
		SpiderPic spiderPic = new SpiderPic();
		boolean isSuccess = spiderPic.bootstrap(sPropFile);
		
		
		if(isSuccess)
		{
			//System.out.println("Successful bootstrap = " + spiderPic);
			spiderPic.start();
		}
		
	}

}
