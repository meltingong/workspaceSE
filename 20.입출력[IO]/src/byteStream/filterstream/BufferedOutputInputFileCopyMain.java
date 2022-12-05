package byteStream.filterstream;

import java.io.*;

public class BufferedOutputInputFileCopyMain {

	public static void main(String[] args) throws Exception{
		//buffer는 큰 파일이여도 빠르게 카피됨
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("B객체흐름.pdf"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("B객체흐름_copy2.pdf"));
		
		int byteCount = 0;
		int starCount = 0;
		while(true) {
			int readByte = bis.read();
			if(readByte == -1) break;
			byteCount++;
			if(byteCount%1024 == 0) {
				System.out.print("★");
				starCount++;
				if(starCount%20 == 0) {
					System.out.println();
				}
			}
			bos.write(readByte);
		}
		bis.close();
		bos.close();
		System.out.println("BufferedOutputInputFileCopy : "+ byteCount + " bytes copy!");
		
	}

}
