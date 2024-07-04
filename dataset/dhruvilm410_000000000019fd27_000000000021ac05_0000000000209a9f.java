package codejam;
import java.io.*;import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
     PrintWriter out=new PrintWriter(System.out);
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer str;
      //..........
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            
        String s=br.readLine();
        char ca[]=s.toCharArray();
        ArrayList<Character> cl=new ArrayList<>();
        for(int j=1;j<=ca[0]-48;j++)
        {
            cl.add('(');
            
        }
        cl.add(ca[0]);
        for(int k=1;k<=ca.length-1;k++)
        {
            int diff=ca[k]-ca[k-1];
            if(diff>0)
            {
                for(int j=1;j<=diff;j++)
                {
                    cl.add('(');
                }
            }
            else if(diff<0)
            {
                for(int j=1;j<=-diff;j++)
                {
                    cl.add(')');
                }
            }
            cl.add(ca[k]);
            
        }
        for(int j=1;j<=ca[ca.length-1]-48;j++)
        {
            cl.add(')');
        }
        StringBuffer sn=new StringBuffer();
        for(char c:cl)
        {
            sn.append(c);
        }
        System.out.println("#"+i+": "+sn);
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
