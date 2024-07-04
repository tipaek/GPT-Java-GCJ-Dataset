import java.io.*;
import java.util.*;


 class Solution {

    
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        int x=1;
        while(t-->0)
        {
            
            
            bw.write("Case #"+x+": ");
            int n = Integer.parseInt(br.readLine());
            int[] c = new int[24*60+1];
            int[] j = new int[24*60+1];
            StringBuilder str = new StringBuilder("");
            boolean flag2 = true;
            for(int k=0;k<n;k++)
            {
                String[] inp = br.readLine().split(" ");
                int start = Integer.parseInt(inp[0]);
                int end = Integer.parseInt(inp[1]);
                boolean flag = true;
                for(int i=start;i<end;i++)
                {
                    if(c[i]!=0)
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
                        c[i] = 1;
                    }
                }
                else
                {
                    flag = true;
                    for(int i=start;i<end;i++)
                    {
                        if(j[i]!=0)
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
                        j[i] = 1;
                    }
                    }
                    else
                        flag2 = false;
                }
                
            }
            if(flag2)
                bw.write(str.toString()+"\n");
            else
                bw.write("IMPOSSIBLE\n");
            x++;
        }
        bw.flush();
    }
}
