package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set hs1 = new HashSet();
		
		// 1000 
		
		int menu = 1;
		while(menu == 1) {	
			System.out.println("================================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("================================");
			System.out.print("메뉴선택 : ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.println();
				System.out.println("Lotto 구입 시작");
				System.out.println();
				System.out.println("1000원에 로또 번호 하나입니다.");
				System.out.print("금액 입력 : ");
				int money = sc.nextInt();
				
				int sum = money;

				System.out.println("행운의 로또 번호는 아래와 같습니다.");
				
				
				int i = 0;
				while(money >= 1000) {				
					Set<Integer> Lotto = new HashSet<Integer>();
					
					while (Lotto.size() < 6) {
						int num = (int)(Math.random() * 45 + 1);
						
						Lotto.add(num);
					}
					i++;
					System.out.println("로또번호" + i + " : " + Lotto);
					
					money = money-1000;
				}
				
				System.out.println("받은 금액은 " + sum + "원이고 거스름돈은 " + (money % 1000) + "원입니다.");
				
			}
		}
		System.out.println("감사합니다");
		
	}

}
