package SnakeSRC;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	Snake snake;
	Point food;

	Panel(Snake snake, Point food) {
		this.snake = snake;
		this.food = food;
		this.setPreferredSize(new Dimension(GameConfig.WIDTH, GameConfig.HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw each part of the snake
		for (int i = 0; i < snake.getSize(); i++) {
			Point part = snake.getPart(i);
			drawPart(g, part.getX(), part.getY());
		}

		drawFood(g);
	}

	public void drawPart(Graphics g, int x, int y) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.setColor(Color.GREEN);
		graphics.setStroke(new BasicStroke(GameConfig.UNIT));
		graphics.drawLine(x * GameConfig.UNIT, y * GameConfig.UNIT, x * GameConfig.UNIT, y * GameConfig.UNIT);
	}

	public void drawFood(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.setColor(Color.RED);
		graphics.setStroke(new BasicStroke(GameConfig.UNIT));
		graphics.drawLine(food.getX() * GameConfig.UNIT, food.getY() * GameConfig.UNIT, food.getX() * GameConfig.UNIT,
				food.getY() * GameConfig.UNIT);

	}

	public void updateSnake(Snake snake) {
		this.snake = snake;
	}

	public void updateFood(Point food) {
		this.food = food;
	}
}
