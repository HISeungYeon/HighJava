package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T01ArrayListTest {
	public static void main(String[] args) {
		// Default Capacity = 10;
		List list1 = new ArrayList();
		
//		String str = new Scanner(System.in).next(); - 이것두 된다 !!
		
		// add()메서드를 사용해서 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111); // = list1.add(new Integer(111)); >> 객체로 바꾼 것 (객체화) : 레퍼클래스 ('랩핑한다' 와 같은 뜻)
		list1.add('k');
		list1.add(true);
		list1.add(12.34);


		// size() ==> 데이터 개수
		System.out.println("size =>" + list1.size());
		System.out.println("list1 =>" + list1);

		// get으로 데이터 꺼내오기
		System.out.println("1번째 자료 : " + list1.get(1)); // > 꺼낼 인덱스 번호를 적어줘야 한다.

		// 데이터 끼워 넣기도 같다
		list1.add(0, "zzz");
		System.out.println("list1 =>" + list1);

		// 데이터 변경하기 (set메서드)
		String temp = (String) list1.set(0, "YYY"); //? 왜 캐스팅 해줘야 한담?
		System.out.println("temp => " + temp);
		System.out.println("list1 => " + list1);

		// 삭제하기도 같다.
		list1.remove(0);
		System.out.println("삭제 후 : " + list1);

		// 111을 지정해서 지우고 싶다면??
		list1.remove(new Integer(111)); //(111) 안돼 !! 인덱스 번호로 인식함.
		System.out.println("111 삭제후 " + list1);

		// ----------------------------------------
		System.out.println("------------------------------------------");

		// 제너릭을 지정하여 선언할 수 있다.
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}

		System.out.println("-----------------------------------");

		// 향상된 for문 ( foreach문)
		for (String s : list2) {
			System.out.println(s);
		}

		// contains(비교객체); => 리스트에 '비교객체'를 찾아 '비교객체'가 있으면 true, 없으면 false 리턴함.
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));

		// indexOf(비교객체); => 리스트에서 '비교객체'를 찾아 '비교객체'가 있는 index값을 반환한다. 없으면 -1반환.
		System.out.println("DDD의 index값 : " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index 값 : " + list2.indexOf("ZZZ"));

		// toArray() => 리스트안의 데이터들을 배열로 변환하여 반환한다. 기본적으로 Object형 배열로 반환.
		Object[] strArr = list2.toArray();
		System.out.println("배열의 개수 : " + strArr.length);

		// 리스트의 제너릭 타입에 맞는 자료형의 배열로 변환하는 방법
		// 제너릭타입의 0개짜리 배열을 생성해서 배열변수로 넣어준다.
		// 형식) toArray(new 제너릭타입[0])
		String[] strArr2 = list2.toArray(new String[0]);
		System.out.println("strArr2의 개수 : " + strArr2.length);

		// 리스트 삭제처리
		for (int i = 0; i < list2.size(); i++) {
			list2.remove(list2.get(i));
		}
		System.out.println(list2.size()); // 0이 안나오는 이유는 뭘까 ? 내부에서 순서대로 지워지기 때문,,,, 
		//어떻게 하면 다 지울 수 있을까? 거꾸로 지우면 된다,,,,, 해보쟈 ;;45
	}

}
