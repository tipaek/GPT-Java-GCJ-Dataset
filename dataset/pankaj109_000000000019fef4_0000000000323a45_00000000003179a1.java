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
		    int U=sc.nextInt();
		    boolean[]arr=new boolean[26];
		    for(int i=0;i<10000;i++){
		        int Qi=sc.nextInt();
		        String Ri=sc.next();
		        int length=Ri.length();
		        for(int j=0;j<length;j++){
		            arr[Ri.charAt(j)-'A']=true;
		        }
		    }
		    char[]y=new char[10];
		    int j=0;
		    for(int i=0;i<26;i++){
		        if(arr[i]){
		            y[j]=(char)('A'+i);
		            j++;
		        }
		    }
		        for(int i=0;j<10&&i<26;i++){
		        if(!arr[i]){
		            y[j]=(char)('A'+i);
		            j++;
		        }
		    }
		    System.out.println("Case #"+t+": "+new String(y));
		}
	}
}
