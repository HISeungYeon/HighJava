package prac;

public class prac {
 
	public static void main(String[] args) {
	     String gender= "F";
	     String name = "jane";
	     boolean isAdult =  true;

	     if (gender == "M" && (name == "Mike" || isAdult)) {
	         System.out.println("통과");
	     } else {
	         System.out.println("돌아가");
	     }
	}
}
