package characterStream;

import java.io.*;

public class FileWriterReaderMain {

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("fileWriter.txt");
		
		fw.write(44356);
		fw.write('A');
		fw.write('김');
		
		for(int i = 0; i < 65536; i++) {
			fw.write(i);
			if(i%100 == 0) {
				fw.write('\n');
			}
		}
		
		fw.write('\n');
		fw.write("문자열을 맘대로 막써요");
		fw.write('\n');
		
		
		
		
	}

}
