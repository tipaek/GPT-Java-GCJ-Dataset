import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

    int t;
    int n;
    int arr[][]=new int[1000][3];
    char ch[]=new char[1000];
    String sa[]=new String[1000];
    void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        for(int c=1;c<=t;c++ )
        {
             display(c);
        }
        n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=i;
        }

    }
    void display(int c)
    {
        int p=0,q=0;
        
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
            System.out.println(arr[i][0]+" "+arr[i][1]);
            if(p<=arr[i][0])
            {
                p=arr[i][1];
                ch[arr[i][2]]='C';
                System.out.println("c");
            }
            else if(q<=arr[i][0])
            {
                q=arr[i][1];
                ch[arr[i][2]]='J';
                System.out.println("j");
            }
            else
            {
                f=1;
                System.out.println("done");
                break;
            }
        }
        if(f==1)
        {
            sa[c]="IMPOSSIBLE";
        }
        else
        {
            String sat="";
            for(int i=0;i<n;i++)
            {
                sat=sat+ch[i];
            }
            sa[c]=sat;
        }
       
    }
     void show()
        {
            for(int i=0;i<t;i++)
            {
                System.out.println("Case #"+c+": "+sa[i]);
                
            }
        }
    public static void main(String args[])throws IOException
    {
        Solution ob =new Solution();
        ob.input();
        ob.show();

    }
}
