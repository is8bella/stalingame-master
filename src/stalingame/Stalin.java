package stalingame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Stalin implements ActionListener, MouseListener{
	public static Stalin stalin;
	
	public int WIDTH = 700;
	
	public int HEIGHT = 700;
	
	public int flash = 0; //, tick, repPattern;
	
	public Renderer renderer;
	
	public boolean newPattern;
	
	//public ArrayList<Integer> pattern;
	
	public Stalin() {
		JFrame frame = new JFrame("STALIN");
		
		renderer = new Renderer();
		
		frame.setSize(WIDTH, HEIGHT);
		frame.add(renderer);
		frame.setResizable(false);
		frame.addMouseListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	//public void Start() {
		//pattern = new ArrayList<Integer>();	
	//}
	
	public static void main(String[] args) {
		stalin = new Stalin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//tick++;
		
		//if(tick % 20 == 0) {
				//flash = 0;
		//}
		
		renderer.repaint();
	}

	public void paint(Graphics2D g) {
		//g.setColor(Color.GRAY);
		//g.fillRect(0,0,WIDTH, HEIGHT);
		
		//no flash
		if(flash == 0) {
			System.out.println("no flash");
		}
		
		//color flash
		if(flash == 1) {
			g.setColor(Color.WHITE);
			System.out.println("white flash");
		}
		else {
			g.setColor(Color.WHITE.darker());
		}
		g.fillRect(0, 0, WIDTH/2, HEIGHT/2);
		
		if(flash == 2) {
			g.setColor(Color.BLUE);
		}
		else {
			g.setColor(Color.BLUE.darker());
		}
		g.fillRect(WIDTH/2, 0, WIDTH/2, HEIGHT/2);
		
		if(flash == 3) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.RED.darker());
		}
		g.fillRect(0, HEIGHT/2, WIDTH/2, HEIGHT/2);
		
		if(flash == 4) {
		g.setColor(Color.YELLOW);
		}
		else {
			g.setColor(Color.YELLOW.darker());
		}
		g.fillRect(WIDTH/2, HEIGHT/2, WIDTH/2, HEIGHT/2);
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		//g.fillRect(0, 0, WIDTH/2, HEIGHT/2);
		//g.fillRect(WIDTH/2, 0, WIDTH/2, HEIGHT/2);
		//g.fillRect(0, HEIGHT/2, WIDTH/2, HEIGHT/2);
		//g.fillRect(WIDTH/2, HEIGHT/2, WIDTH/2, HEIGHT/2);
		
		//get coordinates
		int x = e.getX();
		int y = e.getY();
		
		//assigning coordinates to flash#
		//if(!newPattern) {
			if(x > 0 && x < WIDTH/2 && y > 0 && y < HEIGHT/2) {
				flash = 1;
				//tick = 1;
				System.out.println("white");
				//if(flash == 1) {
					//System.out.println("white flash");
				//}
			}
			else if (x > WIDTH/2 && x < WIDTH && y > 0 && y < HEIGHT/2) {
				flash = 2;
				//tick = 1;
				System.out.println("blue");
			}
			else if (x > 0 && x < WIDTH/2 && y > HEIGHT/2 && y < HEIGHT) {
				flash = 3;
				//tick = 1; 
				System.out.println("red");
			}
			else if (x > WIDTH/2 && x < WIDTH && y > HEIGHT/2 && y < HEIGHT) {
				flash = 4;
				//tick = 1;
				System.out.println("yellow");
			}
		//}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
