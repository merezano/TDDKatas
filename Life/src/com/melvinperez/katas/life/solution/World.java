package com.melvinperez.katas.life.solution;
/**
 * @author melvinperez
 *
 */
public class World {
	private boolean[][] generation;
	private final int height;
	private final int width;

	public World(final int rows, final int columns) {
		height = rows;
		width = columns;
		generation = new boolean[height + 2][width + 2];
	}

	public final boolean getCellAt(final int row, final int col) {
		return generation[row][col];
	}

	public final int getHeight() {
		return height;
	}

	public final int getNeighborsFor(final int row, final int col) {
		if (outOfBounds(row, col)) {
			throw new IllegalArgumentException("Cell is out of bounds.");
		}
		return neighborsCount(row, col);
	}

	public final int getWidth() {
		return width;
	}

	public final void setCell(final int row, final int col, final boolean state) {
		if (outOfBounds(row, col)) {
			throw new IllegalArgumentException("Cell is out of bounds.");
		}
		generation[row][col] = state;
	}

	private int neighborsCount(final int row, final int col) {
		int neighbors = 0;

		for (int i = row - 1; i < row + 2; i++) {
			for (int j = col - 1; j < col + 2; j++) {
				final boolean inCurrentCell = i == row && j == col;

				if (!inCurrentCell && getCellAt(i, j)) {
					neighbors++;
				}
			}
		}
		return neighbors;
	}

	private boolean outOfBounds(final int row, final int col) {
		return (row == 0 || row > height) || (col == 0 || col > width);
	}
}