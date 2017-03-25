package saifulIslam.AlgorithmForCheck;

import java.util.Arrays;

public class LCS {

	public static double lcsCheck(String mother, String child) {

		if (mother == null || child == null)
			return -1.0;
		int motherSize = mother.length(), childSize = child.length();
		dp = new int[childSize + 10][motherSize + 10];

		for (int i = 0; i <= motherSize + 2; i++)
			dp[0][i] = 0;
		for (int i = 0; i <= childSize + 2; i++)
			dp[i][0] = 0;

		for (int i = 1; i <= childSize; i++) {

			for (int j = 1; j <= motherSize; j++) {

				if (child.charAt(i - 1) == mother.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}

		}

		return (double) dp[childSize][motherSize];
	}

	private static int[][] dp;
}
