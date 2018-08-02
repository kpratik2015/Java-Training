package com.pratik.training.schedule;

import java.util.ArrayList;
import java.util.Arrays;

public class Schedule {

	private Match[] matches;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	
	public Schedule(Match[] matches) {
		super();
		this.matches = matches;
	}
	
	public Match[] getMatches() {
		return matches;
	}
	public void setMatches(Match[] matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Schedule [matches=" + Arrays.toString(matches) + "]\n";
	}
	
	public void displayGameWise() {
		
		for(Match m : getMatches()) {
			System.out.println("----- MATCH "+ m.getMatch_id()+" -----");
			System.out.println(m.getTeam1());
			System.out.println(m.getTeam2());
		}
	}
	
	
	public void displayDayWise() {
		ArrayList<String> days = new ArrayList<>();
		for( Match m : getMatches() ) {
			if(!days.contains(m.getDate())) {
				days.add(m.getDate());
			}
		}
		
//		System.out.println(days);
		
		for(String dt : days) {
			System.out.println("DATE: " + dt);
			for( Match m : getMatches() ) {
				if(dt.equals(m.getDate())) {
					System.out.println(m);
				}
				
			}
		}
	}
	
	public void displaySchedulePlayerWise() {
		ArrayList<String> data = new ArrayList<>();
		for( Match m : getMatches()) {
			String temp;
			for( Player p : m.getTeam1().getPlayers() ) {
				temp = p.getPlayer_name()+"-"+m.getDate()+" "+m.getTime();
				if(!data.contains(temp))
					data.add(temp);
			}
			for( Player p : m.getTeam2().getPlayers() ) {
				temp = p.getPlayer_name()+"-"+m.getDate()+" "+m.getTime();
				if(!data.contains(temp))
					data.add(temp);
			}
		}
		ArrayList<String> players = new ArrayList<>();
		for( Match m : getMatches() ) {
			for( Player p : m.getTeam1().getPlayers() ) {
				if(!players.contains(p.getPlayer_name()))
					players.add(p.getPlayer_name());
			}
			for( Player p : m.getTeam2().getPlayers() ) {
				if(!players.contains(p.getPlayer_name()))
					players.add(p.getPlayer_name());
			}
		}
			
		for( String player : players ) {
			System.out.println("PLAYER: "+ player);
			for( String str : data ) {
				String[] splt = str.split("-");
				if(player.equals(splt[0])) {
					System.out.println(splt[1]);
				}
			}
		}
		
//		System.out.println(data);
		
	}
	
	
}
