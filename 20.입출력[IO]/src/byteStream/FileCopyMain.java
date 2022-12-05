package byteStream;

import java.io.*;
//파일 크면 오래걸림
public class FileCopyMain {

	public static void main(String[] args)throws Exception {
		String fileName = "B객체흐름.pdf";
		String copiedFileName = fileName.replace(".", "_copy.");
		
		FileInputStream fis  = new FileInputStream(fileName);
		FileOutputStream fos  = new FileOutputStream(copiedFileName);
		
		int byteCount = 0;
		int starCount = 0;
		while(true) {
			int readByte = fis.read();
			if(readByte == -1)break;
			byteCount++;
			if(byteCount%1024==0) {
				System.out.print("★");
				starCount++;
				if(starCount%20 == 0) {
					System.out.println();
				}
			}
			fos.write(readByte);
		}
		System.out.println();
		System.out.println("FileCopy : " + byteCount + "bytes copy");
		fis.close();
		fos.close();
		
	}

}
