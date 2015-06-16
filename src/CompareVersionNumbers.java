import java.util.ArrayList;
import java.util.List;

import core.Util;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {

		String[] ver1 = this.split(version1, ".");
		String[] ver2 = this.split(version2, ".");
		for (int i = 0; i < ver1.length || i < ver2.length; i++) {
			int tmp1 = 0;
			int tmp2 = 0;
			if (i < ver1.length) {
				tmp1 = Integer.parseInt(ver1[i]);
			}
			if (i < ver2.length) {
				tmp2 = Integer.parseInt(ver2[i]);
			}
			if (tmp1 > tmp2) {
				return 1;
			} else if (tmp1 < tmp2) {
				return -1;
			}
		}
		return 0;
	}

	private String[] split(String str, String seperator) {
		if (str == null) {
			return null;
		}
		if (seperator == null) {
			seperator = "";
		}
		List<String> ret = new ArrayList<String>();
		int start = 0;
		while (true) {
			int index = str.indexOf(seperator, start);
			if (index < 0) {
				ret.add(str.substring(start));
				break;
			}
			else {
				String split = str.substring(start, index);
				ret.add(split);
				start = index + seperator.length();
			}
		}
		return (String[]) ret.toArray(new String[ret.size()]);
	}

	public static void main(String[] args) {
		CompareVersionNumbers ins = new CompareVersionNumbers();
		Input input = ins.new Input("0.1", "1.1");
		Util.printInput(input);
		Util.printResult(ins.compareVersion(input.v1, input.v2), -1);

		input = ins.new Input("1.1", "1");
		Util.printInput(input);
		Util.printResult(ins.compareVersion(input.v1, input.v2), 1);
		
		input = ins.new Input("1.0", "1");
		Util.printInput(input);
		Util.printResult(ins.compareVersion(input.v1, input.v2), 0);

		input = ins.new Input("1.2", "13.37");
		Util.printInput(input);
		Util.printResult(ins.compareVersion(input.v1, input.v2), -1);

	}

	class Input {
		String v1;
		String v2;

		public Input(String v1, String v2) {
			this.v1 = v1;
			this.v2 = v2;
		}

		@Override
		public String toString() {
			return String.format("version1: %s,  version2: %s", this.v1, this.v2);
		}
	}
}
