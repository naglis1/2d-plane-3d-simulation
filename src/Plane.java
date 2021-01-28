import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

public class Plane extends AbstractPlane {
	// From what angle we are seeing upper side of rectangle; at what distance we are standing from the center of the rectangle
	private double angle, yPos = 50*Math.sqrt(3);
	// For changing x coordinate of the points, after walking towards
	private double oldHeight;
	
	//half of rectangle rotating axis projection height
	private double height = 50;
	
	public Plane() {
		super();
		xA = -height;
		yA = height;
		xB = height;
		yB = height;
		xC = height;
		yC = -height;
		xD = -height;
		yD = -height;
	}

	@Override
	public void tick() {
		
		
		//zooming:
		yPos -= velY;
		oldHeight = height;
		height = 2500*Math.sqrt(3)/yPos;
		angle = Math.atan(50/yPos);
		
		//trying to fix the mess AND IT WORKS!!!!!
		xA = xA*(height/oldHeight);
		xB = xB*(height/oldHeight);
		
		// For smooth, realistic, equal rotation Z speed distribution (not exactly 90 degree cuz cosine would be 0, so no movement supported at primary positions)
		xA = xA - velRotZ*height/50*Math.cos(Math.toRadians(89.9*xA/height));
		xB = xB + velRotZ*height/50*Math.cos(Math.toRadians(89.9*xB/height));
		// Switch points, when the bounds are reached
		if (xA > height) {
			xA = -height;
		}
		if (xB < -height) {
			xB = height;
		}
		if (xA < -height) {
			xA = height;
		}
		if (xB > height) {
			xB = -height;
		}
		
		// Follow coordinates
		xD = xA;
		xC = xB;
		
		// Make an arc, formed from ellipse
		yA = height+Math.sin(angle)*height*Math.sqrt(1-((xA*xA)/(height*height)));
		yC = yA-2*height;
		
		yB = height-Math.sin(angle)*height*Math.sqrt(1-((xB*xB)/(height*height)));
		yD = yB-2*height;
		
		
		
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
