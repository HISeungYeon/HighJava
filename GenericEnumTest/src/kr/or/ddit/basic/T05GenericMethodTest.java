package kr.or.ddit.basic;

class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {
		// 야! 나 숫자 클래스 상속받아서 쓸거야 !! 라고 extends를 사용해서 알려주고 범위를 제한을 거는 것

		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
		
	}
}

public class T05GenericMethodTest {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20); 
		//<> 안 쓴 이유는 매개변수 보고 알아서 들어갈거야..
		System.out.println(result1);
		
		int result2 = Util2.<Number>compare(3.14, 3);
		System.out.println(result2);
		
//		Util2.compare("C", "JAVA");
		//number랑 그의 자식 타입만 오도록 제한을 걸어서 에러가 뜨는 것
	}

}
