

public class IntegerRange {
	int lowerBound, upperBound;

	/**
	 * @param lowerBound
	 *            lower bound of the integer range.
	 * @param upperBound
	 *            upper bound of the integer range.
	 */
	public IntegerRange(int lowerBound, int upperBound) {
		if (upperBound < lowerBound)
			throw new IllegalArgumentException();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	/**
	 * @return an integer representing the minimum value in the integer range
	 */
	public int min() {
		return lowerBound;
	}

	/**
	 * @return an integer representing the maximum value in the integer range.
	 */
	public int max() {
		return upperBound;
	}

	/**
	 * @return the count of integers in the range
	 */
	public int size() {
		return upperBound - lowerBound + 1;
	}

	/**
	 * @param anotherRange
	 * @return true if the given IntegerRange has a non-empty intersection with
	 *         the passed IntegerRange
	 */
	public boolean intersects(IntegerRange anotherRange) {
		return (this.lowerBound <= anotherRange.max() && anotherRange.min() <= this.upperBound);
	}

	/**
	 * @param anotherRange
	 * @return an IntegerRange representing the intersection of the given
	 *         instance and the passed instance.
	 */
	public IntegerRange intersection(IntegerRange anotherRange) {
		if (!intersects(anotherRange))
			return null;
		else {
			int greatestLowerBound = Math.max(lowerBound, anotherRange.min());
			int smallestUpperBound = Math.min(upperBound, anotherRange.max());
			return new IntegerRange(greatestLowerBound, smallestUpperBound);
		}
	}

	/**
	 * @param anotherRange
	 * @return an IntegerRange that is the smallest IntegerRange that includes
	 *         both the given instance and the passed instance
	 */
	public IntegerRange cover(IntegerRange anotherRange) {
		int smallestLowerBound = Math.min(lowerBound, anotherRange.min());
		int greatestUpperBound = Math.max(upperBound, anotherRange.max());
		return new IntegerRange(smallestLowerBound, greatestUpperBound);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objRange) {
		if (objRange == null)
			return false;

		if (objRange instanceof IntegerRange == false)
			return false;

		IntegerRange anotherRange = (IntegerRange) objRange;
		return (anotherRange.min() == lowerBound && anotherRange.max() == upperBound);
	}
}
