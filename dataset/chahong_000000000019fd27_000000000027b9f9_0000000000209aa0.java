import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		String result=null;
		for(int i=0; i<n;i++){
			int num = sc.nextInt();
			int crossSum = sc.nextInt();
			if((crossSum == (num+1))||(crossSum == (Math.pow(num,2)-1))){
			    result = "IMPOSSIBLE";
			}
			else {
				result = "POSSIBLE";
			}
		    System.out.println("Case #" + (i+1) + ": " +(result));
		    
		}
		
		

	}
	
		

}
