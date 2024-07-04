/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();int c=1;
while(t-->0)
{
    int n=sc.nextInt();
    int time[][]=new int[n][3];
    for(int i=0;i<n;i++)
    {
        time[i][0]=sc.nextInt();time[i][1]=sc.nextInt();time[i][2]=i;}
      Arrays.sort(time, (a, b) -> a[0] - b[0]);
         StringBuilder ans=new StringBuilder();int free[]=new int[2];boolean flag=false;
         Arrays.fill(free,0);
         for(int i=0;i<n;i++)ans.append(" ");
         for(int i=0;i<n;i++)
         {
             if(free[0]<=time[i][0])
             {
                 ans.replace(time[i][2],time[i][2]+1,"C");
                 free[0]=time[i][1];
             }
             else if(free[1]<=time[i][0])
             {
                 ans.replace(time[i][2],time[i][2]+1,"J");
                 free[1]=time[i][1];
             }
             else {
                 flag=true;break;
             }
         }
         if(flag){
             ans=new StringBuilder();ans.append("IMPOSSIBLE");
         }
         System.out.println("Case #"+c+":"+" "+ans.toString());c++;
    
    
}
	}
}