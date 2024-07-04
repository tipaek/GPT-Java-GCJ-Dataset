import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		int t=kb.nextInt();
		for(int i=1;i<=t;i++)
		{
		    int n=kb.nextInt();
		    int[] arr=new int[n*2];
		    for(int j=0;j<n*2;j++)
		    {
		        arr[j]=kb.nextInt();
		    }
		    String s1="";
		    String s2="";
		    String result="";
		    if(arr[0]==0 && arr[1]==1440 && n>2)
		    {
		        System.out.println("Case #"+i+": "+"IMPOSSIBLE");
		        continue;
		    }
		    if(arr[0]%2==0)
		    {  s1="C";
		       s2="J";
		       result="C";
		    }
		    else
		    {
		        s1="J";
		        s2="C";
		        result="J";
		    }
		    for(int k=2;k<n*2;k=k+2)
		    {
		        if((arr[k]<arr[k-1] && arr[k]>arr[k-2])||(arr[k+1]>arr[k-2] && arr[k+1]<arr[k-2]))
		        {
		            result=result+s2;
		        }
		        else if((arr[k]<arr[k-1] && arr[k]<arr[k-2])||(arr[k+1]<arr[k-2] && arr[k+1]>arr[k-2]))
		        {
		            if((result.charAt(result.length()-1))=='J')
		            {
		            result=result+s2;
		            }
		            else
		            {
		                result=result+s1;
		            }
		        }
		        else if(arr[k]==arr[k-1])
		        {
		            result=result+result.charAt(result.length()-1);
		        }
		        else
		        {
		            result=result+s1;
		        }
		     }
		    System.out.println("Case #"+i+": "+result);
		}
	}
}