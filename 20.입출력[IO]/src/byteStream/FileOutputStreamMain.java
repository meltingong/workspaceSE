package byteStream;

import java.io.*;
/*
 * <<출력스트림(OutputStream)사용방법>>
 * 1. 데이타 목적지(target,destination) 선정(파일)
 * 2. 출력스트림(OutputStream)객체생성(FileOutputStream)
 * 3. 출력스트림(OutputStream)에 한바이트씩 쓴다(write)
 * 4. 출력스트림(OutputStream)닫는다.(close) 
 */
public class FileOutputStreamMain {

	public static void main(String[] args)throws Exception {
		
		FileOutputStream fos = new FileOutputStream(new File("src/bytestream/fileOut.dat"),true);
		/*
		 *  65		 --> 00000000|00000000|00000000|01000001
		 *  66  	 --> 00000000|00000000|00000000|01000010
		 *  67 		 --> 00000000|00000000|00000000|01000011
		 *  21483647 --> 01111111|11111111|11111111|11111111
		 */
		fos.write(65);
		fos.write(66);
		fos.write(0b00000000000000000000000001000011);
		fos.write(0b01111111111111111111111111111111);

		for(int i = 0; i < 256; i++) {
			fos.write(i);
		}
		
		fos.close();
		System.out.println("FileOutStream.write() --> fileOut.dat");
		
	}

}
