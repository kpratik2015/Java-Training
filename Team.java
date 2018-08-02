package com.pratik.training.schedule;

import java.util.Arrays;

public class Team {
	
	private String team_name;
	private Player[] players;
	
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Team [team_name=" + team_name + ", players=" + Arrays.toString(players) + "]\n";
	}
	public Team(String team_name, Player[] players) {
		super();
//		associatePlayers(this);
		this.team_name = team_name;
		this.players = players;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
//	private void associatePlayers(Team t) {
//		for(Player p: t.getPlayers()) {
//			p.setTeam_name(t.getTeam_name());
//		}
//	}
	
	
}
