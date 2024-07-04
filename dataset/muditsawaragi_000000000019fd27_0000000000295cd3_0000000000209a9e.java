import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    int t;
    int b;
    int a[];
    void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t=Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++)
        {
            b = Integer.parseInt(st.nextToken());
            a = new int[b];
            System.out.println("1");
            int t=Integer.parseInt(br.readLine());
            for(int j=1;j<=b;j++)
            {
                System.out.println(j);
                a[j-1]=Integer.parseInt(br.readLine());
            }
            display();
            br.read();
        }
    }

    void display()
    {
        for(int i=1;i<=b;i++)
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
