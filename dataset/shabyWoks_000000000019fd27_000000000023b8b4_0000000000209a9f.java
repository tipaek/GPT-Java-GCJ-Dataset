import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int t=0; t<T; t++) {
            ArrayList<String> stack = new ArrayList<>();
            String s    = "";
            String inp[]= br.readLine().trim().split("");
            int len     = inp.length;
            int[] arr   = new int[len];
            for(int i=0; i<len; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            
            for(int i=0; i<len; i++) {
                int num = arr[i];
                if(stack.size() > num) {
                    while(stack.size() > num) {
                        s += ")";
                        stack.remove(0);
                    }
                    s += num;
                } else if(stack.size() == num) {
                    s += num;
                } else {
                    while(stack.size() < num) {
                        s += "(";
                        stack.add(0, "(");
                    }
                    s += num;
                }
            }
            
            while(stack.size() != 0) {
                s += ")";
                stack.remove(0);
            }
            
            System.out.println("Case #"+(t+1) + ": " + s);
        }
    }
}