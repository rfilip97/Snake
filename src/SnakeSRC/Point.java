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

	public static int pointToNumber(Point point) {
		return point.getY() * GameConfig.NR_OF_UNITS_IN_LINE + point.getX();
	}

	public static Point numberToPoint(int nr) {
		int x = nr % GameConfig.NR_OF_UNITS_IN_LINE;
		int y = nr / GameConfig.NR_OF_UNITS_IN_LINE;
		return new Point(x, y);
	}

	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		// If not compared to a Point, return false
		if (!(o instanceof Point)) {
			return false;
		}

		// Typecast o to Point so that we can compare data members
		Point point = (Point) o;

		// Compare the data members and return accordingly
		return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
	}
}
