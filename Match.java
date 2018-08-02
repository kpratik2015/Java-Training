package com.pratik.training.schedule;

public class Match {
	
	private int match_id;
	private Team team1;
	private Team team2;
	private String date;
	private String time;
	
	public Match() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Match [match_id=" + match_id + ", team1=" + team1 + ", team2=" + team2 + ", date=" + date + ", time="
				+ time + "]\n";
	}
	public Match(int match_id, Team team1, Team team2, String date, String time) {
		super();
		this.match_id = match_id;
		this.team1 = team1;
		this.team2 = team2;
		this.date = date;
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	
	

}
