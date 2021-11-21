package SnakeSRC;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;

	boolean snakeShouldMove = true; // set this to false to stop the snake from moving, used for debugging
	int x = 2;
	int y = 2;
	Direction direction = Direction.RIGHT;
	FreeSquaresTracker freeSqTracker;
	Point food;
	Point spawn;
	Panel panel;
	Snake snake;

	// Game
	Game() {
		spawn = new Point(10, 10); // Spawning point
		snake = new Snake(spawn);
		freeSqTracker = new FreeSquaresTracker();
		freeSqTracker.removeElement(spawn);
		food = freeSqTracker.popRandomFreeSquare();
		panel = new Panel(snake, food);
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
					// Move the snake
					snake.move(direction);

					// Regenerate food if snake ate it :)
					if (snake.getHead().equals(food)) {
						System.out.println("Snake ate the food");
						regenerateFood();
					}

					// Repaint
					repaint();
				}

				TimeUnit.MILLISECONDS.sleep(GameConfig.FRAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void regenerateFood() {
		food = freeSqTracker.popRandomFreeSquare();
		panel.updateFood(food);
	}

	// KeyListener
	public class KeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				System.out.println("Pressed up");
				if (direction != Direction.DOWN) {
					direction = Direction.UP;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direction != Direction.UP) {
					direction = Direction.DOWN;
				}
				System.out.println("Pressed down");
				break;
			case KeyEvent.VK_LEFT:
				if (direction != Direction.RIGHT) {
					direction = Direction.LEFT;
				}
				System.out.println("Pressed left");
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != Direction.LEFT) {
					direction = Direction.RIGHT;
				}
				System.out.println("Pressed right");
				break;
			}
		}
	}
}
