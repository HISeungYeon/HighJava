package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T07EqualsHashcodeTest {
	/*
	 * 해시함수(hash function)는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수이다.
	 * 해시함수에 의해 얻어지는 값은 해시값, 해시코드, 해시체크섬 또는 간단하게 해시라고 한다.
	 * 
	 * HashSet, HashMap, Hashtable과 같은 객체들을 사용할 경우 객체가 서로 같은지를 비교하기 위해 equals()메서드와 hashCode() 메서드를 호출한다.
	 * 그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야 한다. 
	 * 객체가 같은지 여부는 데이터를 추가할 때 검사한다.
	 * 
	 * - equals()메서드와 hashCode()메서드에 관련된 규칙
	 * 1. 두 객체가 같으면 반드시 같은 hashcode를 가져야 한다.
	 * 2. 두 객체가 같으면 equals()호출했을 때 true를 반환해야 한다.
	 * 즉, 객체 a, b가 같다면 a.equals(b)와 b.equals(a) 둘다 true이어야 한다. 
	 * 3. 두 객체의 hashcode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
	 * but 두 객체가 같으면 반드시 hashCode가 같아야 한다.
	 * 4. equals()메서드를 override하면 반드시 hashCode()도 override해야 한다.
	 * 5. hashCode()는 기본적으로 Heap메모리에 있는 각 객체에 대한 메모리 주소 매핑정보를 기반으로 한 정수값을 반환한다.
	 * so, 클래서에서 hashCode() 메서드를 override하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
	 * 
	 */
	
	public static void main(String[] args) {
		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");
		
		System.out.println("Aa".hashCode());
		System.out.println("BB".hashCode()); //값은 틀리지만 해쉬코드가 같게 나올 수 있다.. 충돌!!
		
		
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2)); 
		// Object 관점에서는 equals랑 == 랑 같음 Person 관점에서는 객체 값이 같은지 비교하고 싶겠지
		// 그래서 우리만의 override가 필요해! 같다라고 해주기 위해 'hashCode' / 'hashSet을 써야하나봐;;
		System.out.println("p1 == p2 : " + (p1 ==p2));
		
		
		Set<Person> set = new HashSet<Person>();
		
		set.add(p1);
		set.add(p2);
		System.out.println("p1, p2 등록 후 데이터 : " );
		//방법1
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		//이렇게 해주면 값이 같아짐. 
		//방법 2
//		Iterator<Person> iter = set.iterator();
//		while(iter.hasNext()) {
//			Person p = iter.next();
//			System.out.println(p.getId() + " : " + p.getName());
//		}
		
		//띠용 근데 중복을 허용한다..? 이상해 !! 중복이 아니라고 판단해서 넣어버렸어 !! 
		//해결하기 위해  Person 클래스에서 override가 필요해!
		
		System.out.println("add(p3) 성공여부 : " + set.add(p3));
		System.out.println("add(p3) 후 데이터 : " );
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
		System.out.println("remove(p2) 성공여부: " + set.remove(p2));
		System.out.println("remove(p2) 후 데이터 : " );		
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
		
//		System.out.println(str.hashCode());
//		System.out.println(str.contentEquals(str)); - 0721
	}

}
//0722
class Person {
	private int id;
	private String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
//	@Override
//	public int hashCode() {
//		return (name + id).hashCode();
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		Person p = (Person) obj;
//		return this.getId() == p.getId() 
//				&& this.getName().equals(p.getName());
//	}
	
	//이걸 또 만들어주는게 있지
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}