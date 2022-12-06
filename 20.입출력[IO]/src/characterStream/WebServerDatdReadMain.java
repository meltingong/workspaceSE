package characterStream;

import java.io.*;
import java.net.*;

public class WebServerDatdReadMain {

	public static void main(String[] args) throws Exception {
		/***************************html(text)**********************/
		 URL urlStr = new URL("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MTRfODkg%2FMDAxNjYzMTI3ODA2NjE3.Hjvayqf6XPLAt94JPbcYEN220mcTH-p4aDVYXJdLRuwg.37zoPIZovQM7UpYv8u28YNjearImFiRNYvSEVsRdLC4g.JPEG.dldudqls95%2FIMG_0503.JPG&type=sc960_832"); 
		 InputStream in = urlStr.openStream();
		 FileOutputStream fout = new FileOutputStream("이동욱.jpg");
		 while(true) {
			 int readByte = in.read();
			 if(readByte == -1) break;
			 fout.write(readByte);
			// System.out.print((char)readByte);
			 
		 }
		 in.close();
		 fout.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
