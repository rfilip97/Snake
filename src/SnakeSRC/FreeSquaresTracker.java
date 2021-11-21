package SnakeSRC;

import java.util.ArrayList;
import java.util.Collections;

public class FreeSquaresTracker {
	private ArrayList<Integer> array;

	FreeSquaresTracker() {
		array = new ArrayList<Integer>();

		for (int i = 0; i < GameConfig.NR_OF_UNITS_IN_LINE; i++) {
			for (int j = 0; j < GameConfig.NR_OF_UNITS_IN_ROW; j++) {
				Point point = new Point(i, j);
				array.add(Point.pointToNumber(point));
			}
		}

		Collections.sort(array);
	}

	public void addElement(Point posElement) {
		int elem = Point.pointToNumber(posElement);
		if (!array.contains(elem)) {
			array.add(elem);
			Collections.sort(array);
		}
	}

	public void removeElement(Point posElement) {
		int elem = Point.pointToNumber(posElement);
		array.remove(Integer.valueOf(elem));
	}

	public void printAll() {
		for (Integer item : array) {
			System.out.println(" Item: " + item);
		}
	}

}
