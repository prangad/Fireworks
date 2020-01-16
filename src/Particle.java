import java.awt.*;

public class Particle {
	private DVector pos, vel, acc;
	private double d;
	private Color color;
	
	public Particle(double x, double y, double d, Color c)
	{
		this.pos = new DVector(x, y);
		this.d = d;
		this.color = c;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(new Color(255, 255, 255, this.color.getAlpha()));
		g.drawOval((int)(this.pos.getX() - (this.d/2)),
				(int)(this.pos.getY() - (this.d/2)),
				(int)this.d,
				(int)this.d);
		g.setColor(this.color);
		g.fillOval((int)(this.pos.getX() - (this.d/2)),
				(int)(this.pos.getY() - (this.d/2)),
				(int)this.d,
				(int)this.d);
	}
	
	public void update()
	{
		this.pos = this.pos.add(this.vel);
		this.vel = this.vel.add(this.acc);
	}
	
	public DVector getPos()
	{
		return this.pos;
	}
	
	public void setPos(DVector pos)
	{
		this.pos = pos;
	}
	
	public DVector getVel()
	{
		return this.vel;
	}
	
	public void setVel(DVector vel)
	{
		this.vel = vel;
	}
	
	public DVector getAcc()
	{
		return this.acc;
	}
	
	public void setAcc(DVector acc)
	{
		this.acc = acc;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public void setColor(Color c)
	{
		this.color = c;
	}
	
}
