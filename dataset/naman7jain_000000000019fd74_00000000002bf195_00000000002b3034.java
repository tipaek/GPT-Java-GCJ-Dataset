/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		for(int x=0;x<t;x++)
		{
		    int n=s.nextInt();
		    String[] arr = new String[n];
		    int a=0,max_i=0,max=0;
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=s.next(); 
		        int len=arr[i].length();
		        if(len>max){
		            max=len;
		            max_i=i;
		        }
		        if(arr[i].charAt(0)=='*')
		        {}
		        else
		            a=1;
		    }
		    if(a==0){
		        int flag=0;
		        for(int i=0;i<n;i++)
		        {
		            int k=arr[max_i].length()-1;
		            for(int j=arr[i].length()-1;j>0;j--,k--)
		            {
		                if(arr[i].charAt(j)!=arr[max_i].charAt(k)){
		                    flag=1;
		                    break;
		                }
		            }
		            if(flag==1)
		                break;
		        }
		        if(flag==0){
		            System.out.print("Case #"+(x+1)+": ILIKE");
		            for(int i=1;i<arr[max_i].length();i++)
		                System.out.print(arr[max_i].charAt(i));
		            System.out.println();
		        }
		        if(flag==1)
		            System.out.println("Case #"+(x+1)+": *");
		    }
		}
	}
}
