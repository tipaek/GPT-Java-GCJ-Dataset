import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args)
    {
      
     Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
     int t = in.nextInt();
     String[] ans = new String[t];
     for(int i=0;i<t;i++)
     {
         int n = in.nextInt();
         int[][] arr= new int[n][2];
		 for(int j=0;j<n;j++)
		 {
			 for(int k=0;k<2;k++)
			  arr[j][k]=in.nextInt();
		 }
         
		 String tempAns="";
         
         tempAns=tempAns+"C";
         for(int j=1;j<n;j++)
         {
            
            //for(int k=0;k<j;k++)
           // {
			   String toAdd1="";
               toAdd1=toAdd1+tempAns.charAt(0);
               String toAdd2="";
               if(toAdd1.equals("C"))
               toAdd2="J";
               else
               toAdd2="C";
               
               if(arr[j][1]<=arr[0][0]  || arr[j][0]>=arr[0][1])
                 tempAns=tempAns+toAdd1;
                else
                 tempAns=tempAns+toAdd2;
                 
                 if(tempAns.length()==n)
                 break;
           // }
            
         }
         ans[i]=tempAns;
		 //System.out.println("Hiii");
     }
     
     for(int i=0;i<t;i++)
     System.out.println("Case #"+(i+1)+": "+ans[i]);
    
    }
}