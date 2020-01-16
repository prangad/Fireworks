import java.awt.Color;
import java.util.ArrayList;

public class AppConstants {
	
	//Window Variables
	public static String WINDOW_TITLE = "Firework Application";
	public static int WINDOW_WIDTH = 1600;
	public static int WINDOW_HEIGHT = 900;
	
	//Application Variables
	public static ArrayList<Color> COLORS = new ArrayList<Color>();
	public static double FRAME_RATE = 100;
	public static double GRAVITY = .3;
	
	public static double STARTING_VELOCITY_MIN = -23;
	public static double STARTING_VELOCITY_MAX = -16;
	
	public static int FIREWORK_COUNT = 10;
	public static int EXPLOSION_PARTICLE_COUNT = 50;
	
	//Methods
	public static void populateColors()
	{
		for (int r=0; r<100; r++)
			COLORS.add(new Color(r*255/100, 255, 0));
		for (int g=100; g>0; g--)
			COLORS.add(new Color(255, g*255/100, 0));
		for (int b=0; b<100; b++)
			COLORS.add(new Color(255, 0, b*255/100));
		for (int r=100; r>0; r--)
			COLORS.add(new Color(r*255/100, 0, 255));
		for (int g=0; g<100; g++)
			COLORS.add(new Color(0, g*255/100, 255));
		for (int b=100; b>0; b--)
			COLORS.add(new Color(0, 255, b*255/100));
		COLORS.add(new Color(0, 255, 0));
	}
}
