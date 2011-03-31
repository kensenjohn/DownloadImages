package com.spider.pic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SpiderPic {
	private String sPropFile = "";
	private String sDownloadLocation = "";
	private String sSiteName = "";
	private String sDownloadAlgo = "";
	public boolean bootstrap(String sPropFile)
	{
		boolean isSuccess = true;
		this.sPropFile = sPropFile;
		
		Properties properties = new Properties();
		try {
		    properties.load(new FileInputStream(this.sPropFile));
		} catch (IOException e) {
			e.printStackTrace();
			isSuccess = false;
			return isSuccess;
		}
		

        this.sDownloadLocation = properties.getProperty("download_location");
        this.sSiteName = properties.getProperty("site_name");
        this.sDownloadAlgo = properties.getProperty("download_algo");
        
        BaseObject.objectRegistry.hmMailFileList = Utils.getDownloadedFile(this.sDownloadLocation);
        
        return isSuccess;
	}
	
	public void start()
	{
		DownloadThread downloader = new DownloadThread(this);
		downloader.begin();
	}
	
	
	
	public String getsDownloadLocation() {
		return sDownloadLocation;
	}

	public void setsDownloadLocation(String sDownloadLocation) {
		this.sDownloadLocation = sDownloadLocation;
	}

	public String getsSiteName() {
		return sSiteName;
	}

	public void setsSiteName(String sSiteName) {
		this.sSiteName = sSiteName;
	}

	public String getsDownloadAlgo() {
		return sDownloadAlgo;
	}

	public void setsDownloadAlgo(String sDownloadAlgo) {
		this.sDownloadAlgo = sDownloadAlgo;
	}

	@Override
	public String toString() {
		return "SpiderPic [sPropFile=" + sPropFile + ", sDownloadLocation="
				+ sDownloadLocation + ", sSiteName=" + sSiteName
				+ ", sDownloadAlgo=" + sDownloadAlgo + "]";
	}

}
