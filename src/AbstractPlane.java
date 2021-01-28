import java.awt.Graphics;

public abstract class AbstractPlane {

	/* 	Primary position of points and coordinate axes (stationary - at the center of the window)
	 * 
	 * 				       z^	  
	 * 					|    ^y
	 * 					|   /
	 * 				A*------+------*B
	 * 				 |	| /    |
	 * 				 |	|/     |	 
	 * 	           	---------+------+------+--------->
	 * 				 |	|      | 	x
	 * 				 |	|      |	 
	 * 				D*------+------*C
	 * 					|
	 * 					|
	 * 					|
	 * 
	 * 
	 */
	protected int xA, xB, xC, xD, yA, yB, yC, yD;
	// Coordinates - actually
	protected int xAa, xBa, xCa, xDa, yAa, yBa, yCa, yDa;

	/* Rotation of the plane
	 * e.g. +RotX:
	 *  	      __
	 * 	     /  \
	 * 	    /    v
	 * --------|------------> 
	 * 	    ^	        x
	 * 	     \__/
	 * 
	 */
	protected int velRotX, velRotY, velRotZ;
	
	// Movement of viewer
	protected int velX, velY, velZ;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	// Setting actual coordinate system relative to the center of the window
	protected void setActual() {
		xAa = xA + 320;
		xBa = xB + 320;
		xCa = xC + 320;
		xDa = xD + 320;
		yAa = 210-yA;
		yBa = 210-yB;
		yCa = 210-yC;
		yDa = 210-yD;
	}
	
	// Getters and setters
	public int getxA() {
		return xA;
	}
	public void setxA(int xA) {
		this.xA = xA;
	}
	public int getxB() {
		return xB;
	}
	public void setxB(int xB) {
		this.xB = xB;
	}
	public int getxC() {
		return xC;
	}
	public void setxC(int xC) {
		this.xC = xC;
	}
	public int getxD() {
		return xD;
	}
	public void setxD(int xD) {
		this.xD = xD;
	}
	public int getyA() {
		return yA;
	}
	public void setyA(int yA) {
		this.yA = yA;
	}
	public int getyB() {
		return yB;
	}
	public void setyB(int yB) {
		this.yB = yB;
	}
	public int getyC() {
		return yC;
	}
	public void setyC(int yC) {
		this.yC = yC;
	}
	public int getyD() {
		return yD;
	}
	public void setyD(int yD) {
		this.yD = yD;
	}
	public int getVelRotX() {
		return velRotX;
	}
	public void setVelRotX(int velRotX) {
		this.velRotX = velRotX;
	}
	public int getVelRotY() {
		return velRotY;
	}
	public void setVelRotY(int velRotY) {
		this.velRotY = velRotY;
	}
	public int getVelRotZ() {
		return velRotZ;
	}
	public void setVelRotZ(int velRotZ) {
		this.velRotZ = velRotZ;
	}
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelZ() {
		return velZ;
	}
	public void setVelZ(int velZ) {
		this.velZ = velZ;
	}
}
