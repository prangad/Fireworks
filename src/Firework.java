import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Firework extends Particle{
	
	private boolean exploded;
	DVector pos, vel, acc;
	
	Explosion explosion;
	
	public Firework()
	{
		super((int)(Math.random() * AppConstants.WINDOW_WIDTH),
				AppConstants.WINDOW_HEIGHT,
				8,
				AppConstants.COLORS.get((int)(Math.random() * AppConstants.COLORS.size())));
		super.setVel(new DVector(0, ThreadLocalRandom.current().nextDouble(AppConstants.STARTING_VELOCITY_MIN, AppConstants.STARTING_VELOCITY_MAX + 1)));
		super.setAcc(new DVector(0, AppConstants.GRAVITY));
		this.exploded = false;
	}
	
	public void update()
	{
		super.update();
		if (super.getVel().getY() > -0 && !exploded)
		{
			this.explode();
		}
		
		if (explosion != null)
		{
			if (explosion.finished())
			{
				exploded = true;
			}
			else
			{
				explosion.update();
			}
		}
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		if (explosion != null)
		{
			explosion.draw(g);
		}
	}
	
	public void explode()
	{
		super.setColor(new Color(super.getColor().getRed(),
				super.getColor().getGreen(),
				super.getColor().getBlue(),
				0));
		
		this.vel = new DVector(0, 0);
		this.acc = new DVector(0, 0);
		exploded = true;
		explosion = new Explosion(super.getPos().getX(), super.getPos().getY());
	}
	
	public boolean isFinished()
	{
		if (explosion != null)
		{
			return (this.explosion.finished());
		}
		else
		{
			return false;
		}
	}
}
