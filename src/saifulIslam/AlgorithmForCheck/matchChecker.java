package saifulIslam.AlgorithmForCheck;

import java.math.BigInteger;
import java.util.Random;

/*
 * Saiful Islam Liton
 * SUST
 * CSE 13
 *
 *
 */
public class matchChecker {

	public static long CopyPaste(String mother, String child) {
		lengthOfMother = mother.length();
		lengthOfChild = child.length();

		if (lengthOfMother > lengthOfChild) {
			return copyCheckMaster(mother, child);
		} else
			return copyCheckMaster(child, mother);

	}

	protected static long copyCheckMaster(String mother, String child) {

		lengthOfChild = child.length();
		lengthOfMother = mother.length();

		total_exp_child = 1;
		longPrime = randomPrimeFounder();

		// total expoential value found

		var = lengthOfChild - 1;

		for (int i = 0; i < var; i++) {
			total_exp_child = (total_exp_child * exp) % longPrime;
		}
		/// System.out.println(total_exp_child);

		// hash value found for child and mother

		hashOfMother = 0;
		hashOfChild = 0;

		for (int i = 0; i < lengthOfChild; i++) {
			hashOfMother = (hashOfMother * exp + mother.charAt(i)) % longPrime;
			hashOfChild = (hashOfChild * exp + child.charAt(i)) % longPrime;

		}

		// System.out.println(hashOfMother + " " + hashOfChild);

		/// karp Robin check

		var = lengthOfMother - lengthOfChild;

		count = 0;

		for (int i = 0; i <= var; i++) {

			if (hashOfMother == hashOfChild) {

				if (checkCharToChar(mother, child, i)) {
					// System.out.println("Found " + i);
					return i;
					//count++;
				}

			}
			if (i < var) {
				hashOfMother = (exp * (hashOfMother - mother.charAt(i) * total_exp_child)
						+ mother.charAt((int) (i + lengthOfChild))) % longPrime;

				if (hashOfMother < 0) {
					hashOfMother = hashOfMother + longPrime;
				}
			}

		}

		return -1;
	}
	/*
	 * random Logest prime Founder
	 */

	private static long randomPrimeFounder() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();

	}

	/*
	 * char To Char Check
	 */
	private static boolean checkCharToChar(String mother, String child, int startIndex) {
		for (int i = 0; i < lengthOfChild; i++) {
			if (child.charAt(i) != mother.charAt(i + startIndex)) {
				return false;
			}
		}
		return true;
	}

	private static long count, var, hashOfMother, hashOfChild, total_exp_child, lengthOfChild, lengthOfMother;
	private static final long exp = 256;
	private static long longPrime;
}
