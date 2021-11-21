package SnakeSRC;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;

	private static int FRAME_SPEED = 500; // one frame is drawn each 'FRAME_SPEED' ms
	boolean snakeShouldMove = true; // set this to false to stop the snake from moving, used for debugging
	int x = 2;
	int y = 2;
	Direction direction = Direction.RIGHT;
	Panel panel;
	Snake snake;
	Point spawn;

	// Game
	Game() {
		spawn = new Point(10, 10); // Spawning point
		snake = new Snake(spawn);
		panel = new Panel(snake);
		this.add(panel);
		this.setTitle("Snek");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.requestFocus();
		this.addKeyListener(new KeyListener());
		System.out.println("GUI Constructed");
	}

	public void Run() {
		System.out.println("Started the game");

		// Main Loop
		while (true) {
			try {
				if (snakeShouldMove) {
					snake.move(direction);
					repaint();
				}

				TimeUnit.MILLISECONDS.sleep(FRAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// KeyListener
	public class KeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				System.out.println("Pressed up");
				direction = Direction.UP;
				break;
			case KeyEvent.VK_DOWN:
				direction = Direction.DOWN;
				System.out.println("Pressed down");
				break;
			case KeyEvent.VK_LEFT:
				direction = Direction.LEFT;
				System.out.println("Pressed left");
				break;
			case KeyEvent.VK_RIGHT:
				direction = Direction.RIGHT;
				System.out.println("Pressed right");
				break;
			}
		}
	}
}
