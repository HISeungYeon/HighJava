package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	/*
	 * 와이드 카드에 대하여...
	 * 
	 * 와일드카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의 인수(Argument)로서,
	 * 함수선언, 객체생성 및 메서드를 정의할 때 사용된다.
	 * 
	 * <? extends T> => 와일드카드의 상한제한. T와 그 자손들만 가능
	 * <? super T> => 와일드카드의 하한제한. T와 그 조상들만 가능
	 * <?> => 모든 타입이 가능 <? extends Object>와 동일
	 */

	public static void main(String[] args) {
		//예시) 근데 왼쪽에 객체 생성할 땐 와일드카드 쓰면 안돼 !! 얘도 뭘 쓸진 알어야지..
//		List<?> list = new ArrayList<String>();
		
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Gabage> gabageBox = new FruitBox<>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); //타입체크가 일어나서 잘못넣었네 ~! 라고 알려줌

		gabageBox.add(new Gabage());
		gabageBox.add(new Gabage());
		gabageBox.add(new Gabage());

		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox); 
//		Juicer.makeJuice(gabageBox); // 다 들어가면 안되는데 !!! 그래서 extends로 제한 걸어주기 
			
	}
	
}


class Juicer{
//	static <T extends Fruit>void makeJuice(FruitBox<T> box) { //제네릭 메소드
	static void makeJuice(FruitBox<? extends Fruit> box) { 
		//와일드카드가 들어간 그냥 일반 메소드임, 와일드카드도 타입 제한 걸 수 있다!!
		
		String fruitListStr = ""; //과일목록
		
		int cnt = 0;
		
		for(Object f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			}else {
				fruitListStr += "," + f;
			}
			cnt++;
		}
		
		System.out.println(fruitListStr + " => 쥬스완둉 ʸᵉᵃʰ( ᐛ✌️)");
		
	}
}

class Fruit {
	private String name; //과일이름

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
	
	
}

class Apple extends Fruit {

	public Apple() {
		super("사과");
	}
	
}

class Grape extends Fruit {

	public Grape() {
		super("포도");
	}
	
}

class Gabage {
	
	@Override
	public String toString() {
		return "쓰레기";
	}
	
}


class FruitBox<T> {
	
	private List<T> fruitList = new ArrayList<>();

	public List<T> getFruitList() {
		return fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
		
	}
	
}













