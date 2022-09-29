package modelo;

import java.awt.Color;
import java.util.ArrayList;

import util.Util;
import util.Vector2;

public class Obstaculo {
	private ArrayList<Vector2> vertices;
	private ArrayList<int[]> relaciones;
	private Vector2  pos, 					//pos actual del objeto
					vel = new Vector2(0,0), //velocidad instantanea del objeto
					asc = new Vector2(0,0); //asceleracion del objeto
	public double rot;
	public double vrot=0;
	public double arot=0;
	private ColorCl c;
	
	
	public Obstaculo(double x, double y, double inc, ArrayList<Vector2> vertices, ArrayList<int[]> relaciones, ColorCl c) {
		this.pos = new Vector2(x,y);
		this.rot=inc;
		if(c!=null)
			this.c = c;
		else
			this.c = new ColorCl(255,255,255);
		this.vertices=vertices;
		this.relaciones=relaciones;
	}
	
	public Obstaculo(double X, double y, double inc, ArrayList<Vector2> vertices, ColorCl c) {
		this.pos = new Vector2(X,y);
		this.rot=inc;
		if(c!=null)
			this.c = c;
		else
			this.c = new ColorCl(255,255,255);
		this.vertices = vertices;
		this.relaciones = new ArrayList<int[]>();
		for(int x=0; x<vertices.size()-1; x++)
			relaciones.add(new int[] {x, x+1});
		relaciones.add(new int[] {vertices.size()-1, 0});
	}

	public Obstaculo getObst() {
		Obstaculo out = this.clone();
		
		for(int x=0; x<out.vertices.size(); x++) {
			Vector2 v=out.vertices.get(x);
			double incTotal = Util.incVector(v) + out.rot*Math.PI;  				//consigo la inclinacion actual de una esquina, le sumo los radianes de iinclinacion que tiene el objeto
			double distancia = v.distancia(new Vector2(0,0));
			v.set(Math.cos(incTotal)*distancia, Math.sin(incTotal)*distancia);
			v.mover(out.pos.x, out.pos.y);
		}
		
		return out;
	}

	public Obstaculo clone() {
		ArrayList<Vector2> vertices = new ArrayList<Vector2>();
		for(int x=0; x<this.vertices.size(); x++) 
			vertices.add(this.vertices.get(x).clone());
		
		ArrayList<int[]> relaciones = new ArrayList<int[]>();
		for(int x=0; x<this.relaciones.size(); x++) 
			relaciones.add(new int[] {this.relaciones.get(x)[0], this.relaciones.get(x)[1]});
		
		return new Obstaculo(this.pos.x, this.pos.y, this.rot, vertices, relaciones, this.c.clone());
	}

	public ArrayList<Vector2> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vector2> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<int[]> getRelaciones() {
		return relaciones;
	}

	public void setRelaciones(ArrayList<int[]> relaciones) {
		this.relaciones = relaciones;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public Vector2 getVel() {
		return vel;
	}

	public void setVel(Vector2 vel) {
		this.vel = vel;
	}

	public Vector2 getAsc() {
		return asc;
	}

	public void setAsc(Vector2 asc) {
		this.asc = asc;
	}

	public double getRot() {
		return rot;
	}

	public ColorCl getC() {
		return c;
	}

	public void setC(ColorCl c) {
		this.c = c;
	}
	
	public double dist(Vector2 pos) {
		Vector2 prom = new Vector2();
		for(int x=0; x<vertices.size(); x++) {
			prom.x+=vertices.get(x).x;
			prom.y+=vertices.get(x).y;
		}
		prom.x/=vertices.size();
		prom.y/=vertices.size();
		return pos.distancia(prom);
	}
}
