import java.io.*;
import java.util.*;


 class Solution {

    
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x=1;
        while(t-->0)
        {
            System.out.print("Case #"+x+": ");
            int n = sc.nextInt();
            boolean[] c = new boolean[1500];
            boolean[] j = new boolean[1500];
            for(int i=0;i<c.length;i++)
                c[i] = false;
            for(int i=0;i<j.length;i++)
                j[i] = false;
            StringBuilder str = new StringBuilder("");
            boolean flag2 = true;
            for(int k=0;k<n;k++)
            {
                
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean flag = true;
                for(int i=start;i<end;i++)
                {
                    if(c[i]==true)
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    str.append("C");
                    for(int i=start;i<end;i++)
                    {
                        c[i] = true;
                    }
                }
                else
                {
                    flag = true;
                    for(int i=start;i<end;i++)
                    {
                        if(j[i]==true)
                        {
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                    {
                    str.append("J");
                    for(int i=start;i<end;i++)
                    {
                        j[i] = true;
                    }
                    }
                    else
                        flag2 = false;
                }
                
            }
            if(flag2)
                System.out.println(str.toString());
            else
                System.out.println("IMPOSSIBLE");
            x++;
        }
        bw.flush();
    }
}
