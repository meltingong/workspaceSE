package characterStream;

import java.io.*;

public class BufferedWriterReaderCopyMain {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("죄와벌.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("죄와벌[LINENO].txt"));
		int LineNo = 0;
		
		while(true) {
			String readLine = br.readLine();
			if(readLine == null	) break;
			readLine = readLine.replace("제이든", "보거스");
			LineNo++;
			bw.write("[" + LineNo + "]"+ readLine);
			bw.newLine();
			
		}
		bw.flush();
		
		br.close();
		bw.close();
		System.out.println("-------BufferedWriterReaderCopy " + LineNo + "LineCopy");
		
	}

}
