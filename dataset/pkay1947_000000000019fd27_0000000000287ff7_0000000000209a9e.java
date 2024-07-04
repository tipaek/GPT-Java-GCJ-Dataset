import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        int B=in.nextInt();
        for (int t=1; t<=T; t++) {
            char[] cr=new char[B+1];
            for (int i=1; i<=B; i++) {
                System.out.println(i);
                cr[i]=(char)(in.nextInt() + '0');
            }
            String ans="";
            for (int i=1; i<=B; i++) ans+=cr[i];
            System.out.println(ans);
            String ver=in.next();
        }
    }
}