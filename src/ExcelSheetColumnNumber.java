import core.Util;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int ret = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int n = chars[i] - 64;
			if (n < 1 && n > 26) {
				return 0;
			}
			ret = ret * 26 + n;
		}
		return ret;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber ins = new ExcelSheetColumnNumber();
		String input = "A";
		Util.printInput(input);
		Util.printResult(ins.titleToNumber(input), 1);

		input = "Z";
		Util.printInput(input);
		Util.printResult(ins.titleToNumber(input), 26);

		input = "AA";
		Util.printInput(input);
		Util.printResult(ins.titleToNumber(input), 27);

	}
}
