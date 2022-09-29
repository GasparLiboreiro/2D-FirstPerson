package vista;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import conexion.FPGameJPanelParser;
import conexion.GameJPanelParser;
import modelo.GameLoop;
import modelo.Juego;
import modelo.Linea;
import util.Vector2;

public class PanelCustom extends JPanel implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener{
	private Juego juego;
	private GameJPanelParser GJP;
	private FPGameJPanelParser FPGJP;
	private GameLoop gameLoop;
	public int width, height;
	public int espacioFP=200;
	public boolean modoMouse=false;
	
	public PanelCustom() {
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		
		
		
		juego = new Juego();
		GJP = new GameJPanelParser(juego);
		FPGJP = new FPGameJPanelParser(juego);
		gameLoop = new GameLoop(juego, this);
	}
	
	public void startGame() {
		this.width=this.getWidth();
		this.height=this.getHeight()-espacioFP;
		gameLoop.startLoop();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		GJP.paint(g, width, height);
		FPGJP.paint(g, width, height+espacioFP, height);
		g.setColor(Color.GRAY);
		g.drawString("FPS:"+gameLoop.getAverageFPS(), 5, 10);
		g.drawString("UPS:"+gameLoop.getAverageUPS(), 3, 20);
		g.drawString(""+modoMouse, 5, 30);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation()<0) {
			GJP.ppu*=1.25;
		} else {
			if(GJP.ppu*0.75>1)
				GJP.ppu=(int)(GJP.ppu*0.75);
			else
				GJP.ppu=1;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			juego.moverJugador(0.5,true);
			break;
		case KeyEvent.VK_A:
			juego.moverJugador(1,true);
			break;
		case KeyEvent.VK_S:
			juego.moverJugador(1.5,true);
			break;
		case KeyEvent.VK_D:
			juego.moverJugador(0,true);
			break;
		case KeyEvent.VK_Q:
			juego.getJugador().vrot=1;
			break;
		case KeyEvent.VK_E:
			juego.getJugador().vrot=-1;
			juego.getJugador().escenaFromThis(juego.getEscena());
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			juego.moverJugador(0.5,false);
			break;
		case KeyEvent.VK_A:
			juego.moverJugador(1,false);
			break;
		case KeyEvent.VK_S:
			juego.moverJugador(1.5,false);
			break;
		case KeyEvent.VK_D:
			juego.moverJugador(0,false);
			break;
		case KeyEvent.VK_Q:
			juego.getJugador().vrot=0;
			break;
		case KeyEvent.VK_E:
			juego.getJugador().vrot=0;
			//juego.getJugador().escenaFromThis(juego.getEscena());
			break;
		}
	}
	private MouseEvent antPos=null;
	@Override
	public void mouseDragged(MouseEvent e) {
		if(!this.modoMouse) {
			if(antPos!=null) {
				GJP.moverCam((e.getX()-antPos.getX())/GJP.ppu, -(e.getY()-antPos.getY())/GJP.ppu);
			}
			antPos=e;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(modoMouse) {
			if(antPos!=null) {
				juego.getJugador().rot-=((double)(e.getX()-antPos.getX())/width)*2;
				
			}
		}
		antPos=e;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean past = modoMouse;
		if(e.getY()>this.height) 
			this.modoMouse=true;
		else
			this.modoMouse=false;
		if(past!=modoMouse) //si cambio, receteo antPos
			antPos=null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		antPos=null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
