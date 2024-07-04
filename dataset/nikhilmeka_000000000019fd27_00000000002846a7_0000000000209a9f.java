import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for(int i = 0; i < n; i++){
            String nums = s.nextLine();
            int current = 0;
            int next = 0;
            String ret = "";
            for(int j = 0; j < nums.length(); j++){
                next = nums.charAt(j)-'0';
                ret += brackets(current, next)+next;
                current = next;
            }
            ret+=brackets(current,0);
            System.out.println("Case #" + (i+1) + ": " + ret);
        }
        s.close();
    }
    public static String brackets(int current, int next){
        String x = ")";
        int n = Math.abs(next-current);
        if(next > current){
            x="(";
        }
        String ret = "";
        for(int i = 0; i < n; i++){
            ret+= x;
        }
        return ret;
    }
}