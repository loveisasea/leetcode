import core.Util;


public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) { 
		if(s.length()<=1){
			return s.length();
		}
		char[] chars = s.toCharArray();
        boolean[] cach = new boolean[256]; 
        int maxlen = 1;
        int srt =0,end = 1; 
        cach[chars[0]]=true;
        while(end<s.length()){  
        	if(cach[chars[end]]){
        		if(end-srt>maxlen){
        			maxlen = end- srt;
        		}     
        		while(chars[srt] != chars[end]){ 
        			cach[chars[srt]] = false;
    				srt++; 
        		} 
        		srt++;
				end++;
				if(s.length()-srt <= maxlen){
        			return maxlen;
        		}
        	}else{
        		cach[chars[end]]=true;
        		end++; 
        	}
        } 
		if(end-srt>maxlen){
			maxlen = end- srt;
		} 
        return maxlen; 
    }
	
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters ins = new LongestSubstringWithoutRepeatingCharacters();
		String input = null; 
	
		input = "aab";
		Util.printInput(input);
		Util.printResult(ins.lengthOfLongestSubstring(input), 2);
		
		input = "ababbcadasfsfjklophkbca";
		Util.printInput(input);
		Util.printResult(ins.lengthOfLongestSubstring(input), 8);
		
		input = "abc";
		Util.printInput(input);
		Util.printResult(ins.lengthOfLongestSubstring(input), 3);
		
		input = "0";
		Util.printInput(input);
		Util.printResult(ins.lengthOfLongestSubstring(input), 1);
		
		input = "a";
		Util.printInput(input);
		Util.printResult(ins.lengthOfLongestSubstring(input), 1);
		
	}
}
