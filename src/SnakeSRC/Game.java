package SnakeSRC;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static int FRAME_SPEED = 500;	// one frame is drawn each 'FRAME_SPEED' ms
	int x = 2;
	int y = 2;
	Direction direction = Direction.RIGHT;

	// Game
	Game() {
		this.add(new Panel());
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
				switch (direction) {
				case UP:
					y--;
					break;
				case DOWN:
					y++;
					break;
				case LEFT:
					x--;
					break;
				case RIGHT:
					x++;
					break;
				}

				repaint();
				TimeUnit.MILLISECONDS.sleep(FRAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Panel
	public class Panel extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;

		static final int WIDTH = 800;
		static final int HEIGHT = 800;
		static final int UNIT = HEIGHT / 100;

		Panel() {
			this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			this.setBackground(Color.black);
			this.setFocusable(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D graphics = (Graphics2D) g;
			graphics.setColor(Color.GREEN);
			graphics.setStroke(new BasicStroke(UNIT));
			graphics.drawLine(x * UNIT, y * UNIT, (x + 1) * UNIT, y * UNIT);

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
