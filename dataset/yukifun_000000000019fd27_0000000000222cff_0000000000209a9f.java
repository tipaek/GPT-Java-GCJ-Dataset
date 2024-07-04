import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        boolean DEBUG=false;
        String fileName = "a";
        InputStream is = DEBUG ? new FileInputStream("/Users/bambi/Desktop/contest/KickStart/input/" + fileName + ".txt") : System.in;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int caseCnt = scanner.nextInt();
        for (int i=0; i<caseCnt; i++){
            String s = scanner.next();
            String res= alg(s);
            System.out.println("Case #" + (i+1) + ": " + res);
        }
        is.close();
    }

    private static String alg(String s) {
        StringBuilder res=new StringBuilder();
        int stack=0;
        for (char c: s.toCharArray()){
            int cnt=c-'0';
            while (stack>cnt){
                res.append(")");
                stack--;
            }
            while (stack<cnt){
                res.append("(");
                stack++;
            }
            res.append(c);
        }
        while (stack>0) {
            res.append(")");
            stack--;
        }
        return res.toString();
    }

}