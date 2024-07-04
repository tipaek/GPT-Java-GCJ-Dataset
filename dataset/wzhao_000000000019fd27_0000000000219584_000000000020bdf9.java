import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            int[] C = new int[1441];
            Arrays.fill(C, 0);
            int[] J = new int[1441];
            Arrays.fill(J, 0);
            boolean printed = false;
            StringBuilder s= new StringBuilder();
            for(int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(C[a] == 0){
                    Arrays.fill(C, a, b, 1);
                    s.append("C");
                }
                else{
                    if(J[a] == 0){
                        Arrays.fill(J, a, b, 1);
                        s.append("J");
                    }
                    else{
                        output.println("Case " + (t+1) + ": IMPOSSIBLE");
                        printed = true;
                        break;
                    }
                }
            }
            if(!printed) output.println("Case #" + (t+1) + ": " + s.toString());
        }
        output.flush();
        output.close();
    }
}