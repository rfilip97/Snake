package SnakeSRC;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import SnakeSRC.Logger.LogLevels;

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

		Logger logger = Logger.getInstance();
		logger.log(LogLevels.DEBUG, "GUI Constructed");
	}

	public void Run() {
		Logger logger = Logger.getInstance();
		logger.log(LogLevels.DEBUG, "Started the game");

		// Main Loop
		while (true) {
			try {
				if (snakeShouldMove) {
					// Game Over condition
					if (snake.isSnakeOnPoint(Point.getNextPoint(snake.getHead(), direction)))
					{
						logger.log(LogLevels.INFO, "GAME OVER");
						return;
					}

					// Snake eats the food
					if (snake.getHead().equals(food)) {
						// Regenerate food if snake ate it :)
						regenerateFood();

						// Move and grow the snake
						snake.moveAndGrow(direction);
						freeSqTracker.removeElement(snake.getHead());
					} else {
						// Simply move the snake
						snake.move(direction);
						freeSqTracker.removeElement(snake.getHead());
						freeSqTracker.addElement(snake.getTail());
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
			Logger logger = Logger.getInstance();

			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (direction != Direction.DOWN) {
					direction = Direction.UP;
				}
				logger.log(LogLevels.DEBUG, "Pressed up");
				break;
			case KeyEvent.VK_DOWN:
				if (direction != Direction.UP) {
					direction = Direction.DOWN;
				}
				logger.log(LogLevels.DEBUG, "Pressed down");
				break;
			case KeyEvent.VK_LEFT:
				if (direction != Direction.RIGHT) {
					direction = Direction.LEFT;
				}
				logger.log(LogLevels.DEBUG, "Pressed left");
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != Direction.LEFT) {
					direction = Direction.RIGHT;
				}
				logger.log(LogLevels.DEBUG, "Pressed right");
				break;
			}
		}
	}
}
