import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		
		for(int tada=1; tada<=t;tada++)
		{
			
			list.clear();
			String data[]=br.readLine().split(" ");
			int n=Integer.valueOf(data[0]);
			int k=Integer.valueOf(data[1]);
			
			int arr[][]=new int[n][n];
			
			for(int i=1;i<=n;i++)
			{
				int shift=i-1;
				for(int j=1;j<=n;j++)
				{
					if(j+shift<=n)
					arr[i-1][j-1]=j+shift;
					else
						arr[i-1][j-1]=j+shift-n;
				}
			}
			
			
			
			
			String data2="";
			
			for(int i=1;i<=n;i++)
			{
				data2+=i;
			}
			getAllArrays(data2,0,n-1,arr,n);
			boolean isDone=false;
			for(Object sx:list)
			{
				int currentArr[][]=(int [][])sx;
				if(k==diagSum(currentArr, n))
				{
					System.out.println("Case #"+tada+": POSSIBLE");
					printArr(currentArr, n);
					isDone=true;
					break;
				}
			}
			if(!isDone)
			{
				System.out.println("Case #"+tada+": IMPOSSIBLE");
				
			}
			//System.out.println("Case #"+tada+": "+sum+" "+rowSum+" "+columnSum);
		
		}
	}
	
	public static void printArr(int arr[][],int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int diagSum(int currentArr[][],int n)
	{
		int sum=0;
		for(int i=0;i<n;i++)
			sum=sum+currentArr[i][i];
		
		return sum;
		
	}
	public static ArrayList<Object> list=new ArrayList<Object>();
	private static void getAllArrays(String str, int l, int r,int arr[][],int n) 
    { 
        if (l == r) 
        {
        	int count=0;
        	int newArr[][]=new int[n][n];
           for(char sd:str.toCharArray())
           {
        	   int data=sd-49;
        	   
        	   
        	     for(int j=0;j<n;j++)
        		   {
        	    	 newArr[count][j]=arr[data][j];
        		   }
        	     count++;
        	   
           }
           list.add(newArr);
           
        }
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = changeData(str,l,i); 
                getAllArrays(str, l+1, r, arr,n); 
                str = changeData(str,l,i); 
            } 
        } 
    } 
  
    public static String changeData(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 

}
