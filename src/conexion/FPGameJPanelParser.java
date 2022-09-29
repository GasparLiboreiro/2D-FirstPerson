package conexion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modelo.Juego;
import modelo.Linea;
import modelo.Obstaculo;
import util.Util;
import util.Vector2;

public class FPGameJPanelParser {
	public Juego juego;
	public int initHeight;
	public int width, height;
	private double D1 = 0.5;
	private double vicionMax=20;
	public FPGameJPanelParser(Juego juego) {
		this.juego = juego;
	}
	
	public void paint(Graphics g, int width, int height, int initHeight) {
		this.width = width;
		this.height = height;
		this.initHeight = initHeight;
		g.setColor(new Color(30,30,30));
		for(int x=0; x<width; x++) {
			g.drawLine(x, initHeight, x, height);
		}
		
		
		ArrayList<Double> valores = new ArrayList<Double>();
		for(int x=0; x<juego.getEscena().size(); x++) {
			double centrox=0, centroy=0;
			for(int y=0; y<juego.getEscena().get(x).getVertices().size(); y++) {
				centrox+=juego.getEscena().get(x).getObst().getVertices().get(y).x;
				centroy+=juego.getEscena().get(x).getObst().getVertices().get(y).y;
			}
			centrox/=juego.getEscena().get(x).getVertices().size();
			centroy/=juego.getEscena().get(x).getVertices().size();
			valores.add(-Math.sqrt(Math.pow(centrox-juego.getJugador().getPos().x, 2) + 
								  Math.pow(centroy-juego.getJugador().getPos().y, 2)));
		}
		Util.insertionSort(juego.getEscena(), valores);
		
		
		ArrayList<Obstaculo> escenaR = juego.getJugador().escenaFromThis(juego.getEscena()); // escena pero relativo a la posicion u rotacion del jugador (como si el jugador fuece 0,0 mirando a +y)
		for(int x=0; x<escenaR.size(); x++) {
			boolean isClipping=false;
			for(int y=0; y<escenaR.get(x).getVertices().size(); y++)
				if(escenaR.get(x).getVertices().get(y).y<D1)
					isClipping=true;
			if(!isClipping) {
				double dist = escenaR.get(x).dist(new Vector2());
				if(dist<3)
					g.setColor(escenaR.get(x).getC());
				else if(dist>=3 && dist<vicionMax+3)
					g.setColor(Util.colorWBrightnes(escenaR.get(x).getC(), (vicionMax-(dist-3))/vicionMax));
				else
					g.setColor(Color.BLACK);
				
				dibujarObst(g,escenaR.get(x));
			}
		}
		
	}
	
	
	public void dibujarObst(Graphics g, Obstaculo obst) {
		for(int x=0; x<obst.getRelaciones().size(); x++) {
			Linea l = new Linea(obst.getVertices().get(obst.getRelaciones().get(x)[0]), obst.getVertices().get(obst.getRelaciones().get(x)[1]));
			representarLinea(g,l);
		}
	}
	
	public void representarLinea(Graphics g, Linea l) {
		double x1 = l.A.x * (D1/(l.A.y-D1))*200;
		double x2 = l.B.x * (D1/(l.B.y-D1))*200;
		if(x1>x2) {
			double b = x1;
			x1 = x2;
			x2 = b;
		}
		
		for(int x=0; x<(x2-x1); x++) {
			g.drawLine((int)(x1+x+width/2), this.initHeight, (int)(x1+x+width/2), this.height);
		}
	}
	
	
}





/*ArrayList<Double> valores = new ArrayList<Double>();
for(int x=0; x<obst.getRelaciones().size(); x++) 
	if(obst.getVertices().get(obst.getRelaciones().get(x)[0]).y > obst.getVertices().get(obst.getRelaciones().get(x)[1]).y)
		valores.add(Math.sqrt(Math.pow(obst.getVertices().get(obst.getRelaciones().get(x)[0]).x, 2) + Math.pow(obst.getVertices().get(obst.getRelaciones().get(x)[0]).y, 2)));
	else
		valores.add(Math.sqrt(Math.pow(obst.getVertices().get(obst.getRelaciones().get(x)[1]).x, 2) + Math.pow(obst.getVertices().get(obst.getRelaciones().get(x)[1]).y, 2)));

Util.insertionSortR(obst.getRelaciones(), valores);
*/
/*double dist;
if(l.A.y>l.B.y) 
	dist=l.A.y;
else
	dist=l.B.y;

if(dist<3)
	g.setColor(obst.getC());
else if(dist>=3 && dist<13)
	g.setColor(Util.colorWBrightnes(obst.getC(), (10-(dist-3))/10));
else
	g.setColor(Color.BLACK);*/
