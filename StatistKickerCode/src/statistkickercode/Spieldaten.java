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
import java.util.List;

public class Spieldaten {
	List<Zustand> spielverlauf;
	StatistikGenerator statGen;
	Heatmap heatmap;
        
	public List<Zustand> getSpielverlauf() {
		return spielverlauf;
	}
	public void setSpielverlauf(List<Zustand> spielverlauf) {
		this.spielverlauf = spielverlauf;
	}
	public StatistikGenerator getStatGen() {
		return statGen;
	}
	public void setStatGen(StatistikGenerator statGen) {
		this.statGen = statGen;
	}
	public Heatmap getHeatmap() {
		return heatmap;
	}
	public void setHeatmap(Heatmap heatmap) {
		this.heatmap = heatmap;
	}
}
