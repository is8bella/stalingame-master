package stalingame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Stalin implements ActionListener, MouseListener{
	
	public int WIDTH = 700;
	
	public int HEIGHT = 700;
	
	public int flash = 0, tick, repPattern;
	
	public int currentIndex = 0;
	
	public Renderer renderer;
	
	public boolean turn = false;
	
	public int listcheck = 0;
	
	JFrame frame = new JFrame("STALIN");
	
	JFrame start = new JFrame("START STALIN");
	
	JPanel panel = new JPanel();
	
	JButton play = new JButton("START");
	
	ArrayList<Integer> pattern = new ArrayList<Integer>();
	
	ArrayList<Integer> user = new ArrayList<Integer>();
	
	public int level = 0; 
	
	Timer timer = new Timer(500/3,this);
	
	public int x = 0;
	

	public void addNextFlash() {
			int random = new Random().nextInt(4-1+1) +1;
			pattern.add(random);
	}
	
	public void flash() {
		System.out.println("flash all");
		for (int i = 0; i < pattern.size(); i++) {
			flash = i;
		}
	}
	
	
	public Stalin() {
		renderer = new Renderer(this);

		frame.setSize(WIDTH, HEIGHT);
		frame.add(renderer);
		frame.setResizable(false);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		Stalin stalingame = new Stalin();
		stalingame.startMenu();
		
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(pattern); //get rid of later
		
		if(e.getSource() == play) {
			start.setVisible(false);
			frame.setVisible(true);
			timer.start();
			turn = false;
		}
		
		//delay when first start
		if(turn == false) {
			System.out.println("Computer's Turn");
			
			if(tick == 3) { 
				this.addNextFlash();
				flash = pattern.get(currentIndex);
				System.out.println("pattern size: " + pattern.size());
			}
		
			tick++;
			
			if(tick % 5 == 0) { 
				System.out.println("CI: " + currentIndex);
				flash = pattern.get(currentIndex);
				currentIndex++;
		
			}
		}
		
		if(pattern.size() == currentIndex && tick > 5) { 
			turn = true;
			System.out.println("User's Turn");
		}
		
		/*if(listcheck == true) {	//never runs
			System.out.println("user is incorrect");
		frame.setVisible(false);
		}*/
			
		System.out.println("tick = " + tick);
		
		renderer.repaint();
	}
int counter = 0;
	public void paint(Graphics2D g) { //makes flashes work
	
		if(flash == 1) {
			g.setColor(Color.WHITE);
			if(counter == 3) {
				flash = 0;
				counter = 0;
			}
			counter++;
			System.out.println("White Flash");
		}
		else {
			g.setColor(Color.WHITE.darker());
		}
		g.fillRect(0, 0, WIDTH/2, HEIGHT/2);
		
		if(flash == 2) {
			g.setColor(Color.BLUE);
			if(counter == 3) {
				flash = 0;
				counter = 0;
			}
			counter++;
			System.out.println("Blue Flash");
		}
		else {
			g.setColor(Color.BLUE.darker());
		}
		g.fillRect(WIDTH/2, 0, WIDTH/2, HEIGHT/2);
		
		if(flash == 3) {
			g.setColor(Color.RED);
			if(counter == 3) {
				flash = 0;
				counter = 0;
			}
			counter++;
			System.out.println("Red Flash");
		}
		else {
			g.setColor(Color.RED.darker());
		}
		g.fillRect(0, HEIGHT/2, WIDTH/2, HEIGHT/2);
		
		if(flash == 4) {
			g.setColor(Color.YELLOW);
			if(counter == 3) {
				flash = 0;
				counter = 0;
			}
			counter++;
			System.out.println("Yellow Flash");
		}
		else {
			g.setColor(Color.YELLOW.darker());
		}
		g.fillRect(WIDTH/2, HEIGHT/2, WIDTH/2, HEIGHT/2);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) { //flash when pressed
		renderer.repaint();
		//get coordinates
		int x = e.getX();
		int y = e.getY();
		
		if(turn == true) {
			tick = 1; //grid
			if(x > 0 && x < WIDTH/2 && y > 0 && y < HEIGHT/2) {
				flash = 1;
				System.out.println("white");
				user.add(flash);
			}
			else if (x > WIDTH/2 && x < WIDTH && y > 0 && y < HEIGHT/2) {
				flash = 2;
				System.out.println("blue");
				user.add(flash);
			}
			else if (x > 0 && x < WIDTH/2 && y > HEIGHT/2 && y < HEIGHT) {
				flash = 3;
				System.out.println("red");
				user.add(flash);
			}
			else if (x > WIDTH/2 && x < WIDTH && y > HEIGHT/2 && y < HEIGHT) {
				flash = 4;
				System.out.println("yellow");
				user.add(flash);
			}
			System.out.println("U: " + user);
			System.out.println("P: " + pattern);
			
			//for (int i = 0; i < pattern.size(); i++) {
				
				/*if(pattern.get(i) == user.get(i)) {
					listcheck = true;
				}
				else{
					listcheck = false;
				}*/
					//this.addNextFlash();
				
				if(user.equals(pattern)) {
					listcheck = 1;
				}
				else {
					listcheck = 2;
				}
			//}
		
			if(listcheck == 1) {
				turn = false;
				tick = 0;
				currentIndex = 0;
				user.clear();
				System.out.println("user = pattern");
				listcheck = 0;
				//System.out.println(user);
			}
			
			if(listcheck == 2) {
				System.out.println("INCORRECT");			
			}
			
			//else{
			//	JOptionPane.showMessageDialog(null, "Fail.");
			//	System.exit(0);
			//}
			
			
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
		/*System.out.println("mouse released");
		if(tick%2 == 0) {
			flash = 0;
		}*/
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
