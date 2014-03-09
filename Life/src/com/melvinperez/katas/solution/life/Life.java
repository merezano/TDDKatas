package com.melvinperez.katas.solution.life;

public class Life {

	static final int UNDERPOPULATION_THRESHOLD = 2;
	static final int REPRODUCTION_THRESHOLD = 3;
	static final boolean DEAD = false;
	static final boolean ALIVE = true;
	private World world;

	public Life(final int rows, final int columns) {
		world = new World(rows, columns);
	}

	public final boolean isAlive(final int i, final int j) {
		return world.getCellAt(i, j);
	}

	public final void next() {
		World newWorld = new World(world.getHeight(), world.getWidth());

		for (int i = 1; i < world.getHeight(); i++) {
			for (int j = 1; j < world.getWidth(); j++) {
				newWorld.setCell(i, j, fateOf(i, j));
			}
		}

		world = newWorld;
	}

	public final void turnAlive(final int row, final int col) {
		world.setCell(row, col, ALIVE);
	}

	public final void turnDead(final int row, final int col) {
		world.setCell(row, col, DEAD);
	}

	final boolean fateOf(final int i, final int j) {
		boolean nextState = world.getCellAt(i, j);

		if (isAlive(i, j)) {
			if (isIsolated(i, j) || isOverCrowded(i, j)) {
				nextState = Life.DEAD;
			}
		} else if (isReproducing(i, j)) {
			nextState = Life.ALIVE;
		}

		return nextState;
	}

	final boolean isOverCrowded(final int i, final int j) {
		return world.getNeighborsFor(i, j) > REPRODUCTION_THRESHOLD;
	}

	final boolean isReproducing(final int i, final int j) {
		return world.getNeighborsFor(i, j) == REPRODUCTION_THRESHOLD;
	}

	final boolean isIsolated(final int i, final int j) {
		return world.getNeighborsFor(i, j) < UNDERPOPULATION_THRESHOLD;
	}
}
