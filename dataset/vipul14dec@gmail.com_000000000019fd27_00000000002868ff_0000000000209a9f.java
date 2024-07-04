import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i< t;i++) {
            String str = sc.nextLine().trim();
            int b = 0;
            String s = "";
            for(char c: str.toCharArray()) {
                while(b!=Integer.parseInt(String.valueOf(c))) {
                    if(b<Integer.parseInt(String.valueOf(c))) {
                        s += "(";
                        b++;
                    }
                    else {
                        s += ")";
                        b--;
                    }
                }
                s += String.valueOf(c);
            }
            while(b!=0) {
                s += ")";
                b--;
            }
            System.out.println("Case #" + (i+1) + ": " + s);
        }
        sc.close();
    }
}