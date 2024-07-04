import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		String[] result;
		String finalresult =null;
		for(int i=0; i<n;i++){
			
			int num = sc.nextInt();
			result = new String[num];
			for(int j=0;j<num;j++) {
				result[j] = sc.next();
				
			}
			Arrays.sort(result , new Comparator<String>(){
				@Override
				public int compare(String t1, String t2) {
					return t2.length()-t1.length();
				}
			});
			NEXT:
			for(int k=1;k<result.length;k++) {
				int num1=0;
				int num2=0;
				boolean ast1 = false;
				boolean ast2 = false;
				String s1=null ,s2=null;
				while(true) {
					char word1 = result[0].charAt(num1);
					char word2 = result[k].charAt(num2);
					if(ast1 && ast2) {
						s1= result[0].substring(num1);
						s2= result[k].substring(num2);
						if(s1.indexOf(s2)!=(s1.length()-s2.length())) {
							finalresult = "*";
							break NEXT;
						}
						else {
							break;
						}
					}
					if(word1 == '*' ) {
						num1++;
						ast1 = true;
					}
					if(word2 == '*') {
						num2++;
						ast2 = true;
					}
					
					
				}
				finalresult = s1;
			}
			
		    System.out.println("Case #" + (i+1) + ": " +(finalresult));
		    
		}
		
		

	}
	
		

}
