/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistkickercode;

/**
 *
 * @author Lukas
 */

import java.awt.Point;

public class Zustand {
	Point[] stangePosition;
	Point ballPosition;
	int zeitpunkt;
	int toreTeam1;
	int toreTeam2;
	
	public Point[] getStangePosition() {
		return stangePosition;
	}
	public void setStangePosition(Point[] stangePosition) {
		this.stangePosition = stangePosition;
	}
	public Point getBallPosition() {
		return ballPosition;
	}
	public void setBallPosition(Point ballPosition) {
		this.ballPosition = ballPosition;
	}
	public int getZeitpunkt() {
		return zeitpunkt;
	}
	public void setZeitpunkt(int zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}
	public int getToreTeam1() {
		return toreTeam1;
	}
	public void setToreTeam1(int toreTeam1) {
		this.toreTeam1 = toreTeam1;
	}
	public int getToreTeam2() {
		return toreTeam2;
	}
	public void setToreTeam2(int toreTeam2) {
		this.toreTeam2 = toreTeam2;
	}
	
}

