import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve(int b) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<13;i++){
            String ans = getAns(b);
            map.put(ans, map.getOrDefault(ans, 0)+1);
        }
        int max = 0;
        String ret = "";
        for(String key : map.keySet()) {
            if(map.get(key)>max){
                max = map.get(key);
                ret = key;
            }
        }
        out.println(ret);
        String response = sc.next();
        if(response.equalsIgnoreCase("N")){
            System.exit(1);
        }
    }

    private String getAns(int b){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=b;i++) {
            out.println(i);
            sb.append(sc.nextInt());
        }
        return sb.toString();
    }

    private String flip(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c=='0'?'1':'0');
        }
        return sb.toString();
    }

    private String swap(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.insert(0, c);
        }
        return sb.toString();
    }

    private String flipswap(String s){
        return swap(flip(s));
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(b);
        }
        sc.close();
        out.close();
        System.exit(0);
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
