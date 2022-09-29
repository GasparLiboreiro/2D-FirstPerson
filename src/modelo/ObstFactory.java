package modelo;

import java.awt.Color;
import java.util.ArrayList;

import util.Vector2;

public class ObstFactory {
	public static Obstaculo cuadrado(double x, double y, double inc, double anch, double alt, ColorCl c) {
		
		ArrayList<Vector2> vertices = new ArrayList<Vector2>();
		vertices.add(new Vector2(  anch/2,   alt/2));      //arriba derecha			 Sentido agujas del reloj //puede ser al revez 
		vertices.add(new Vector2(  anch/2, -(alt/2)));	//abajo derecha            	 Usando constructor (x,y,inc, vertices ,c) nesecitas tener las vertices 
		vertices.add(new Vector2(-(anch/2),-(alt/2)));	//abajo izquiierda         	ordenadas haciendo que den toda la vuelta en orden.
		vertices.add(new Vector2(-(anch/2),  alt/2));	//arriba izquierda         	 Van a conectarse en el orden en el que los pusiste + ultiimo con el primero
		
		return new Obstaculo(x, y, inc, vertices, c);
	}
	
	public static Jugador jugador(double x, double y, double inc, double tam, ColorCl c) {
		
		ArrayList<Vector2> vertices = new ArrayList<Vector2>();
		vertices.add(new Vector2(0,1*tam));
		vertices.add(new Vector2(1*tam,-1*tam));
		vertices.add(new Vector2(0,-0.5*tam));
		vertices.add(new Vector2(-1*tam,-1*tam));
		
		return new Jugador(x,y,inc,vertices,c);
	}
}
