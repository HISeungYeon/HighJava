package practice;

import kr.or.ddit.basic.T02EnumTest.Season;

public class EnumPlanet {
	public enum Planet {
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		private long radius;

		Planet(long data) {
			radius = data;
		}

		public long getRadius() {
			return radius;
		}
	}

	public static void main(String[] args) {
		System.out.println("행성면적");
		Planet[] planet = Planet.values();
		for (int i = 0; i < planet.length; i++) {
			long area = (long)(4 * Math.PI * (planet[i].getRadius() * planet[i].getRadius()));
			System.out.println(planet[i].name() + " : " + area + "km²"); 
		}
	}

}
