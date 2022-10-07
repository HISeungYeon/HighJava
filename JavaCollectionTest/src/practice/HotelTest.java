package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	private Scanner scan;
	private Map<String, Hotel> hotelTestMap;

	public HotelTest() {
		scan = new Scanner(System.in);
		hotelTestMap = new HashMap<String, Hotel>();
	}

	public void displayMenu() {
		System.out.println("******************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("******************************");
		System.out.print("메뉴선택 : ");
	}
	
	public void HotelStart() {
		System.out.println("******************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("******************************");
		System.out.println();
		
		while(true) {
			
			displayMenu();
			
			int menuNum = scan.nextInt();
			
			switch(menuNum) {
			case 1 : checkIn(); //체크인
				break;
			case 2 : checkOut();
				break;
			case 3 : room();
				break;
			case 4 : 
				System.out.println("******************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("******************************");
				return;
			default : 
				System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
	}

	private void room() {
		Set<String> keySet = hotelTestMap.keySet();
		
		if(keySet.size() == 0) {
			System.out.println("등록된 객실이 없습니다.");
		}else {
			Iterator<String> it = keySet.iterator();
//			int cnt = 0;
			while(it.hasNext()) {
//				cnt++;
				String name = it.next();
				Hotel h = hotelTestMap.get(name);
				System.out.println("방번호 : " + h.getNum() + ", 투숙객 : " + h.getName());
			}
		}
		
	}

	private void checkOut() {
		System.out.println();
		System.out.println("어느방에 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		String num = scan.next();
		
		//이미 등록된 방번호인가?
		//get()메서드로 값을 가져올 때 가져올 자료가 없으면 null 반환
		if(hotelTestMap.remove(num) == null) {
			System.out.println(num + "은 정보가 없습니다");		
		}else {
			System.out.println("체크아웃 되었습니다.");
		}
		
	}

	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		String num = scan.next();
		
		//이미 등록된 방번호인가?
		//get()메서드로 값을 가져올 때 가져올 자료가 없으면 null 반환
		if(hotelTestMap.get(num) != null) {
			System.out.println(num + "은 이미 등록된 방입니다.");
			
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 : ");
		String name = scan.next();
		
		hotelTestMap.put(num, new Hotel(num, name));
		
		System.out.println("체크인 되었습니다.");
		
	}

	public static void main(String[] args) {
		new HotelTest().HotelStart();

	}
}

class Hotel {
	private String num; // 방번호
	private String name; // 이름

	public Hotel(String num, String name) {
		this.num = num;
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [num=" + num + ", name=" + name + "]";
	}

}
