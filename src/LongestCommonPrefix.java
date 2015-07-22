/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		else if (strs.length == 1) {
			return strs[0];
		}
		int len = Integer.MAX_VALUE;
		for (String str : strs) {
			if (str.length() < len) {
				len = str.length();
			}
		}
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < len; i++) {  
			char ch = strs[0].charAt(i); 
			for(int j=1;j<strs.length;j++){ 
				if(ch!=strs[j].charAt(i)){ 
					return sb.toString();
				}
			} 
			sb.append(strs[0].charAt(i));
		} 
		return sb.toString();
	}
	
	
//	public String longestCommonPrefix(String[] strs) {
//		if (strs == null || strs.length == 0) {
//			return "";
//		}
//		else if (strs.length == 1) {
//			return strs[0];
//		}
//		int len = Integer.MAX_VALUE;
//		for (String str : strs) {
//			if (str.length() < len) {
//				len = str.length();
//			}
//		}
//		char[][] chars = new char[strs.length][len];
//		for(int i=0;i<strs.length;i++){
//			chars[i] = strs[i].toCharArray();
//		}
//		
//		StringBuilder sb = new StringBuilder(); 
//		for (int i = 0; i < len; i++) {  
//			char ch = chars[0][i]; 
//			for(int j=1;j<chars.length;j++){ 
//				if(ch!=chars[j][i]){ 
//					return sb.toString();
//				}
//			} 
//			sb.append(ch);
//		} 
//		return sb.toString();
//	}
	
}
