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
         int[][] cArr=new int[1][2];
         cArr[0][0]=arr[0][0];
         cArr[0][1]=arr[0][1];
         
         int[][] jArr = new int[1][2];
         jArr[0][0]=-1;
         jArr[0][1]=-1;
         
         for(int j=1;j<n;j++)
         {
              boolean isCFree=false;
              if(arr[j][1]<=cArr[0][0] || arr[j][0]>=cArr[0][1])
                isCFree=true;
                
              boolean isJFree=false;
              if(arr[j][1]<=jArr[0][0] || arr[j][0]>=jArr[0][1])
                 isJFree=true;
           
			   /*String toAdd1="";
               toAdd1=toAdd1+tempAns.charAt(0);
               String toAdd2="";
               if(toAdd1.equals("C"))
               toAdd2="J";
               else
               toAdd2="C";*/
               
               if(isCFree)
               {
                   tempAns=tempAns+"C";
                   cArr[0][0]=arr[j][0];
                   cArr[0][1]=arr[j][1];
               }
               else if(isJFree)
               {
                   tempAns=tempAns+"J";
                   jArr[0][0]=arr[j][0];
                   jArr[0][1]=arr[j][1];
               }
               else{
                   tempAns="IMPOSSIBLE";
                   break;
               }
                 
         }
         ans[i]=tempAns;
		 //System.out.println("Hiii");
     }
     
     for(int i=0;i<t;i++)
     System.out.println("Case #"+(i+1)+": "+ans[i]);
    
    }
}