import java.util.Scanner;
import java.lang.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		
		int T=sc1.nextInt();
		
	for(int p=1;p<=T;p++)
	   {
		String s;
		StringBuilder sb=new StringBuilder();
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
 		//System.out.println("Enter a string"); 
 		s = sc.nextLine();
 		char arr[]=s.toCharArray();
 		for(int i=0;i<arr.length;i++)
 		{
 			if(arr[i]=='1')
 			{
 				sb.append('(');
 				//while(arr[i]=='1' && i<arr.length-1)
 				{
 					sb.append('1');
 				//	i++;
 				}
 				sb.append(')');
 			}
 			else
 			{
 				sb.append('0');
 			}
 			
 		}
 		
 		int cnt=0;
 		StringBuilder sb2=new StringBuilder();
 		//System.out.println(sb.toString());
 		char brr[]=sb.toString().toCharArray();
 		
 		for(int i=0;i<brr.length-1;i++)
 		{
 			if(brr[i]==')' && brr[i+1]=='(')
 			{
 				cnt++;
 				i=i+1;
 			}
 			else
 			{
 				sb2.append(brr[i]);
 			}
 		}
 		
 		if(arr[arr.length-1]=='1')
 		{
 			sb2.append(')');
 		}
 		if(arr[arr.length-1]=='0')
 		{
 			sb2.append('0');
 		}
 		System.out.println("Case #"+p+":"+" "+sb2.toString());
	}
	}

}
