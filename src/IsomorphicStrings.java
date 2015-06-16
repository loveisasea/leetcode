import java.util.HashMap;
import java.util.Map;

import core.Util;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		char[] schars = s.toCharArray();
		char[] tchars = t.toCharArray();
		int slen = schars.length;
		int tlen = tchars.length;
		if (slen != tlen) {
			return false;
		}
		Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapt = new HashMap<Integer, Integer>();
		for (int i = 0; i < slen; i++) {
			int sc = (int) schars[i];
			int tc = (int) tchars[i];
			Integer tcmap = maps.get(sc);
			Integer scmap = mapt.get(tc);
			if (scmap == null && tcmap == null) {
				maps.put(sc, tc);
				mapt.put(tc, sc);
			}
			else if (scmap != null && tcmap != null) {
				if (scmap == sc && tcmap == tc) {
					continue;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsomorphicStrings ins = new IsomorphicStrings();
		Input input = ins.new Input("aa", "bb");
		Util.printInput(input);
		Util.printResult(ins.isIsomorphic(input.s, input.t), true);

	}

	class Input {
		String s;
		String t;

		public Input(String s, String t) {
			this.s = s;
			this.t = t;
		}

		public String toString() {
			return String.format("s:%s,t:%s", s, t);
		}
	}
}
