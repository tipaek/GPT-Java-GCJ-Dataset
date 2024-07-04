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
            String s=br.readLine();
            int len=s.length();
            int arr[]=new int[len];
            for(int i=0;i<len;i++)
            {
                arr[i]=s.charAt(i)-'0';
                //System.out.println(arr[i]);
            }
            int open=0;
            int closed=0;
            String ans="";
            for(int i=len-1;i>=0;i--)
            {
                String temp="";
                if(i==len-1)
                {
                    temp=temp+String.valueOf(arr[len-1]);
                    //System.out.println(temp);
                    for(int j=0;j<arr[len-1];j++)
                    {
                        temp=temp+")";   
                        closed++;
                    }
                    ans=temp+ans;
                }
                else
                {
                    int x=arr[i];
                    temp=temp+String.valueOf(x);
                    //System.out.println(temp);
                    if(x>closed)
                    {
                        int diff=x-closed;
                        for(int j=0;j<diff;j++)
                        {
                            temp=temp+")";   
                            closed++;
                        }
                    }
                    else if(x<closed)
                    {
                        int diff=closed-x;
                        for(int j=0;j<diff;j++)
                        {
                            temp=temp+"(";   
                            closed--;
                        }
                    }
                    ans=temp+ans;
                }
            }
            for(int i=1;i<=closed;i++)
            {
                ans="("+ans;
            }
            System.out.println("Case #" +aa+ ": " +ans);
            aa++;
        }
    }
}