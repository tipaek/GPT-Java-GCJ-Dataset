import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	static boolean DEBUG=false;
	
	private static String getOpenPara(int numberOfpara) {
		
		String para="";
		
		for(int i=1;i<=numberOfpara;i++) 
			para=para+"(";
		
		return para;
	}
	
   private static String getClosedPara(int numberOfpara) {
		
		String para="";
		
		for(int i=1;i<=numberOfpara;i++) 
			para=para+")";
		
		return para;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/nestingdepth.in") : System.in;
		try(Scanner scanner=new Scanner( new BufferedReader(new InputStreamReader(is) ) )){
			int testCount = scanner.nextInt();
			 for (int testNumber = 1; testNumber <= testCount; testNumber++) {
	          
				String S=scanner.next();
				
				String result="";
					
				int prevInt=Character.getNumericValue(S.charAt(0));
				
				result=result+getOpenPara(prevInt)+prevInt;
				
				int openParanthesis=prevInt;
				
				for(int loop=1;loop<S.length();loop++) {
					
					int nextInt=Character.getNumericValue(S.charAt(loop));
					
					if(prevInt==nextInt)
						result=result+nextInt;
					else if(prevInt>nextInt){
						
						result=result+getClosedPara(prevInt-nextInt)+nextInt;
						
						openParanthesis=nextInt;
							
					}else if(prevInt<nextInt) {
						
						
						result=result+getOpenPara(nextInt-prevInt)+nextInt;
						
						openParanthesis=nextInt;
						
						
					}
					
					prevInt=nextInt;
						
				}
				
				result=result+getClosedPara(openParanthesis);

				System.out.println("Case #" + testNumber+" "+result);
			
	            }
			
	    }
		
	}

}
