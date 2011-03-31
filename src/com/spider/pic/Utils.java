package com.spider.pic;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;

public class Utils {

	public static HashMap<String,String> getDownloadedFile(String sFolderNames)
	{
		HashMap<String,String> hmFileName = new HashMap<String, String>();
		 File folder = new File(sFolderNames);
		 File[] listOfFiles = folder.listFiles();
		 
		 if(listOfFiles!=null)
		 {
			 for (int i = 0; i < listOfFiles.length; i++) {
				 if (listOfFiles[i].isFile()) {
					 System.out.println("File " + listOfFiles[i].getName());
					 String sFileName = listOfFiles[i].getName();
					 hmFileName.put(sFileName, sFileName);
				 } else if (listOfFiles[i].isDirectory()) {
					 System.out.println("Directory " + listOfFiles[i].getName());
				 }
			 }
		 }

		 
		
		return hmFileName;
	}
	
	 public static void getImages(String sPath, String sImageName, String sFolderPath) throws IOException {
	        String imagesRootPath = "http://www.mysite.com/images";
	        //for (String folder : folders) {
	            //for (int i = 1; i < 31; i++) {
	                URL url = new URL(sPath);
	                InputStream in = url.openStream();
	                OutputStream out = new BufferedOutputStream(new FileOutputStream(sFolderPath+"/"+sImageName));
	                for (int b; (b = in.read()) != -1; ) {
	                    out.write(b);
	                }
	                out.close();
	                in.close();
	               // System.out.println(String.format("Image %d.gif from folder %s has been successfully downloaded.", i, folder));
	           // }
	       // }
	    }
	
}
