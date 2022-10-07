package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentExample {

	public static void main(String[] args) {

		List<Student> stuList = new ArrayList<Student>();

		stuList.add(new Student("105", "고급", 100, 100, 100));
		stuList.add(new Student("103", "하이루", 90, 90, 95));
		stuList.add(new Student("101", "문상훈", 100, 90, 95));
		stuList.add(new Student("102", "미노이", 90, 98, 95));
		stuList.add(new Student("104", "자바", 95, 100, 90));

		Collections.sort(stuList);
		System.out.println("학번 오름차순");
		for (Student stu : stuList) {
			System.out.println(stu);
		}
		
		System.out.println("------------------------------------------------------------------------");
		
		Collections.sort(stuList, new StudentTotal());
		
		System.out.println("총점역순");
		int i=0;
		for(Student stu : stuList) {
			i++;
			System.out.println(i + "등");
			System.out.println(stu);
		}

	}

}

class StudentTotal implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		if (stu1.getTotal() > stu2.getTotal()) {
			return -1;
		} else if (stu1.getTotal() == stu2.getTotal()) {
			return stu1.getNum().compareTo(stu2.getNum()) * -1;
		} else {
			return 1;
		}
	}

}

class Student implements Comparable<Student> {
	private String num; // 학번
	private String name; // 이름
	private int korean; // 국어
	private int english; // 영어
	private int math; // 수학
	private int total; // 총점
	private int rank; //등수 - 구글링해보기 ㅋㅋ '자바 순위 정렬'




	public Student(String num, String name, int korean, int english, int math) {
		super();
		this.num = num;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.total = korean + english + math;
		this.rank = rank;
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


	public int getKorean() {
		return korean;
	}


	public void setKorean(int korean) {
		this.korean = korean;
	}


	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return "학번 : " + num + ", 이름 : " + name + ", 국어점수 : " + korean + ", 영어점수 : " + english + ", 수학점수 : " + math +" 총점 : " + total;
	}

	@Override
	public int compareTo(Student stu) {

		return this.getNum().compareTo(stu.getNum());
	}

}