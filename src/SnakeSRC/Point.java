package SnakeSRC;

public class Point {

	private int x;
	private int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Point getNextPoint(Point point, Direction direction) {
		switch (direction) {
		case UP:
			return new Point(point.x, point.y - 1);
		case DOWN:
			return new Point(point.x, point.y + 1);
		case LEFT:
			return new Point(point.x - 1, point.y);
		case RIGHT:
			return new Point(point.x + 1, point.y);
		default:
			return new Point(point.x, point.y);
		}
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
}
