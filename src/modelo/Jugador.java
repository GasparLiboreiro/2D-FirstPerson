package modelo;

import java.util.ArrayList;

import util.Util;
import util.Vector2;

public class Jugador extends Obstaculo{
	public double r;
	public double vmovimiento=4;
	public double fov=0.25;  //radianes a cada lado del centro de la vista del jugador, total de 0.5 en caso de fov=0.25
	
	public Jugador(double x, double y, double rot, ArrayList<Vector2> vertices, ColorCl c) {
		super(x, y, rot, vertices, c);
	}
	public Jugador(double x, double y, double rot, ArrayList<Vector2> vertices, ArrayList<int[]> relaciones, ColorCl c) {
		super(x, y, rot, vertices, relaciones, c);
	}
	
	
	
	public ArrayList<Obstaculo> escenaFromThis(ArrayList<Obstaculo> escena){
		ArrayList<Obstaculo> out = new ArrayList<Obstaculo>();
		for(int x=0; x<escena.size(); x++) {
			out.add(escena.get(x).getObst().clone());
		//	System.out.println("obs:"+x);
			for(int y=0; y<out.get(x).getVertices().size(); y++) {
				Vector2 v = out.get(x).getVertices().get(y);
				double resx, resy;
				v.x-=this.getPos().x;
				v.y-=this.getPos().y;
				resx=Math.cos(Util.incVector(v) - this.rot * Math.PI) * Math.sqrt( Math.pow(v.x, 2) + Math.pow(v.y, 2) );
				resy=Math.sin(Util.incVector(v) - this.rot * Math.PI) * Math.sqrt( Math.pow(v.x, 2) + Math.pow(v.y, 2) );
				v.x=resx;
				v.y=resy;
				/*	System.out.println("   vert:"+y);
				System.out.println("      v:("+v.x+";"+v.y+")");
				System.out.println("      out:("+out.get(x).getVertices().get(y).x+";"+out.get(x).getVertices().get(y).y+")");
				System.out.println("      esc:("+escena.get(x).getObst().getVertices().get(y).x+";"+escena.get(x).getObst().getVertices().get(y).y+")");*/
			}
		}
		
		return out;
	}
	
}
