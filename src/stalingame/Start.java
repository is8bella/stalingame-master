package stalingame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Start implements ActionListener , MouseListener {
	JFrame gameframe = new JFrame();
	JFrame frame = new JFrame();

	JPanel panel = new JPanel();
	JButton play = new JButton("START");

	JPanel gamepanel = new JPanel();
	JButton blue = new JButton("blu");
	JButton white = new JButton("whi");
	JButton red = new JButton("red");
	JButton yellow = new JButton("ylw");

	public int WIDTH = 1000;
	public int HEIGHT = 1000;

	public static void main(String[] args) {
		Start stalingame = new Start();
		stalingame.startMenu();
	}

	private void startMenu() {
		// Start frame things
		JLabel instructions = new JLabel(
				"<html> <div style='text-align: center;'> Simon, the classic 80’s memory game, but with a dash of soviet autocracy."
						+ "<br> Meet Stalin. <br> The Game. <br> </div></html>",
				SwingConstants.CENTER);
		// Set up frame
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(2, 0));
		panel.add(instructions);
		panel.add(play);
		play.addActionListener(this);
		play.addMouseListener(this);
		frame.pack();

		// Set up game frame
		gameframe.setSize(WIDTH + 1000, HEIGHT);
		gameframe.add(gamepanel);
		gamepanel.setLayout(new GridLayout(2, 2));
		gamepanel.add(red);
		gamepanel.add(white);
		gamepanel.add(blue);
		gamepanel.add(yellow);
		yellow.addActionListener(this);
		yellow.setOpaque(true);
		yellow.setBorderPainted(false);
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		gameframe.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == yellow) {
			yellow.setBackground(Color.YELLOW);
		}
		else {
			yellow.setBackground(Color.YELLOW.darker());
		}
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
