package util;

import java.awt.Color;
import java.util.ArrayList;

import modelo.Obstaculo;

public class Util {
	public static double incVector(Vector2 v) {
		double inclinacion=0;
		if(v.x!=0) {
			inclinacion = Math.atan(v.y / v.x);
			
			if(v.x<0)
				inclinacion+=Math.PI;
		}
		else if(v.y>0)
			inclinacion = 0.5 * Math.PI;
		else if(v.y<=0)
			inclinacion = 1.5 * Math.PI;
		
		return inclinacion;
	}
	
	public static Color colorWBrightnes(Color c, double b) {
		if(b>1 || b<0)
			throw new Error();
		return new Color((int)(c.getRed()*b), (int)(c.getGreen()*b), (int)(c.getBlue()*b));
	}
	
	
	public static void insertionSort(ArrayList<Obstaculo> lista, ArrayList<Double> valores){
		for(int x=1; x<lista.size(); x++) {
			for(int y=x; valores.get(y)<valores.get(y-1) && y>1; y--) {
				double b = valores.get(y);
				valores.set(y, valores.get(y-1));
				valores.set(y-1, b);
				
				Obstaculo o = lista.get(y);
				lista.set(y, lista.get(y-1));
				lista.set(y-1, o);
			}
		}
	}
	public static void insertionSortR(ArrayList<int[]> lista, ArrayList<Double> valores){
		for(int x=1; x<lista.size(); x++) {
			for(int y=x; valores.get(y)<valores.get(y-1) && y>1; y--) {
				double b = valores.get(y);
				valores.set(y, valores.get(y-1));
				valores.set(y-1, b);
				
				int[] o = lista.get(y);
				lista.set(y, lista.get(y-1));
				lista.set(y-1, o);
			}
		}
	}
}
