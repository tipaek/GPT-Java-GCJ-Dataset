/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());*/
// 		StringTokenizer st=new StringTokenizer(br.readLine());
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t=1;t<=T;t++){
		    int Y=sc.nextInt();
		    int X=sc.nextInt();
		    String M=sc.next();
		    int length=M.length();
		    String y="IMPOSSIBLE";
		    for(int i=0;i<length;i++){
		        if(Math.abs(X)+Math.abs(Y)<=i){
		            y=String.valueOf(i);
		            break;
		        }
		        switch(M.charAt(i)){
		                case 'N':
		                    X++;
		                    break;
		                case 'S':
		                    X--;
		                    break;
		                case 'E':
		                    Y++;
		                    break;
		                case 'W':
		                    Y--;
		                    break;
		        }
		    }
		        if(y.equals("IMPOSSIBLE")&&Math.abs(X)+Math.abs(Y)<=length){
		            y=String.valueOf(length);
		        }
		    System.out.println("Case #"+t+": "+y);
		}
	}
}
