import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt(); 
        for (int i = 0; i < max; i++) {
            String s = sc.next();
            System.out.println("Case #" + (i + 1) + ": " + parent(s)); 
        } 
    }

    public static String parent(String s) {
        Stack<String> stax = new Stack<>();
        String temp = "";
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            int comp = Integer.parseInt(s.substring(i, i + 1));
            if (depth > comp) {
                while (depth != comp) {
                    stax.push(")");
                    depth--;
                } 
            }
            if (depth < comp) {
                while (depth != comp) {
                    stax.push("(");
                    depth++;
                } 
            }
            stax.push(s.substring(i, i + 1));
        }
        while (depth > 0) {
            stax.push(")");
            depth--;
        }
        while (!stax.empty()) {
            temp = stax.pop() + temp;
        }
        return temp;
    }

}
