import java.io.*;
class Pair{
	String ans;
	int lastDigit;
}
public class Solution{
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1;i<=testCase;i++){
			String s = br.readLine();
			System.out.println(stringBalanced(s).ans);
		}
	}
	public static Pair stringBalanced(String s){
			Pair pair = new Pair();
			//Base Case
			if(s.length() == 1){
				int j = Integer.parseInt(s);
				for(int i = 0;i<j;i++)
					s = '('+s+')';
				
				pair.lastDigit = j;
				pair.ans = s ;
				return pair;
			}
			//Recursive Case
			pair = stringBalanced(s.substring(1));
			
			//Small Calculation
			String temp = pair.ans;
			int currentDigit = Integer.parseInt(String.valueOf(s.charAt(0)));
			if(currentDigit <=pair.lastDigit)
				temp = temp.substring(0,currentDigit)+currentDigit +temp.substring(currentDigit);
			else{
				String part = currentDigit+"";
				int diff = currentDigit - pair.lastDigit;
				for(int i = 0;i< diff;i++)
					part = '('+part+')';
				temp = temp.substring(0,pair.lastDigit)+ part + temp.substring(pair.lastDigit);
			}
			pair.ans = temp;
			pair.lastDigit = currentDigit;
			return pair;


	}
}