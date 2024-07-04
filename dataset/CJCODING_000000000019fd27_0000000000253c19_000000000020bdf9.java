/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
     PrintWriter out=new PrintWriter(System.out);
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer str;
      //..........
        int t=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++)
        {
            int n=Integer.parseInt(br.readLine());
            int m[][]=new int[n][4];
           
            for(int i=0;i<n;i++)
            {
                str=new StringTokenizer(br.readLine());
                m[i][0]=Integer.parseInt(str.nextToken());
                m[i][1]=Integer.parseInt(str.nextToken());
                m[i][2]=i;
            }
           Arrays.sort(m, new Comparator<int[]>() {
             
          public int compare(final int[] entry1,  
                             final int[] entry2) {
 
            if (entry1[0] > entry2[0])
                return 1;
            else
                return -1;
          }
             });
           int c=0,j=0;
           boolean flag=true;
           c=m[0][1];
           m[0][3]=1;
           for(int i=1;i<n;i++)
           {
              if(m[i][0]>=c)
              {
                  c=m[i][1];
                  m[i][3]=1;
              }
              else if(m[i][0]>=j)
              {
                  j=m[i][1];
                  m[i][3]=2;
              }
              else
              {
                  flag=false;
                  break;
              }
             
           }
           if(flag==false)
           {
               System.out.println("Case #"+tc+": "+"IMPOSSIBLE");
           }
           else
           {
                 Arrays.sort(m, new Comparator<int[]>() {
                            public int compare(final int[] entry1,final int[] entry2) {
                                    if (entry1[2] > entry2[2])
                                        return 1;
                                    else
                                        return -1;
                            }
                      });
                 StringBuffer s=new StringBuffer();
                 for(int i=0;i<n;i++)
                 {
                     if(m[i][3]==1)
                        s.append('C');
                     else
                        s.append('J');
                 }
                 System.out.println("Case #"+tc+": "+s);
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

