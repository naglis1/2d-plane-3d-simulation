import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Plane plane;
	
	public KeyInput(Plane plane) {
		this.plane = plane;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		/* Plane rotation:
		 * 					PgUp(clockwise)
		 * 					PgDn(counter clockwise)
		 * 			UP
		 * 	LEFT	DOWN	RIGHT
		 * 		
		 */
		if (key == KeyEvent.VK_UP) {
			plane.setVelRotX(1);
		}
		if (key == KeyEvent.VK_DOWN) {
			plane.setVelRotX(-1);
		}
		if (key == KeyEvent.VK_RIGHT) {
			plane.setVelRotZ(-3);
		}
		if (key == KeyEvent.VK_LEFT) {
			plane.setVelRotZ(3);
		}
		if (key == KeyEvent.VK_PAGE_UP) {
			plane.setVelRotY(-1);
		}
		if (key == KeyEvent.VK_PAGE_DOWN) {
			plane.setVelRotY(1);
		}
		
		/* Viewer movements:
		 * 				-(move further)
		 * 		8(up)	+(move closer)
		 * 	4(left)	6(right)
		 * 		2(down)
		 *
		 */
		if (key == KeyEvent.VK_NUMPAD8) {
			plane.setVelY(1);
		}
		if (key == KeyEvent.VK_NUMPAD2) {
			plane.setVelY(-1);
		}
		if (key == KeyEvent.VK_NUMPAD4) {
			plane.setVelX(-1);
		}
		if (key == KeyEvent.VK_NUMPAD6) {
			plane.setVelX(1);
		}
		if (key == KeyEvent.VK_PLUS) {
			plane.setVelZ(1);
		}
		if (key == KeyEvent.VK_MINUS) {
			plane.setVelZ(-1);
		}
		
		// Just to be able to escape from this nightmare
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			plane.setVelRotX(0);
		}
		if (key == KeyEvent.VK_DOWN) {
			plane.setVelRotX(0);
		}
		if (key == KeyEvent.VK_RIGHT) {
			plane.setVelRotZ(0);
		}
		if (key == KeyEvent.VK_LEFT) {
			plane.setVelRotZ(0);
		}
		if (key == KeyEvent.VK_PAGE_UP) {
			plane.setVelRotY(0);
		}
		if (key == KeyEvent.VK_PAGE_DOWN) {
			plane.setVelRotY(0);
		}
		if (key == KeyEvent.VK_NUMPAD8) {
			plane.setVelY(0);
		}
		if (key == KeyEvent.VK_NUMPAD2) {
			plane.setVelY(0);
		}
		if (key == KeyEvent.VK_NUMPAD4) {
			plane.setVelX(0);
		}
		if (key == KeyEvent.VK_NUMPAD6) {
			plane.setVelX(0);
		}
		if (key == KeyEvent.VK_PLUS) {
			plane.setVelZ(0);
		}
		if (key == KeyEvent.VK_MINUS) {
			plane.setVelZ(0);
		}
		
	}
	
}
