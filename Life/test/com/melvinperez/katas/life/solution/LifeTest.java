package com.melvinperez.katas.life.solution;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.melvinperez.katas.life.solution.Life;

public class LifeTest {

	private static final int HEIGHT = 10;
	private static final int WIDTH = 10;
	private Life sut;

	@Test
	public void aDeadCellWithExactlyThreeNeighborsBecomesAlive() {
		sut.turnAlive(1, 2);
		sut.turnAlive(2, 1);
		sut.turnAlive(2, 2);

		assertFalse(sut.isAlive(1, 1));

		sut.next();

		assertTrue(sut.isAlive(1, 1));
	}

	@Test
	public void aLiveCellWithFewerThanTwoNeighborsDies() {
		sut.turnAlive(1, 1);
		sut.turnAlive(1, 2);

		sut.next();

		assertFalse(sut.isAlive(1, 1));
	}

	@Test
	public void aLiveCellWithMoreThanThreeNeighborsDies() {
		sut.turnAlive(1, 1);
		sut.turnAlive(1, 2);
		sut.turnAlive(2, 1);
		sut.turnAlive(2, 2);
		sut.turnAlive(3, 1);

		sut.next();

		assertFalse(sut.isAlive(2, 2));
	}

	@Test
	public void aLiveCellWithThreeNeighborsRemainsAlive() {
		sut.turnAlive(1, 1);
		sut.turnAlive(1, 2);
		sut.turnAlive(2, 1);
		sut.turnAlive(2, 2);

		sut.next();

		assertTrue(sut.isAlive(1, 2));
	}

	@Test
	public void aLiveCellWithTwoNeighborsRemainsAlive() {
		sut.turnAlive(1, 2);
		sut.turnAlive(2, 1);
		sut.turnAlive(2, 2);

		sut.next();

		assertTrue(sut.isAlive(1, 2));
	}

	@Before
	public void setUp() throws Exception {
		sut = new Life(WIDTH, HEIGHT);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ignoreLifeOutsideTheUniverse() {
		sut.turnAlive(0, 0);
		sut.turnAlive(WIDTH + 1, HEIGHT + 1);
		assertFalse(sut.isAlive(0, 0));
		assertFalse(sut.isAlive(WIDTH + 1, HEIGHT + 1));
	}

	@Test
	public void cellsOnTheBordersAreMoreIsolated() {
		sut.turnAlive(1, HEIGHT);
		sut.turnAlive(1, HEIGHT - 1);
		sut.turnAlive(2, HEIGHT);

		sut.next();
		assertTrue(sut.isAlive(2, HEIGHT - 1));
	}
}
