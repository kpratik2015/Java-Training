package com.pratik.training.schedule;

public class TestSchedule {
	
	public static void main(String[] args) {
		Player p1 = new Player("Pat");
		Player p2 = new Player("Pat1");
		Player p3 = new Player("Pat2");
		Player p4 = new Player("Pat3");
		Player p5 = new Player("Pat4");
		Player p6 = new Player("Pat5");
		Player p7 = new Player("Pat6");
		Player p8 = new Player("Pat7");
		Player p9 = new Player("Pat8");
		
		Player[] players1 = new Player[] {p1,p3,p5};
		Player[] players2 = new Player[] {p2,p4,p6};
		Player[] players3 = new Player[] {p7,p8,p9};
		
		Team t1 = new Team("t1", players1);
		Team t2 = new Team("t2", players2);
		Team t3 = new Team("t3", players3);
		
		Match m1 = new Match(1,t1,t2,"01/08/2018","10 AM");
		Match m2 = new Match(2,t1,t3,"01/08/2018","2 PM");
		
		Match m3 = new Match(3,t3,t2,"02/08/2018","7 AM");
		Match m4 = new Match(4,t1,t2,"02/08/2018","3 PM");
		
		Schedule sc = new Schedule(new Match[] {m1, m2, m3, m4});
		
//		System.out.println(sc);
		
		sc.displaySchedulePlayerWise();
		
		sc.displayGameWise();

		sc.displayDayWise();
		
	}
	
}
