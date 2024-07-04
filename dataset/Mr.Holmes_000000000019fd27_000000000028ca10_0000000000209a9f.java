import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int testCases = scanner.nextInt();
		
		if(100 < testCases || testCases <1)
			extracted();
	
		String output[] = new String[testCases] ;
		
		for (int t = 0; t < testCases; t++) {
			
			String s = scanner.next();
			
			if(s.length()>100)
				extracted();
			
			String[] l= s.split("");

			int[] it = new int[l.length];
			int j=0;
			for(String ch: l)
			{
				it[j++]=Integer.parseInt(ch);
			}
			
			String result ="";
		
			result=nest(it[0],it[0]);
			int closeB=it[0]+1;
			for(int i =1;i<it.length;i++) {
				String[] intermed = getNested(result,closeB,it[i]);
				result= intermed[0];
				closeB = Integer.parseInt(intermed[1]);
			}
			
			output[t]=result;
			
		}
		
		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i) + ": " + output[i]);
		}
		
	}

	public static String[] getNested( String nested ,int closeB , int nextN) {
		String pre, post;
		
		
		pre= nested.substring(0,closeB);
		post=nested.substring(closeB);
		
		int prevN = Integer.parseInt(nested.substring(closeB-1,closeB));
		
		int diff = nextN-prevN;

		if(nextN>prevN)
		{
			pre+= nest(nextN,diff);
			post=nested.substring(closeB);
			closeB+=(diff+1);
		}
		else if(diff == 0)
		{
			post=nested.substring(closeB);
			pre= pre + nextN;
			closeB+=1;
		}
		else
		{
			diff*=-1;
			closeB+=diff;
			pre= nested.substring(0,closeB) + nextN;
			post=nested.substring(closeB);
			closeB+=1;
		}
		
		String[] result = {pre+post,""+closeB};
		
		return result;
	}
	
	public static String nest(int num, int nests) {
		String result ="";
		
		for(int i =0;i<nests;i++)
		{
			result+="(";
		}
		result+=num;
		for(int i =0;i<nests;i++)
		{
			result+=")";
		}
		
		return result;
	}
	
	private static void extracted() throws Exception {
		throw new Exception();
	}
	
}
