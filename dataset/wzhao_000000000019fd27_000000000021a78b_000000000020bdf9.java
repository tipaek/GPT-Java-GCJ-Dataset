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
            int[] J = new int[1441];

            boolean printed = false;
            StringBuilder s = new StringBuilder();
            for(int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(printed) continue;
                boolean c = false;
                for(int i = a; i<b; i++){
                    if(C[i] != 0){
                        c = true;
                        break;
                    }
                }
                if(!c){
                    Arrays.fill(C, a, b, 1);
                    s.append("C");
                }
                else{
                    boolean j = false;
                    for(int i = a; i<b; i++){
                        if(J[i] != 0){
                            j = true;
                            break;
                        }
                    }
                    if(!j){
                        Arrays.fill(J, a, b, 1);
                        s.append("J");
                    }
                    else{
                        output.println("Case #" + (t+1) + ": IMPOSSIBLE");
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