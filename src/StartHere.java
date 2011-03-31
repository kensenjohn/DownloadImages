import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;


public class StartHere {

	public static void main(String[] args)
	{
		//http://pimpandhost.com/site/generateImagesSitemap/page/36
		try {
			URL yahoo = new URL("http://pimpandhost.com/site/generateImagesSitemap/page/37");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(	yahoo.openStream()));

			String inputLine;
			
			PrintWriter pWiter = new PrintWriter(new FileWriter("/home/kensen/workspace/filename2.txt", true));

			while ((inputLine = in.readLine()) != null)
			{

				//if(inputLine.contains("http://ist1-3"))
				//{

					System.out.println(inputLine);
					pWiter.println(inputLine);
				//}
			}

			pWiter.flush();

			pWiter.close();
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
