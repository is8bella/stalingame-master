package stalingame;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Renderer extends JPanel
{

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		if(Stalin.stalin != null)
		{
		Stalin.stalin.paint((Graphics2D)g);
		}
	}

}
