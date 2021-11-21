package SnakeSRC;

import java.util.ArrayList;

public class Snake {

	ArrayList<Point> body;

	Snake(Point head) {
		body = new ArrayList<Point>();
		body.add(head);
	}

	public Point getHead() {
		return body.get(0);
	}

	public Point getTail() {
		return body.get(body.size() - 1);
	}

	public Point getPart(int index) {
		return body.get(index);
	}

	public int getSize() {
		return body.size();
	}

	public void move(Direction direction) {
		// Add new head
		body.add(0, Point.getNextPoint(getHead(), direction));

		// Remove tail
		body.remove(body.size() - 1);
	}

	public void moveAndGrow(Direction direction) {
		// Add new head
		body.add(0, Point.getNextPoint(getHead(), direction));
	}
}
