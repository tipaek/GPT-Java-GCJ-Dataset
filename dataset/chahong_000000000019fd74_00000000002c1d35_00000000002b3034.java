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
			for(int k=1;k<result.length;k++) {
			
				String s1=result[0].substring(1);
				String s2=result[k].substring(1);
				if(s1.indexOf(s2)==(s1.length()-s2.length())) {
					finalresult = s1;
					continue;
				}
				else {
					finalresult = "*";
					break;
				}
			}
			
		    System.out.println("Case #" + (i+1) + ": " +(finalresult));
		    
		}

	}
	
		

}
