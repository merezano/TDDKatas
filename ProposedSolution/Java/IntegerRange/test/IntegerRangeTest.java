

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IntegerRangeTest {
	private static final int LOWER_BOUND = 5;
	private static final int UPPER_BOUND = 50;
	IntegerRange sut;

	@Before
	public void setUp() {
		sut = new IntegerRange(LOWER_BOUND, UPPER_BOUND);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parametersShouldBePassedInOrder() {
		sut = new IntegerRange(10, 1);
		assertTrue(sut.max() + " is not greater than " + sut.min(),
				sut.max() >= sut.min());
	}

	@Test
	public void theMinimumValueIsTheLowerBound() {
		assertEquals(LOWER_BOUND, sut.min());
	}

	@Test
	public void theMaximumValueIsTheUpperBound() {
		assertEquals(UPPER_BOUND, sut.max());
	}

	@Test
	public void theSizeOfTheRangeIsTheCountOfIntegersIncluded() {
		assertEquals(UPPER_BOUND - LOWER_BOUND + 1, sut.size());
	}

	@Test
	public void intersectsWithAnOverlappingRange() {
		IntegerRange overlappingRange = new IntegerRange(LOWER_BOUND + 5,
				UPPER_BOUND + 5);

		assertTrue(sut.intersects(overlappingRange));
	}

	@Test
	public void intersectsWithRangeThatEndsOnTheLowerBound() {
		IntegerRange anotherRange = new IntegerRange(LOWER_BOUND - 10,
				LOWER_BOUND);

		assertTrue(sut.intersects(anotherRange));
	}

	@Test
	public void intersectsWithARangeThatBeginsOnUpperBound() {
		IntegerRange anotherRange = new IntegerRange(UPPER_BOUND,
				UPPER_BOUND + 10);

		assertTrue(sut.intersects(anotherRange));
	}

	@Test
	public void intersectionWithAnOverlappingRange() {
		final int overlappingLowerBound = LOWER_BOUND + 5;
		final int overlappingUpperBound = UPPER_BOUND + 5;
		IntegerRange overlappingRange = new IntegerRange(overlappingLowerBound,
				overlappingUpperBound);
		IntegerRange intersection = sut.intersection(overlappingRange);
		IntegerRange expectedRange = new IntegerRange(overlappingLowerBound,
				UPPER_BOUND);

		assertTrue(intersection.equals(expectedRange));
	}

	@Test
	public void intersectionithASubrangeIsTheSubrange() {
		IntegerRange subrange = new IntegerRange(LOWER_BOUND + 5,
				UPPER_BOUND - 5);
		IntegerRange intersection = sut.intersection(subrange);

		assertTrue(subrange.equals(intersection));
	}

	@Test
	public void intersectionWithASuperRangeIsTheRange() {
		IntegerRange superrange = new IntegerRange(LOWER_BOUND - 5,
				UPPER_BOUND + 5);
		IntegerRange intersection = sut.intersection(superrange);

		assertTrue(sut.equals(intersection));
	}

	@Test
	public void intersectionWithASimilarRangeIsTheRangeItself() {
		IntegerRange anEquivalentRange = sut;
		IntegerRange intersection = sut.intersection(anEquivalentRange);

		assertTrue(sut.equals(intersection));
	}

	@Test
	public void coverWithAnOverlappingRangeIsTheUnionOfTheRanges() {
		final int overlappingLoweBound = LOWER_BOUND + 5;
		final int overlappingUpperBound = UPPER_BOUND + 5;
		IntegerRange anotherRange = new IntegerRange(overlappingLoweBound, overlappingUpperBound);
		IntegerRange expectedRange = new IntegerRange(LOWER_BOUND, overlappingUpperBound);

		assertTrue(expectedRange.equals(sut.cover(anotherRange)));
	}
}