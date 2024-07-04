import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int T = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);

        for(int t=0;t<T;t++) {
            String res  = solve(br, B);
            System.out.println(res);
            br.readLine();
        }
    }

    public static String solve(BufferedReader br, int B) throws IOException{
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=B;i++) {
            System.out.println(i);
            sb.append(br.readLine());
        }
        return sb.toString();
    }
}