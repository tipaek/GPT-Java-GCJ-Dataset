import java.util.Scanner;


class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
	    int testCases = 0;
	    if(sc.hasNextInt()){
           testCases = sc.nextInt();
        }
	    int count = 1;
	   while(testCases!=0) {		  
		   String s = sc.next();
		   System.out.print("Case #"+count+":");
		   System.out.print(" "+ ParentheisedString(s));	
		   System.out.print("\n");
		   testCases --;
		   count++;
	   }
	}

	private static String ParentheisedString(String s) {
		// TODO Auto-generated method stub
		String answer = "";
		int[] strNum = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			strNum[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}		
		
		answer = answer + appendNew(strNum[0]);
		
		for (int i = 0; i < strNum.length; i++) {									
			int j = i + 1;					
			if(j<strNum.length) {	
				int diff=0;
				if(strNum[i] >= strNum[j] &&  diff <= strNum[i] - strNum[j]) {
					diff = strNum[i] - strNum[j];					
					answer = answer.substring(0,answer.length() - strNum[j])+ strNum[j] + answer.substring(answer.length() - strNum[j], answer.length()); 
				}
				else if(strNum[i] > strNum[j] &&  diff > strNum[i] - strNum[j]){
					diff = strNum[i] - strNum[j];
					answer = answer + appendNew(strNum[j]);
				}
				else
				{
					answer = answer + appendNew(strNum[j]);
				}
			}	
		}
		return answer;
	}
	
	private static String appendNew(int i) {

		String temp = "";
		for (int j2 = 0; j2 < i; j2++) {
			temp = temp + '(';
		}
		temp = temp + i;
		for (int j2 = 0; j2 < i; j2++) {
			temp = temp + ')';
		}
		return temp;

	}
}
