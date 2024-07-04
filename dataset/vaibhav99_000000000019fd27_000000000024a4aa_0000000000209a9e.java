import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int B=Integer.parseInt(br.readLine());
        int aa=1;
        while(aa<=T)
        {
            int arr[]=new int[B];
            String str=br.readLine();
            for(int i=0;i<B;i++)
            {
                arr[i]=str.charAt(i) - '0';
            }
            int query=0;
            int flag=0;
            Random r = new Random();
            while(flag==0)
            {
                query++;
                if(query%10 == 1)
                {
                    str=br.readLine();
                    for(int i=0;i<B;i++)
                    {
                        arr[i]=str.charAt(i) - '0';
                    }
                }
                System.out.println(r.nextInt((B - 1) + 1) + 1);
                int ans=Integer.parseInt(br.readLine());
                
                if(query==150)
                {
                    char ch=(char)br.read();
                    if(ch=='N')
                    {
                        flag=1;
                    }
                    else if(ch=='Y')
                    {
                        flag=2;
                        for(int i=0;i<B;i++)
                        {
                            System.out.print(arr[i]);
                        }
                        System.out.println();
                    }
                }
            }
            if(flag==1)
            {
                break;
            }
            aa++;
        }
    }
}