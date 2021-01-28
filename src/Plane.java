import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

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
		// ROTATING AROUND Z AXIS
		
		// For smooth, realistic, equal rotation speed distribution (not exactly 90 degree cuz cosine would be 0, so no movement supported at primary positions)
		xA -= velRotZ*Math.cos(Math.toRadians(89.9*xA/50));
		xB += velRotZ*Math.cos(Math.toRadians(89.9*xB/50));
		
		
		// Switch points, when the bounds are reached
		if (xA > 50) {
			xA = -50;
		}
		if (xB < -50) {
			xB = 50;
		}
		if (xA < -50) {
			xA = 50;
		}
		if (xB > 50) {
			xB = -50;
		}
		
		// Follow coordinates
		xD = xA;
		xC = xB;
		
		// Make an arc for Y axis of ellipse form
		yA = 50+Math.sin(Math.toRadians(30))*50*Math.sqrt(1-(xA*xA)/(50*50));
		yC = yA-100;
		
		yB = 50-Math.sin(Math.toRadians(30))*50*Math.sqrt(1-((xB*xB)/(50*50)));
		yD = yB-100;
		
		
		
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
