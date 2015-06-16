package core;

public class Util {
	public static void printResult(Object output, Object expect){
		if(output==null && expect==null){
			System.out.println(String.format("OK...%s",expect));;
		}
		else if(output!=null && output.equals(expect)){
			System.out.println(String.format("OK...%s",expect));;
		}
		else{ 
			System.out.println(String.format("output:  %s",output));
			System.out.println(String.format("expect:  %s",expect)); 
		}
		System.out.println();
	}
	
	public static void printInput(Object input ){
		System.out.println(String.format("input:  %s",input));
	}
	
	public static void main(String[] args){ 
		
	}
}
