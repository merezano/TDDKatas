import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class TestMaxSequenceSum {
	private List<Integer> aList = new ArrayList<Integer>();

	@Test public void wikipediaExample() {
		aList.add(2);
		aList.add(1); 
		aList.add(-3);
		aList.add(4);
		aList.add(-1);
		aList.add(2);
		aList.add(1);
		aList.add(-5);
		aList.add(4);
		assertEquals(6, SequenceUtil.maxSum(aList));
	}
	@Test
	public void MaxSumOfOnePositiveAndANegativeIsThePositiveValue() {
		aList.add(2);
		aList.add(-1);
		assertEquals(2, SequenceUtil.maxSum(aList));
	}
	@Test
	public void testMaxSum() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(-2);
		aList.add(1);
		assertEquals(3, SequenceUtil.maxSum(aList));
	}

	@Test
	public void test2MaxSum() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(-1);
		aList.add(2);
		assertEquals(4, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfAnEmptyListIsZero() {
		List<Integer> aList = new ArrayList<Integer>();
		assertEquals(0, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfPossitiveSingletonIsValueItself() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(3);
		assertEquals(3, SequenceUtil.maxSum(aList));
	}

	@Ignore @Test
	public void maxSumOfNegativeSingletonIsValueItself() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(-7);
		assertEquals(-7, SequenceUtil.maxSum(aList));
	}

	@Ignore @Test
	public void maxSumOfSingletonMinValueIsItself() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfSingletonMaxValueIsItself() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, SequenceUtil.maxSum(aList));
	}

	@Ignore @Test
	public void maxSumOfLessThanMinValueIsMinValue() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(Integer.MIN_VALUE);
		aList.add(-1);
		assertEquals(Integer.MIN_VALUE - 1, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfGreaterThanMaxValueIsMaxValue() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(Integer.MAX_VALUE);
		aList.add(1);
		assertEquals(Integer.MAX_VALUE, SequenceUtil.maxSum(aList));
	}

	@Ignore @Test
	public void maxSumOfAllNegativeValuesIsGreatestValueInList() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(-254);
		aList.add(-9);
		aList.add(-11);
		aList.add(-21);
		assertEquals(-9, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfAllZeroesIsZero() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(0);
		aList.add(0);
		aList.add(0);
		aList.add(0);
		assertEquals(0, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfAllPositiveIsTotalSumOfElements() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(5);
		aList.add(4);
		aList.add(3);
		aList.add(1);
		assertEquals(13, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfMountainPatternIsSumOfPositives() {
		mountainPattern();
		assertEquals(15, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfValleyPatternIsTotalSumOfElements() {
		valleyPattern();
		assertEquals(15, SequenceUtil.maxSum(aList));
	}

	@Test
	public void maxSumOfPeaksPatternIsTheLargestPositiveSequence() {
		valleyPattern();
		assertEquals(15, SequenceUtil.maxSum(aList));
	}

	private void mountainPattern() {
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(4);
		aList.add(5);
		aList.add(-4);
		aList.add(-3);
		aList.add(-2);
		aList.add(-1);
	}

	private void valleyPattern() {
		aList.add(-4);
		aList.add(-3);
		aList.add(-2);
		aList.add(-1);
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(4);
		aList.add(5);
	}

	private void peaksPattern() {
		aList.add(4);
		aList.add(3);
		aList.add(2);
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(-14);
		aList.add(-13);
		aList.add(-12);
		aList.add(-11);
		aList.add(1);
		aList.add(4);
		aList.add(5);
	}

	// return zero due to wrapping of adding to MIN_VALUE
	@Ignore
	@Test
	public void maxSumOfSingletonAddingTwoMinimum() {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(Integer.MIN_VALUE);
		aList.add(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, SequenceUtil.maxSum(aList));
	}
}
