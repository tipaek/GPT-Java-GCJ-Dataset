import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    int t;
    int b;
    int a[]=new int[100];
    void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t=Integer.parseInt(st.nextToken());
        b =Integer.parseInt(st.nextToken());
       
        for(int i=0;i<t;i++)
        {
            int c=0;
            for(int j=1;j<=150;j++)
            {
                System.out.println(c+1);
                a[c]=Integer.parseInt(br.readLine());
                c=(c+1)%b;
            }
            display();
            br.readLine();
        }
    }

    void display()
    {
        for(int i=0;i<b;i++)
        {
            System.out.println(a[i]);
        }
        
    }
    public static void main()throws IOException
    {
        Solution ob = new Solution();
        ob.input();
    }
}
