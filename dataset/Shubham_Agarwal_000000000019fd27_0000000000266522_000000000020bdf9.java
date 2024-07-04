import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,i,j,temp,Cam,Jam,flag=0,c=1;
        t=Integer.parseInt(br.readLine());
        while(c<=t)
        {
            n=Integer.parseInt(br.readLine());
            String str="";
           int start[]=new int[n];
           int end[]=new int[n];
           for(i=0;i<n;i++)
           {
               String s[]=br.readLine().split(" ");
               start[i]=Integer.parseInt(s[0]);
               end[i]=Integer.parseInt(s[1]);
           }
           for(i=0;i<n;i++)
           {
               for(j=0;j<n-i-1;j++)
               {
                   if(start[j]>start[j+1])
                   {
                       temp=start[j];
                       start[j]=start[j+1];
                       start[j+1]=temp;
                       temp=end[j];
                       end[j]=end[j+1];
                       end[j+1]=temp;
                   }
               }
           }
           Cam=-1;
           Jam=-1;
           flag=0;
           //for(i=0;i<n;i++)
          // System.out.println(start[i]+" "+end[i]);
           for(i=0;i<n;i++)
           {
              if(start[i]>=Cam)
              {
                  str=str+"C";
                  Cam=end[i];
              }
              else if(start[i]>=Jam)
              {
                  str=str+"J";
                  Jam=end[i];
              }
              else
              {
                  flag=1;
                  break;
              }
           }
           if(flag==0)
            System.out.println("Case #"+c+": "+str);
           else
           System.out.println("Case #"+c+": IMPOSSIBLE");
            c++;
        }
    }
}