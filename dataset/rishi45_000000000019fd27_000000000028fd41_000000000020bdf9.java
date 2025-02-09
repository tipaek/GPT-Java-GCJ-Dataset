import java.util.*;
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            StringBuffer result=new StringBuffer("");
            int n=sc.nextInt();
            int arr[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            Arrays.sort(arr, new Comparator<int[]>() { 
                public int compare(final int[] entry1,  
                             final int[] entry2) { 
            if (entry1[0] > entry2[0]) 
                return 1; 
            else
                return -1; 
          } 
        });
            int cs=0,ce=0,js=0,je=0,flag=0;
            for(int i=0;i<n;i++)
            {
                flag=0;
                if(arr[i][0]>=ce)
                {
                    flag=1;
                    cs=arr[i][0];
                    ce=arr[i][1];
                    result.append('C');
                    
                }
                else if(arr[i][0]>=je&&flag==0)
                {
                    flag=1;
                    js=arr[i][0];
                    je=arr[i][1];
                    result.append('J');
                }
                if(flag==0)
                {
                    int len=result.length();
                    result.delete(0,len);
                    result.append("IMPOSSIBLE");
                    break;
                }
                
            }
            System.out.println("Case #"+t+": "+result);
            
            
        }
    }
}