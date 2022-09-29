package conexion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modelo.Juego;
import modelo.Obstaculo;
import util.Vector2;

public class GameJPanelParser {
	private Juego juego;
	public double ppu = 20; //pixel per unit
	public int width, height;
	private Vector2 cam;     //pos cam en units
	
	public GameJPanelParser(Juego juego) {
		this.juego = juego;
		cam = new Vector2(0,0);
	}
	public GameJPanelParser() {
		this.juego = new Juego();
		cam = new Vector2(0,0);
	}
	
	public void paint(Graphics g, int width, int height) {
		this.width=width;
		this.height=height;
		g.setColor(new Color(30,30,30));
		for(int x=0; x<this.height; x++)
			g.drawLine(0,x,width,x);
		dibujarEjes(g);
		g.setColor(Color.WHITE);
		
		for(int x=0; x<juego.getEscena().size(); x++) {
   			this.dibujarObst(g, juego.getEscena().get(x).getObst());
		}
		/*
		ArrayList<Obstaculo> escena = juego.getJugador().escenaFromThis(juego.getEscena());
		for(int x=0; x<escena.size(); x++) {
			dibujarObst(g, escena.get(x));
		}*/
		
		this.dibujarObst(g, juego.getJugador().getObst());
	}
	
	public void dibujarObst(Graphics g, Obstaculo obs) {
		ArrayList<Vector2> vertices = obs.getVertices();
		ArrayList<int[]> relaciones = obs.getRelaciones();
		for(int y=0; y<obs.getRelaciones().size(); y++) {
			g.setColor(obs.getC());
			g.drawLine(
				(int)(( vertices.get(relaciones.get(y)[0]).x + cam.x)*ppu + width /2), 
				(int)((-vertices.get(relaciones.get(y)[0]).y - cam.y)*ppu + height/2),   //invierto las 'y' para que cooiincidan con como se visualizan los ejes cartecianos (normalemnte mientras mas alta es y mas abajo de la pantalla estas, deveria ser al revez)
				(int)(( vertices.get(relaciones.get(y)[1]).x + cam.x)*ppu + width /2), 
				(int)((-vertices.get(relaciones.get(y)[1]).y - cam.y)*ppu + height/2) 
			);
		}
	}
	
	
	public void dibujarEjes(Graphics g) {
		g.setColor(new Color(100,100,100));
		g.drawLine(0, (int)(height/2-cam.y*ppu), width, (int)(height/2-cam.y*ppu));//eje x
		g.drawLine((int)(width/2+cam.x*ppu), 0, (int)(width/2+cam.x*ppu), height); //eje y
		
		
		for(int x=(int) (width/2+cam.x*ppu); x>0; x-=ppu) {
			g.drawLine((int)(x), (int)(height/2-1-cam.y*ppu), (int)(x), (int)(height/2+1-cam.y*ppu));
		}
		for(int x=(int) (width/2+cam.x*ppu); x<width; x+=ppu) {
			g.drawLine((int)(x), (int)(height/2-1-cam.y*ppu), (int)(x), (int)(height/2+1-cam.y*ppu));
		}
		for(int x=(int) (height/2-cam.y*ppu); x>0; x-=ppu) {
			g.drawLine((int)(width/2-1+cam.x*ppu), (int)(x), (int)(width/2+1+cam.x*ppu), (int)(x));
		}
		for(int x=(int) (height/2-cam.y*ppu); x<height; x+=ppu) {
			g.drawLine((int)(width/2-1+cam.x*ppu), (int)(x), (int)(width/2+1+cam.x*ppu), (int)(x));
		}
		
		/*
		for(int x=0; x<this.width/2; x+=ppu) {
			g.drawLine((int)( x+width/2), (int)(height/2-1-camy*ppu), (int)( x+width/2), (int)(height/2+1-camy*ppu));
			g.drawLine((int)(-x+width/2), (int)(height/2-1-camy*ppu), (int)(-x+width/2), (int)(height/2+1-camy*ppu));
		}
		for(int x=0; x<this.height/2; x+=ppu) {
			g.drawLine((int)(width/2-1+camx*ppu), (int)( x+height/2), (int)(width/2+1+camx*ppu), (int)( x+height/2));
			g.drawLine((int)(width/2-1+camx*ppu), (int)(-x+height/2), (int)(width/2+1+camx*ppu), (int)(-x+height/2));
		}*/
	}
	
	
	public void moverCam(double x, double y) {
		cam.mover(x, y);
	}
}