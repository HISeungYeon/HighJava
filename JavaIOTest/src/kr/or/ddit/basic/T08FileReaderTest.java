package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

/*
 * 문자기반 스트림 예제
 */
public class T08FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		
		try {
			fr = new FileReader("d:/D_Other/testChar.txt");
			
			int data = 0;
			
			while((data = fr.read()) != -1) {
				System.out.print((char)data); 
				// 캐스팅을 안해주면 뭐더라? 문자를 못읽음 암튼 캐스팅 해줘야 함 
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
