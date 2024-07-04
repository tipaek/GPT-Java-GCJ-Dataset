import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int aa=1;
        while(aa<=T)
        {
            int N=Integer.parseInt(br.readLine());
            int start[]=new int[N];
            int end[]=new int[N];
            int ind[]=new int[N];
            char arr[]=new char[N];
            for(int i=0;i<N;i++)
            {
                String s[]=br.readLine().split(" ");
                start[i]=Integer.parseInt(s[0]);
                end[i]=Integer.parseInt(s[1]);
                ind[i]=i;
            }
            int flag=1;
            for(int i=0;i<N-1 && flag==1;i++)
            {
                flag=0;
                for(int j=0;j<N-1-i;j++)
                {
                    if(start[j] >start[j+1])
                    {
                        int tmp=start[j];
                        start[j]=start[j+1];
                        start[j+1]=tmp;
                        
                        tmp=end[j];
                        end[j]=end[j+1];
                        end[j+1]=tmp;
                        
                        tmp=ind[j];
                        ind[j]=ind[j+1];
                        ind[j+1]=tmp;
                        
                        flag=1; 
                    }
                }
            }
            /*
            for(int i=0;i<N;i++)
            {
                System.out.println(start[i] + " " + end[i]);
            }
            */
            int c=0;
            int jj=0;
            arr[0]='C';
            c=end[0];
            flag=0;
            if(N>1)
            {
                if(start[1]>=end[0])
                {
                    arr[1]='C';
                    c=end[1];
                }
                else
                {
                    arr[1]='J';
                    jj=end[1];
                }
            }
            
            for(int i=2;i<N;i++)
            {
                if(start[i]>=c)
                {
                    arr[i]='C';
                    c=end[i];
                }
                else if(start[i]>=jj)
                {
                    arr[i]='J';
                    jj=end[i];
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                System.out.println("Case #" +aa+ ": IMPOSSIBLE" );
                aa++;
                continue;
            }
            flag=1;
            /*
            for(int i=0;i<N;i++)
            {
                System.out.println(start[i] + " " + end[i] + " " + arr[i]);
            }
            */
            for(int i=0;i<N-1 && flag==1;i++)
            {
                flag=0;
                for(int j=0;j<N-1-i;j++)
                {
                    if(ind[j] >ind[j+1])
                    {
                        
                        int tmp=ind[j];
                        ind[j]=ind[j+1];
                        ind[j+1]=tmp;
                        
                        char ch=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=ch;
                        
                        flag=1; 
                    }
                }
            }
            String aaa="";
            for(int i=0;i<N;i++)
            {
                aaa=aaa+arr[i];
            }
            System.out.println("Case #" +aa+ ": " +aaa );
            aa++;
        }
    }
}