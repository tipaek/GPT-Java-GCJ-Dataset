import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        int t=Integer.parseInt(f.readLine());
        for(int p=0;p<t;p++){
            StringTokenizer st=new StringTokenizer(f.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            char arr[]=st.nextToken().toCharArray();
            boolean works=false;
            out.print("Case #"+(p+1)+": ");
            for(int i=0;i<arr.length;i++){
                if(arr[i]=='N')y++;
                if(arr[i]=='S')y--;
                if(arr[i]=='W')x--;
                if(arr[i]=='E')x++;
                if(Math.abs(y)+Math.abs(x)<=i+1){
                    out.println((i+1));
                    works=true;
                    break;
                }

            }
            if(!works)out.println("IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}