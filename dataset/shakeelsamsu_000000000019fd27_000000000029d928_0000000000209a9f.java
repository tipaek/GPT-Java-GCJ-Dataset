import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int t = Integer.parseInt(in.readLine());
        for(int tt = 1; tt <= t; tt++) {
            ArrayList<String> list = new ArrayList<String>();
            String line = in.readLine();
            String s = line.substring(0, 1);
            list.add(s);
            for(int i = 1; i < line.length(); i++) {
                if(line.charAt(i - 1) != line.charAt(i)) {
                    list.add(line.substring(i, i + 1));
                }
                else {
                    list.set(list.size() - 1, list.get(list.size() - 1) + line.substring(i, i + 1));
                }
            }
            String res = "";
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).contains("1")) {
                    res += "(" + list.get(i) + ")";
                }
                else res += list.get(i);
            }
            out.println("Case #" + tt + ": " + res);
        }        
        out.close();
    }
}