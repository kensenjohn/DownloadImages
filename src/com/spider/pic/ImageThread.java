package com.spider.pic;

import java.io.IOException;

public class ImageThread implements Runnable {

	private String sPath = "";
	private String sImgName = "";
	private String sDownloadLocation = "";
	
	public ImageThread(String sPath, String sImgName, String sDownloadLocation) {
		super();
		this.sPath = sPath;
		this.sImgName = sImgName;
		this.sDownloadLocation = sDownloadLocation;
	}

	@Override
	public void run() {
		
		try {
			Utils.getImages(sPath, sImgName, sDownloadLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
