package com.spider.pic;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

public class DownloadThread{
	private SpiderPic spiderPic;
	public DownloadThread(SpiderPic spiderPic) {
		// TODO Auto-generated constructor stub
		this.spiderPic = spiderPic;
	}
	public void begin() {
		System.out.println(this.spiderPic);
		System.out.println("FileList = " + BaseObject.objectRegistry.hmMailFileList);
		
		String sAlgo = this.spiderPic.getsDownloadAlgo();
		if(sAlgo!=null && !"".equalsIgnoreCase(sAlgo))
		{
			if("xxxxxxx".equalsIgnoreCase(sAlgo))
			{
				beginAlgo1();
			}
		}
	}
	
	public void beginAlgo1()
	{
		try {
			int i = 0;
			while(true)
			{
				i++;
				Thread.sleep(3000); 
				URL yahoo = new URL(this.spiderPic.getsSiteName());
				
				BufferedReader in = new BufferedReader(new InputStreamReader(	yahoo.openStream()));

				String inputLine;
				
				//PrintWriter pWiter = new PrintWriter(new FileWriter("/home/kensen/workspace/filename2.txt", true));

				boolean isFound = false;
				String sPath = "";
				String sImgName = "";
				while ((inputLine = in.readLine()) != null)
				{

						if(inputLine.contains("http://xxx.xxx.xxx.xxx/pics/"))
						{
							//System.out.println(inputLine);
							
							StringTokenizer strToken = new StringTokenizer(inputLine, " ");
							
							 while (strToken.hasMoreElements())
							 {
								 String sText = strToken.nextToken();
								 if(sText.startsWith("src"))
								 {
									 sPath =  sText.substring(5,sText.lastIndexOf("'"));
								 }
								 else if(sText.startsWith("alt"))
								 {
									 sImgName = sText.substring(5,sText.lastIndexOf("'"));
								 }
							 }
							 isFound = true;
							break;
						}
						
				}
				
				if(isFound && sPath!=null && sImgName!=null && !"".equalsIgnoreCase(sPath) && !"".equalsIgnoreCase(sImgName))
				{
					String sArchiveName = BaseObject.objectRegistry.hmMailFileList.get(sImgName);
					if(sArchiveName==null)
					{
						System.out.println(i+") " + sImgName);
						BaseObject.objectRegistry.hmMailFileList.put(sImgName, sImgName);
						ImageThread imageThread = new ImageThread(sPath, sImgName, this.spiderPic.getsDownloadLocation());
						Thread thread = new Thread(imageThread);
						thread.start();
					}
				}
			}
			

	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
