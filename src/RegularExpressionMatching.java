import core.Util;

/*
 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) { 
		char[] schars = s.toCharArray();
		char[] pchars = p.toCharArray();
		return this.recurIsMatch(schars, 0, pchars, 0);
	}

	private boolean recurIsMatch(char[] s, int si, char[] p, int pi) {
		int plen = p.length;
		int slen = s.length;
		while (pi < plen) {
			char pc = p[pi];
			if (pi + 1 < plen && p[pi + 1] == '*') {
				while (si < slen) { 
					if (this.recurIsMatch(s, si, p, pi + 2)) {
						return true;
					}
					if (pc=='.' || s[si] == pc) {
						si++;
					}
					else {
						break;
					}
				}
				pi = pi + 2;
				continue;
			}
			else {
				if (si == slen) {
					return false;
				}
				else {
					if (pc == '.' || s[si] == pc) {
						si++;
						pi++;
						continue;
					}
					else{
						return false;
					}
				}
			}
		}
		if (si == slen) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		RegularExpressionMatching ins = new RegularExpressionMatching();
		Input input = null;

		 input = ins.new Input("aa", "a");
		 Util.printInput(input);
		 Util.printResult(ins.isMatch(input.s, input.p), false);
		
		 input = ins.new Input("aa", "aa");
		 Util.printInput(input);
		 Util.printResult(ins.isMatch(input.s, input.p), true);
		
		 input = ins.new Input("aaa", "aa");
		 Util.printInput(input);
		 Util.printResult(ins.isMatch(input.s, input.p), false);
		
		 input = ins.new Input("aa", "a*");
		 Util.printInput(input);
		 Util.printResult(ins.isMatch(input.s, input.p), true);
		
		 input = ins.new Input("aa", ".*");
		 Util.printInput(input);
		 Util.printResult(ins.isMatch(input.s, input.p), true);
		
		 input = ins.new Input("ab", ".*");
		 Util.printInput(input);
		 Util.printResult(ins.isMatch(input.s, input.p), true);
		
		 input = ins.new Input("aab", "c*a*b");
		 Util.printInput(input);
		 Util.printResult(ins.isMatch(input.s, input.p), true);

		input = ins.new Input("ab", ".*c");
		Util.printInput(input);
		Util.printResult(ins.isMatch(input.s, input.p), false);

		input = ins.new Input("aaa", "ab*a*c*a");
		Util.printInput(input);
		Util.printResult(ins.isMatch(input.s, input.p), true);

	}

	class Input {
		String s;
		String p;

		public Input(String s, String p) {
			this.s = s;
			this.p = p;
		}

		@Override
		public String toString() {
			return String.format("s:%s, p:%s", this.s, this.p);
		}
	}

	// old method
	/*
	 * public boolean isMatch(String s, String p) { if (s.length() == 0 ^
	 * p.length() == 0) { return false; } if (s.length() == 0 && p.length() ==
	 * 0) { return true; }
	 * 
	 * int si = 0, pi = 0; char sc = s.charAt(0); char pc = p.charAt(0); char
	 * ppc = pc; boolean unmatch = false; while (true) { if ((sc == pc || pc ==
	 * '.') && !unmatch) { si++; pi++; if(pi>=p.length()){ return false; }
	 * 
	 * } else if (pc == '*') { if (ppc == sc || ppc == '.') { si++;
	 * if(si>=s.length()){ if(pi==p.length()-1){ return true; } else{
	 * 
	 * } } } else { pi++; } if (unmatch) { unmatch = false; } ppc = pc; sc =
	 * s.charAt(si); pc = p.charAt(pi); } else { if (unmatch) { return false; }
	 * pi++; unmatch = true; } } if (si >= s.length() && pi >= p.length()) {
	 * return true; } else if (si >= s.length()) { if (pc == '*' && pi ==
	 * p.length() - 1) { return true; } else { return false; } } else { if (pc
	 * == '*') { if (ppc == '.') { return true; } else { while (si < s.length())
	 * { if (s.charAt(si) != sc) { return false; } sc++; } return true; } } else
	 * { return false; } } }
	 */
}
