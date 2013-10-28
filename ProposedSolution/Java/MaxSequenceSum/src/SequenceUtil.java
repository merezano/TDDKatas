import java.util.List;

public class SequenceUtil {

	private static final int MINIMUM_SUM = 0;

	public static int maxSum(List<Integer> sequence) {
		int maxSumUpToThisPoint = MINIMUM_SUM;
		int maxSumEndingHere = MINIMUM_SUM;

		for (Integer value : sequence) {
			maxSumEndingHere = Math.max(MINIMUM_SUM, maxSumEndingHere + value);
			maxSumUpToThisPoint = Math.max(maxSumEndingHere, maxSumUpToThisPoint);
		}

		return maxSumUpToThisPoint;
	}
}
