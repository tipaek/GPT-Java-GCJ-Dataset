import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    int t;
    void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        for(int c=1;c<=t;c++ )
        {
             display(c);
        }

    }
    void display(int c)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[][]=new int[n][3];
        int p=0,q=0;
        char ch[]=new char[n];
        for(int i=0;i<n;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=i;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j][0]>arr[j+1][0])
                {
                    int temp=arr[j][0];
                    arr[j][0]=arr[j+1][0];
                    arr[j+1][0]=temp;
                    temp=arr[j][1];
                    arr[j][1]=arr[j+1][1];
                    arr[j+1][1]=temp;
                    temp=arr[j][2];
                    arr[j][2]=arr[j+1][2];
                    arr[j+1][2]=temp;
                }
            }
        }
        int f=0;
        for(int i=0;i<n;i++)
        {
            
            if(p<=arr[i][0])
            {
                p=arr[i][1];
                ch[arr[i][2]]='C';
                
            }
            else if(q<=arr[i][0])
            {
                q=arr[i][1];
                ch[arr[i][2]]='J';
                
            }
            else
            {
                f=1;
                
                break;
            }
        }
        if(f==1)
        {
            System.out.println("Case #"+c+": "+"IMPOSSIBLE");
        }
        else
        {
            String sa="";
            for(int i=0;i<n;i++)
            {
                sa=sa+ch[i];
            }
            System.out.println("Case #"+c+": "+sa);
        }
    }
    public static void main(String args[])throws IOException
    {
        Solution ob =new Solution();
        ob.input();

    }
}
