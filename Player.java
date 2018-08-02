package com.pratik.training.schedule;

public class Player {
	
	private String player_name;
//	private String team_name;
	
//	public String getTeam_name() {
//		return team_name;
//	}
//
//	public void setTeam_name(String team_name) {
//		this.team_name = team_name;
//	}

	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public Player(String player_name) {
		super();
		this.player_name = player_name;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	@Override
	public String toString() {
		return "Player [player_name=" + player_name + "]";
	}

	
	
}
