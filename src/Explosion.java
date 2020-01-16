import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Explosion {
	
	ArrayList<Particle> explosion = new ArrayList<Particle>();
	
	public Explosion(double x, double y)
	{
		Color c = AppConstants.COLORS.get((int)(Math.random() * AppConstants.COLORS.size()));
		
		for (int i = 0; i < AppConstants.EXPLOSION_PARTICLE_COUNT; i++)
		{
			Particle pToAdd = new Particle(x,
					y,
					ThreadLocalRandom.current().nextDouble(1, 4 + 1),
					c);
			
			pToAdd.setVel(new DVector(ThreadLocalRandom.current().nextDouble(-4, 4 + 1),
										ThreadLocalRandom.current().nextDouble(-8, 4 + 1)));
			pToAdd.setAcc(new DVector(0, AppConstants.GRAVITY));
			
			explosion.add(pToAdd);
		}
	}
	
	public boolean finished()
	{
		for (Particle p : explosion)
		{
			if (p.getColor().getAlpha() <= 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public void update()
	{
		for (Particle p : explosion)
		{
			p.update();
		}
	}
	
	public void draw(Graphics g)
	{
		for (int i = 0; i < explosion.size(); i++)
		{
			Particle p = explosion.get(i);
			if (p.getColor().getAlpha() > 0)
			{
				p.setColor(new Color(p.getColor().getRed(),
					p.getColor().getGreen(),
					p.getColor().getBlue(),
					p.getColor().getAlpha() - 5));
			}
			p.draw(g);
		}
	}
}
