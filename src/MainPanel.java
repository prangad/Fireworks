import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	ArrayList<Firework> fireworks;
	
	Timer animationTimer = new Timer((int)(1000/AppConstants.FRAME_RATE), new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < fireworks.size(); i++)
			{
				if (!fireworks.get(i).isFinished())
				{
					fireworks.get(i).update();
				}
				else
				{
					fireworks.set(i, new Firework());
				}
			}
			
			repaint();
		}
	});
	
	public MainPanel(int width, int height)
	{
		this.setBackground(Color.DARK_GRAY);
		AppConstants.populateColors();
		fireworks = new ArrayList<Firework>();
		
		for (int i = 0; i < AppConstants.FIREWORK_COUNT; i++)
		{
			fireworks.add(new Firework());
		}
		
		animationTimer.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (Firework f : fireworks)
		{
			f.draw(g);
		}
	}
}
