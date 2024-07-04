/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;import java.util.*;
public class Solution {
    public static int[][] latin(int n,int k)
    {
     if(n==2 && k==2){int ans[][]={{1,2},{2,1}};return ans;}
     if(n==2 && k==4){int ans[][]={{2,1},{1,2}};return ans;}
     if(n==3 && k==3){int ans[][]={{1,2,3},{3,1,2},{2,3,1}};return ans;}
     if(n==3 && k==6){int ans[][]={{2,3,1},{1,2,3},{3,1,2}};return ans;}
     if(n==3 && k==9){int ans[][]={{3,1,2},{2,3,1},{1,2,3}};return ans;}
     if(n==4 && k==4){int ans[][]={
         {1,2,3,4},
         {4,1,2,3},
         {3,4,1,2},
         {2,3,4,1}};return ans;}
     if(n==4 && k==6){int ans[][]={
         {1,2,3,4},
         {2,1,4,3},
         {3,4,2,1},
         {4,3,1,2}};return ans;}
     if(n==4 && k==7){int ans[][]={
         {1,3,4,2},
         {2,1,3,4},
         {3,4,2,1},
         {4,2,1,3}};return ans;}
     if(n==4 && k==8){int ans[][]={
         {2,1,4,3},
         {4,2,3,1},
         {1,3,2,4},
         {3,4,1,2}};return ans;}
     if(n==4 && k==9){int ans[][]={
         {1,3,4,2},
         {4,1,2,3},
         {2,4,3,1},
         {3,2,1,4}};return ans;}
     if(n==4 && k==10){int ans[][]={
         {2,4,3,1},
         {4,3,1,2},
         {3,1,2,4},
         {1,2,4,3}};return ans;}
     if(n==4 && k==11){int ans[][]={
         {2,3,4,1},
         {4,2,1,3},
         {1,4,3,2},
         {3,1,2,4}};return ans;}
     if(n==4 && k==12){int ans[][]={
         {3,1,2,4},
         {4,3,1,2},
         {2,4,3,1},
         {1,2,4,3}};return ans;}
     if(n==4 && k==13){int ans[][]={
         {4,2,3,1},
         {3,4,1,2},
         {1,3,2,4},
         {2,1,4,3}};return ans;}
     if(n==4 && k==14){int ans[][]={
         {4,2,3,1},
         {2,3,1,4},
         {3,1,4,2},
         {1,4,2,3}};return ans;}
     if(n==4 && k==16){int ans[][]={
         {4,3,2,1},
         {1,4,3,2},
         {2,1,4,3},
         {3,2,1,4}};return ans;}
     if(n==5 && k==5){int ans[][]={
         {1,2,3,4,5},
         {5,1,2,3,4},
         {4,5,1,2,3},
         {3,4,5,1,2},
         {2,3,4,5,1}};return ans;}
     if(n==5 && k==7){int ans[][]={
         {2,5,3,4,1},
         {4,1,5,2,3},
         {5,2,1,3,4},
         {3,4,2,1,5},
         {1,3,4,5,2}};return ans;}
     if(n==5 && k==8){int ans[][]={
         {1,2,4,3,5},
         {3,1,2,5,4},
         {5,3,1,4,2},
         {4,5,3,2,1},
         {2,4,5,1,3}};return ans;}
     if(n==5 && k==9){int ans[][]={
         {1,2,3,4,5},
         {4,1,2,5,3},
         {5,4,1,3,2},
         {3,5,4,2,1},
         {2,3,5,1,4}};return ans;}
     if(n==5 && k==10){int ans[][]={
         {2,1,3,4,5},
         {5,2,1,3,4},
         {4,5,2,1,3},
         {3,4,5,2,1},
         {1,3,4,5,2}};return ans;}
     if(n==5 && k==11){int ans[][]={
         {1,3,2,5,4},
         {5,1,3,4,2},
         {4,5,1,2,3},
         {2,4,5,3,1},
         {3,2,4,1,5}};return ans;}
     if(n==5 && k==12){int ans[][]={
         {1,4,2,5,3},
         {5,1,4,3,2},
         {3,5,1,2,4},
         {2,3,5,4,1},
         {4,2,3,1,5}};return ans;}
     if(n==5 && k==13){int ans[][]={
         {2,3,1,4,5},
         {4,2,3,5,1},
         {5,4,2,1,3},
         {1,5,4,3,2},
         {3,1,5,2,4}};return ans;}
     if(n==5 && k==14){int ans[][]={
         {2,3,1,5,4},
         {5,2,3,4,1},
         {4,5,2,1,3},
         {1,4,5,3,2},
         {3,1,4,2,5}};return ans;}
     if(n==5 && k==15){int ans[][]={
         {3,1,2,4,5},
         {5,3,1,2,4},
         {4,5,3,1,2},
         {2,4,5,3,1},
         {1,2,4,5,3}};return ans;}
     if(n==5 && k==16){int ans[][]={
         {3,5,1,2,4},
         {2,3,5,4,1},
         {4,2,3,1,5},
         {1,4,2,5,3},
         {5,1,4,3,2}};return ans;}
     if(n==5 && k==17){int ans[][]={
         {4,3,1,2,5},
         {2,4,3,5,1},
         {5,2,4,1,3},
         {1,5,2,3,4},
         {3,1,5,4,2}};return ans;}
     if(n==5 && k==18){int ans[][]={
         {3,4,1,5,2},
         {5,3,4,2,1},
         {2,5,3,1,4},
         {1,2,5,4,3},
         {4,1,2,3,5}};return ans;}
     if(n==5 && k==19){int ans[][]={
         {4,5,3,2,1},
         {2,4,5,1,3},
         {1,2,4,3,5},
         {3,1,2,5,4},
         {5,3,1,4,2}};return ans;}
     if(n==5 && k==20){int ans[][]={
         {4,3,2,1,5},
         {5,4,3,2,1},
         {1,5,4,3,2},
         {2,1,5,4,3},
         {3,2,1,5,4}};return ans;}
     if(n==5 && k==21){int ans[][]={
         {5,4,1,2,3},
         {2,5,4,3,1},
         {3,2,5,1,4},
         {1,3,2,4,5},
         {4,1,3,5,2}};return ans;}
     if(n==5 && k==22){int ans[][]={
         {5,4,2,3,1},
         {3,5,4,1,2},
         {1,3,5,2,4},
         {2,1,3,4,5},
         {4,2,1,5,3}};return ans;}
     if(n==5 && k==23){int ans[][]={
         {5,2,4,1,3},
         {4,5,1,3,2},
         {3,4,5,2,1},
         {1,3,2,4,5},
         {2,1,3,5,4}};return ans;}
     if(n==5 && k==25){int ans[][]={
         {5,4,2,1,3},
         {3,5,4,2,1},
         {1,3,5,4,2},
         {2,1,3,5,4},
         {4,2,1,3,5}};return ans;}
     int comb[]=new int[n];
     int ans[][]=new int[n][n];
     int length=n;
     if(n%k==0)
     {
         for(int i=0;i<n;i++)
             comb[i]=k/n;
     }
     
     else
     {
         int pos=n;
         while(k<=(n-1)*pos)
             n--;
         comb[0]=comb[1]=n;
         pos=pos-2;
         k=k-(2*n);
         n--;
         while(pos!=0)
         {
             if(n*pos==k)
             {
                 for(int i=length-pos;i<length;i++)
                 {
                     comb[i]=n;
                 }
                 break;
             }
             else if(pos*n<k)
             {
                 comb[length-pos]=n+1;
                 k=k-(n+1);
                 pos--;
             }
             else
             {
                n--; 
             }
         }
         if(comb[length-1]!=comb[length-2])
         {
             boolean same=true;
             for(int i=0;i<=length-3;i++)
             {
                 if(comb[i]!=comb[i+1])
                 {
                     same=false;
                     break;
                 }
             }
             if(same==true)
             {
                 comb[length-3]--;
                 comb[length-2]++;
                 
             }
         }
     }
     n=length;
     for(int i=0;i<n;i++)
     {
         ans[i][i]=comb[i];
     }
     return ans;
    }
    public static void main(String[] args) throws IOException {
     PrintWriter out=new PrintWriter(System.out);
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer str;
      //..........
       int t=Integer.parseInt(br.readLine());
       for(int tc=1;tc<=t;tc++)
       {
           str=new StringTokenizer(br.readLine());
           int n=Integer.parseInt(str.nextToken());
           int k=Integer.parseInt(str.nextToken());
           boolean flag;
           if(n==2)
           {
               if(k==2 || k==4)
                   flag=true;
                else
                   flag=false;
                   
           }
           else if(n==3)
           {
               if(k==3 || k==6 || k==9)
                   flag=true;
               else
                   flag=false;
           }
           else
           {
               if(k==n+1 || k==(n*n-1))
                   flag=false;
               else
                   flag=true;
           }
           if(flag==false)
                System.out.println("Case #"+tc+": "+"IMPOSSIBLE");
           else
           {
               System.out.println("Case #"+tc+": "+"POSSIBLE"); 
               int ans[][]=new int[n][n];
               //latin(n,k);
               ans=latin(n,k);
               for(int i=0;i<n;i++)
               {
                   for(int j=0;j<n;j++)
                   {
                       System.out.print(ans[i][j]+" ");
                   }
                   System.out.println("");
               }
           }
       }
     //...........
      out.flush();
      out.close();
      
    } 
}
 /*String s=br.readLine();
String s[]; s=br.readLine.split(" ");
int n=Integer.parseInt(br.readLine());
str=new StringTokenizer(br.readLine());
int n=Integer.parseInt(str.nextToken());
long n=Long.parseLong(str.nextToken());
int a[]=new int[n];
for(int i=0;i<n;i++)
{
    a[i]=Integer.parseInt(str.nextToken());
}
long a[]=new long[n];
for(int i=0;i<n;i++)
{
    a[i]=Long.parseLong(str.nextToken());
}
*/
