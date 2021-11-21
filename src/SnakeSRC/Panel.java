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

	static final int WIDTH = 800;
	static final int HEIGHT = 800;
	static final int UNIT = HEIGHT / 100;
	static final int NR_OF_UNITS_IN_LINE = HEIGHT / UNIT;

	Snake snake;

	Panel(Snake snake) {
		this.snake = snake;
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

		// Draw each part of the snake
		for (int i = 0; i < snake.getSize(); i++) {
			Point part = snake.getPart(i);
			drawPart(g, part.getX(), part.getY());
		}
	}

	public void drawPart(Graphics g, int x, int y) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.setColor(Color.GREEN);
		graphics.setStroke(new BasicStroke(UNIT));
		graphics.drawLine(x * UNIT, y * UNIT, x * UNIT, y * UNIT);
	}
}
