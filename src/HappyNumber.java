import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> exists = new HashSet<Integer>();
		exists.add(n);
		while(true){
			if(n==1){
				return true;
			}
			char[] charArray = String.valueOf(n).toCharArray();
			n=0;
			for(char c : charArray){
				int i = Integer.parseInt(String.valueOf(c));
				n += (i*i);
			}
			if(!exists.contains(n)){
				exists.add(n);
			}
			else{
				return false;
			}
		}
       
    }
}
