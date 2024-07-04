import java.io.*;
import java.util.*;

public class Solution {
    static String name = "p";
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        //BufferedReader in = new BufferedReader(new FileReader(name + ".in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(name + ".out")));

        StringTokenizer input;

        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String y = "";
            List<Integer> a = new ArrayList<>();
            int N = Integer.parseInt(in.readLine());
            String[] add = { "C", "J" };
            for(int i = 0; i < 1440; i++) { a.add(0); }
            while(N --> 0){
                input = new StringTokenizer(in.readLine());
                int S = Integer.parseInt(input.nextToken());
                int E = Integer.parseInt(input.nextToken());
                int k = 0;
                for(int i = S; i < E; i++){
                    a.set(i, a.get(i)+1);
                }
                y += add[N%2];
            }
            for(int q : a){
                if(q >= 3) {
                    y = "IMPOSSIBLE";
                    break;
                }   
            }
            out.println("Case #" + x + ": " + y);
            //out.println(Arrays.toString(a.toArray()));
        }
        out.close();
    }
}