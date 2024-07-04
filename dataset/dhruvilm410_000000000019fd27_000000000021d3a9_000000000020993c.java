import java.io.*;import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
     PrintWriter out=new PrintWriter(System.out);
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer str;
      //..........
        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            int n=Integer.parseInt(br.readLine());
            int m[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                str=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++)
                {
                    m[i][j]=Integer.parseInt(str.nextToken());
                }
            }
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++)
            {
                k=k+m[i][i];
            }
            //boolean ans[]=new boolean[n+1];
            for(int i=0;i<n;i++)
            {
                //ans=new boolean[n+1];
                HashSet<Integer> set=new HashSet<>();
                int j;
                for(j=0;j<n;j++)
                {
                    /*if(ans[m[i][j]]==true)
                    {
                        r++;
                        break;
                    }
                    ans[m[i][j]]=true;*/
                    set.add(m[i][j]);
                }
                if(set.size()!=n)
                    r++;
            }
            for(int j=0;j<n;j++)
            {
                //ans=new boolean[n+1];
                HashSet<Integer> set=new HashSet<>();
                int i;
                for(i=0;i<n;i++)
                {
                    /*if(ans[m[i][j]]==true)
                    {
                        c++;
                        break;
                    }
                    ans[m[i][j]]=true;*/
                    set.add(m[i][j]);
                }
                if(set.size()!=n)
                    c++;
            }
        System.out.println("#"+t+": "+k+" "+r+" "+c);
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
