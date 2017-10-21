package stalingame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Stalin implements ActionListener, MouseListener{
	public static Stalin stalin;
	
	public int WIDTH = 700;
	
	public int HEIGHT = 700;
	
	public int flash = 0, tick, repPattern;
	
	public Renderer renderer;
	
	public boolean newPattern;
	
	JFrame frame = new JFrame("STALIN");
	
	JFrame start = new JFrame("START STALIN");
	
	JPanel panel = new JPanel();
	
	JButton play = new JButton("START");
	
	ArrayList<Integer> num = new ArrayList<Integer>();
	
	public int level = 0; 
	

	public void pattGenerator() {
		//level++;
		for (int i = 0; i < level; i++) {
			int random = new Random().nextInt(4-1+1) +1;
			num.add(random);
		}
		
		

		
	}
	
	public Stalin() {
		renderer = new Renderer();
		
		frame.setSize(WIDTH, HEIGHT);
		frame.add(renderer);
		frame.setResizable(false);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//public void Start() {
		//pattern = new ArrayList<Integer>();	
	//}
	
	public static void main(String[] args) {
		Stalin stalingame = new Stalin();
		stalin = new Stalin();

		stalin.startMenu();
	}

	private void startMenu() {
		// Start frame things
		JLabel instructions = new JLabel(
				"<html> <div style='text-align: center;'> Simon, the classic 80’s memory game, but with a dash of soviet autocracy."
						+ "<br> Meet Stalin. <br> The Game. <br> </div></html>",
				SwingConstants.CENTER);
		// Set up frame
		start.setSize(1000, 1000);
		start.setVisible(true);
		start.add(panel);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(2, 0));
		panel.add(instructions);
		panel.add(play);
		play.addActionListener(this);
		play.addMouseListener(this);
		start.pack();
		
		pattern = new ArrayList<Integer>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		start.setVisible(false);
		frame.setVisible(true);
		
		tick++;
		
		if(tick % 20 == 0) {
			flash = 0;
		}
		
		renderer.repaint();
		
	}

	public void paint(Graphics2D g) {
		//g.setColor(Color.GRAY);
		//g.fillRect(0,0,WIDfgvh, HEIGHT);
		
		//color flash
		if(flash == 1) {
			g.setColor(Color.WHITE);
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
		if(!newPattern) {
			if(x > 0 && x < WIDTH/2 && y > 0 && y < HEIGHT/2) {
				flash = 1;
				tick = 1;
				System.out.println("white");
			}
			else if (x > WIDTH/2 && x < WIDTH && y > 0 && y < HEIGHT/2) {
				flash = 2;
				tick = 1;
				System.out.println("blue");
			}
			else if (x > 0 && x < WIDTH/2 && y > HEIGHT/2 && y < HEIGHT) {
				flash = 3;
				tick = 1; 
				System.out.println("red");
			}
			else if (x > WIDTH/2 && x < WIDTH && y > HEIGHT/2 && y < HEIGHT) {
				flash = 4;
				tick = 1;
				System.out.println("yellow");
			}
		}
			
			frame.repaint();
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
