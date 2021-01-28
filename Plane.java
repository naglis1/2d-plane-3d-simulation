import java.awt.Color;
import java.awt.Graphics;

public class Plane extends AbstractPlane {
	public Plane() {
		super();
		xA = -50;
		yA = 50;
		xB = 50;
		yB = 50;
		xC = 50;
		yC = -50;
		xD = -50;
		yD = -50;
		
	}

	@Override
	public void tick() {
		// All work will be done here
		
		setActual();
	}
	
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		
		// Drawing rectangle
		//AB
		g.drawLine(xAa, yAa, xBa, yBa);
		//BC
		g.drawLine(xBa, yBa, xCa, yCa);
		//CD
		g.drawLine(xCa, yCa, xDa, yDa);
		//DA
		g.drawLine(xDa, yDa, xAa, yAa);
		
	}
}
