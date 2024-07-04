import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
int no=sc.nextInt();
   for( int i=1;i<=no;i++)
   {
   int size=sc.nextInt();
   int[] row=new int[size*size];
   int[] col=new int[size*size];
   int[][] arr=new int[size][size];
   int sum=0,rc=0,cc=0;
   String s,Co;
   int f=0;
   {
   for(int j=0;j<size;j++)
   {  s="";
   for(int k=0;k<size;k++)
   {
  int r=0;
     arr[j][k]=sc.nextInt();
   if(j==k)
   sum=sum+arr[j][k];
   
   if(s.contains(String.valueOf(arr[j][k])))
   f=1;
else
   s=s+String.valueOf(arr[j][k]);
    
   }
   }
   for(int i1 = 0; i1 < size; i1++){  
        int Col = 0; 
      Co="";
        for(int j1 = 0; j1 < size; j1++){  
          if(Co.contains(String.valueOf(arr[j1][i1])))
   Col=1;
else
    Co=Co+String.valueOf(arr[j1][i1]);
    }  
 if (Col==1)
     cc++;
     
   if(f==1)
   rc++;
   }
   System.out.println("Case"+" "+"#"+i+":"+" "+sum+" "+rc+" "+cc+" ");
   }
	}
}}
