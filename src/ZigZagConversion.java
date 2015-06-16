import core.Util;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		if (s == null || s.length() <= 2) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		int step = (numRows - 1) * 2;
		for (int i = 0; i < numRows; i++) {
			int j = i;
			while (j < chars.length) {
				sb.append(chars[j]);

				int k = j + step - i * 2;
				if (i < numRows - 1 && k-j < step && k < chars.length) {
					sb.append(chars[k]);
				}
				j += step;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion ins = new ZigZagConversion();

		Input input = ins.new Input("ABCD", 3);
		String results = "ABDC";
		Util.printInput(input);
		Util.printResult(ins.convert(input.s, input.numRows), results);

		input = ins.new Input("ABCD", 2);
		results = "ACBD";
		Util.printInput(input);
		Util.printResult(ins.convert(input.s, input.numRows), results);

		input = ins.new Input("PAYPALISHIRING", 3);
		results = "PAHNAPLSIIGYIR";
		Util.printInput(input);
		Util.printResult(ins.convert(input.s, input.numRows), results);

	}

	class Input {
		String s;
		int numRows;

		public Input(String s, int numRows) {
			this.s = s;
			this.numRows = numRows;
		}

		@Override
		public String toString() {
			return String.format("s:%s,numRows:%s", this.s, this.numRows);
		}

	}
}
