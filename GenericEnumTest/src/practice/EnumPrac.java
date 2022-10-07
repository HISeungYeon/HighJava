package practice;

public class EnumPrac {
	public enum City {
		서울, 부산, 대구, 광주, 대전
	} // 객체 선언

	public enum Season {
		봄("3월"), 여름("8월"), 가을("10월"), 겨울("12월");

		private String str;

		Season(String season) {
			str = season;
		}

		public String getStr() {
			return str;
		}
	}
	
	public static void main(String[] args) {
		City myCity1;
		City myCity2;
	}
}
