package practice;

public class EnumFruit {
	public enum Fruit {
		여름과일("수박"), 봄과일("딸기"), 가을과일("감"), 겨울과일("귤");

		private String fruit;

		Fruit(String data) {
			this.fruit = data;
		}

		public String getStr() {
			return fruit;
		}

	}
	
	public static void main(String[] args) {
		Fruit fruit1 = Fruit.여름과일;
		Fruit fruit2 = Fruit.겨울과일;
		Fruit fruit3 = Fruit.가을과일;
		Fruit fruit4 = Fruit.valueOf("봄과일");
		
		System.out.println(fruit1.name() + " ," + fruit1.getStr() + " ," + fruit1.ordinal());
		
		Fruit[] arr = Fruit.values(); // values() : 데이터를 배열로 가져온다 !!!!!!!
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i].name() + " : " + arr[i].getStr());
		}
		
	}
}
