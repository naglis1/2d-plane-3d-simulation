import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Main extends Canvas {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640, HEIGHT = 480;
	
	// I actually should do sth with this
	private boolean running = true;
	
	private Plane plane;
	
	public Main() {
		
		plane = new Plane();
		this.addKeyListener(new KeyInput(plane));
		new Window(WIDTH, HEIGHT, "3D SIMULATION", this);
	
	}
	
	public void runProgram() {
		
		// Just to avoid every time clicking this mouse on the window
		this.requestFocus(); 
		
		// Game loop...
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) 
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		// ...which has to be analyzed... one day
		
		System.exit(1);
	}
	
	private void tick() {
		plane.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			// Creating 3 buffers, which means whatever
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		// Color the window
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		plane.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
