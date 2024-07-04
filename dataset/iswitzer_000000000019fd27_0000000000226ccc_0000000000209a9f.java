import java.util.*;
import java.io.*;

//NESTING DEPTH
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num_cases = Integer.parseInt(in.nextLine());
        ArrayList<String> outputs = new ArrayList<>();
        for(int n=0; n<num_cases; n++) {
            String num = in.nextLine();
            int current_depth = 0;
            String out = "";
            for(int i=0; i<num.length(); i++) {
                int c = Integer.parseInt(String.valueOf(num.charAt(i)));
                while(c > current_depth) {
                    out += "(";
                    current_depth += 1;
                }
                while(c < current_depth) {
                    out += ")";
                    current_depth -= 1;
                }
                out += c;
            }
            while(current_depth > 0) {
                out += ")";
                current_depth -= 1;
            }
            outputs.add("Case #" + (n+1) + ": " + out);
        }
        for(String s : outputs) {
            System.out.println(s);
        }
    }
}
