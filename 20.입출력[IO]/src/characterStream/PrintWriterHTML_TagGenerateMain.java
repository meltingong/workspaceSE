package characterStream;

import java.io.*;

public class PrintWriterHTML_TagGenerateMain {

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(new FileWriter("hello.html"));
		/*
		<html>
			<head>
				<title>나의HTML</title>
			</head>
			<body>
				<h1>안녕HTML[0]</h1><hr>
			</body>
		</html>
		*/
		out.println("<html>");
		out.println("<head>");
		out.println("<title>나의 HTML</title>");
		out.println("</head>");
		out.println("<body>");
		for(int i = 0; i <100; i++) {
			out.println("<h1>안녕HTML[" +(i + i) + "]</h1><br>");
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		System.out.println("PrintWriter --> hello.html");
		
		
		
	}

}
