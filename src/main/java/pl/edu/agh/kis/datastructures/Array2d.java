package pl.edu.agh.kis.datastructures;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Iterator;
import java.util.List;

public class Array2d implements Iterable<Object> {
	private Object[][] table;

	public static Array2d fromList(List<Object> elements, int length, int height) {
		checkArgument(elements.size() == length * height,
				"number of elements provided is different than expected size of matrix");
		Array2d l = new Array2d();
		l.init(length, height);
		int currentX = 0;
		int currentY = 0;
		for (Object e : elements) {
			l.table[currentX][currentY] = e;
			currentX++;
			if (currentX >= length) {
				currentX = 0;
				currentY++;
			}
		}
		return l;
	}

	@Override
	public Iterator<Object> iterator() {
		return rowLike().iterator();
	}

	public Iterable<Object> rowLike() {
		return new RowLikeIterable();
	}

	public Iterable<Object> columnLike() {
		return new ColumnLikeIterable();
	}

	private void init(int length, int height) {
		checkArgument(length > 0);
		checkArgument(height > 0);
		if (table == null) {
			table = new Object[length][height];
		}
	}
}