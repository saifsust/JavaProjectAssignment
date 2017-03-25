package saifulIslam.AlgorithmForCheck;

import java.math.BigInteger;
import java.util.Random;
import java.util.Stack;

/*
 * saiful islam
 * cse 13
 * 2013331007
 */
public class stringProcessor extends matchChecker {

	/*
	 *
	 * public static boolean skipLoop(String mother) {
	 *
	 * String str = "";
	 *
	 * if (mother != null) { mother = mother.replaceAll(" ", ""); if
	 * (mother.length() > 0) { int index = (int) copyCheckMaster(mother, "(");
	 * if (index > -1) { str = mother.substring(0, index); } } } switch (str) {
	 * case "for": return true; case "while": return true; case "switch": return
	 * true; case "if": return true;
	 *
	 * case "": return false;
	 *
	 * default: return false; } }
	 *
	 * public static CharSequence getFirstCurlyBracket(String mother) {
	 *
	 * if (mother != null && mother.length() > 0) { int index = (int)
	 * copyCheckMaster(mother, "{"); if (index > -1) { return
	 * mother.subSequence(index, index + 1); }
	 *
	 * } return null; }
	 *
	 * public static CharSequence getSecondCurlyBracket(String mother) {
	 *
	 * if (mother != null && mother.length() > 0) { int index = (int)
	 * copyCheckMaster(mother, "}"); if (index > -1) { return
	 * mother.subSequence(index, index + 1); }
	 *
	 * } return null;
	 *
	 * }
	 */

	public static String getRegistrationNum(String father) {
		if (father == null)
			return null;
		int size = father.length();
		if (size > 0) {
			int index = (int) copyCheckMaster(father, "\\");
			if (index > -1) {
				return father.substring(index + 1, size);
			}

		}

		return null;
	}

	public static String ingorSpace(String mother) {
		return mother.replaceAll(" ", "");
	}

	public static String ignorCaseSensitivity(String mother) {
		return mother.toLowerCase();
	}

	public static boolean ignor(String mother) {
		if (mother != null && mother.length() > 3)
			if (CopyPaste(mother, "#include") > -1 || CopyPaste(mother, "import") > -1
					|| CopyPaste(mother, "package") > -1)
				return true;
		return false;
	}

	public static String ignorBackSlashComment(String mother) {

		if (mother != null) {
			int size = mother.length();
			if (size > 1) {
				int index = (int) copyCheckMaster(mother, "//");
				if (index > -1)
					return mother.substring(0, index);
			}
		}
		return null;
	}

	public static String ignorBackSlashStar(String mother) {

		if (mother != null) {
			if (mother.length() > 1) {
				int index = (int) copyCheckMaster(mother, "/*");
				/// System.out.println(index);
				if (index > -1) {
					return mother.substring(0, index);
				}
			}
		}

		return null;
	}

	public static String ignorStarBackslash(String mother) {

		if (mother != null) {
			int size = mother.length();
			if (size > 1) {
				int index = (int) copyCheckMaster(mother, "*/");
				if (index > -1)
					return mother.substring(index + 2, size);
			}
		}
		return null;
	}

	public static String ignorDot(String mother) {

		if (mother != null) {
			int size = mother.length();
			if (size > 1) {
				int index = (int) copyCheckMaster(mother, ".");
				if (index > -1)
					return mother.substring(0,index);
			}
		}
		return null;
	}

}
