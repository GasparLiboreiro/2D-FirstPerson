package modelo;

import java.util.ArrayList;

public class Juego {
	private ArrayList<Obstaculo> escena = new ArrayList<Obstaculo>();
	private Jugador jugador;
	
	public Juego() {
		jugador = ObstFactory.jugador(0, -10, 0, 1, null);
		//escena.add(ObstFactory.cuadrado(0, 4, 0, 2, 2, null));
		
		escena.add(ObstFactory.cuadrado(3, -3, 0, 1, 1, null)); //podria haber hecho un editor de mapas y no tener que hardcodear esto
		escena.add(ObstFactory.cuadrado(4, -3, 0, 1, 1, null)); //pero son las 0:45
		escena.add(ObstFactory.cuadrado(5, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(6, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(7, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(8, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(9, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(10, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, -3, 0, 1, 1, null));

		escena.add(ObstFactory.cuadrado(-3, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-4, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-5, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-6, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-7, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-8, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-9, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-10, -3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, -3, 0, 1, 1, null));

		escena.add(ObstFactory.cuadrado(11, -2, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, -1, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 0, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 1, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 2, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 4, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 5, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 6, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 7, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 8, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 9, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 10, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 11, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 12, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 13, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 14, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 15, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 16, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 17, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 18, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 19, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 20, 0, 1, 1, null));

		escena.add(ObstFactory.cuadrado(-11, -2, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, -1, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 0, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 1, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 2, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 3, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 4, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 5, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 6, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 7, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 8, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 9, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 10, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 11, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 12, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 13, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 14, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 15, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 16, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 17, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 18, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 19, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 20, 0, 1, 1, null));
		
		escena.add(ObstFactory.cuadrado(1, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(2, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(3, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(4, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(5, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(6, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(7, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(8, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(9, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(10, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(11, 21, 0, 1, 1, null));

		escena.add(ObstFactory.cuadrado(0, 21, 0, 1, 1, null));
		
		escena.add(ObstFactory.cuadrado(-1, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-2, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-3, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-4, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-5, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-6, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-7, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-8, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-9, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-10, 21, 0, 1, 1, null));
		escena.add(ObstFactory.cuadrado(-11, 21, 0, 1, 1, null));
		
		
		for(int x=0; x<10; x++) {
			escena.add(ObstFactory.cuadrado((int)(Math.random()*16)-7, (int)(Math.random()*18)+1, 0, 1, 1, new ColorCl((int)(Math.random()*155+100), (int)(Math.random()*155+100), (int)(Math.random()*155+100))));
		}
		/*
		int h=11, w=11;
		for(int x=0; x<w; x++) {
			for(int y=0; y<h; y++) {
				escena.add(ObstFactory.cuadrado((x-w/2)*2, (y-h/2)*1.25, (double)(x-w/2)/(h-((double)(y)-h/2)), 1, 1, new ColorCl((int)((255/w)*x),0,(int)((255/h)*y))));//new ColorCl((int)((255/w)*x),0,(int)((255/h)*y))
			}
		}*/
		/*
		for(int x=0; x<w; x++) {
			for(int y=0; y<h; y++) {
				escena.add(ObstFactory.cuadrado(x-w/2, y-h/2, 0, 1, 1, new ColorCl((int)((255/w)*x),0,(int)((255/h)*y))));
			}
		}*/
		
		
	}

	public void update(double deltaT) {
		for(int x=0; x<escena.size(); x++) {
			escena.get(x).getVel().x+=escena.get(x).getAsc().x * deltaT;
			escena.get(x).getVel().y+=escena.get(x).getAsc().y * deltaT;
			escena.get(x).vrot+=escena.get(x).arot * deltaT;
			escena.get(x).getPos().x+=escena.get(x).getVel().x * deltaT;
			escena.get(x).getPos().y+=escena.get(x).getVel().y * deltaT;
			escena.get(x).rot+=escena.get(x).vrot * deltaT;
			
		}
		jugador.getVel().x+=jugador.getAsc().x * deltaT;
		jugador.getVel().y+=jugador.getAsc().y * deltaT;
		jugador.vrot+=jugador.arot * deltaT;
		jugador.getPos().x+=jugador.getVel().x * deltaT;
		jugador.getPos().y+=jugador.getVel().y * deltaT;
		jugador.rot+=jugador.vrot * deltaT;
	}
	
	public void moverJugador(double dir, boolean isMoving) { 				// dir = direccion en la que se mueve en radianes/pi, 0=derecha, 0.5=arriba, 1=izquierda, 1.5=abajo
		if(isMoving) {
			jugador.getVel().x = Math.cos((dir+jugador.rot)*Math.PI) * jugador.vmovimiento;
			jugador.getVel().y = Math.sin((dir+jugador.rot)*Math.PI) * jugador.vmovimiento;
		} else {
			jugador.getVel().x=0;
			jugador.getVel().y=0;
		}
	}

	public ArrayList<Obstaculo> getEscena() {
		return escena;
	}
	public void setEscena(ArrayList<Obstaculo> escena) {
		this.escena = escena;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
