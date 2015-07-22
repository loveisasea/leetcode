import core.Util;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder(); 
		while (n > 0) {
			int remainder = n % 26;
			n = n / 26;
			if (remainder == 0) {
				remainder = 26;
				n = n - 1;
			}
			char c = (char) (remainder + 64);
			sb.insert(0, c);
		}
		;
		return sb.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle ins = new ExcelSheetColumnTitle();
		int input = 1;
		Util.printInput(input);
		Util.printResult(ins.convertToTitle(input), "A");

		input = 26;
		Util.printInput(input);
		Util.printResult(ins.convertToTitle(input), "Z");

		input = 27;
		Util.printInput(input);
		Util.printResult(ins.convertToTitle(input), "AA");

	}
}
