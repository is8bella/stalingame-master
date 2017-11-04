package stalingame;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Renderer extends JPanel
{
Stalin stalin;
	public Renderer(Stalin stalin) {
		// TODO Auto-generated constructor stub
		this.stalin = stalin;
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		if(stalin != null)
		{
		stalin.paint((Graphics2D)g);
		}
	}

}
