import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int count = 0;
            String S = br.readLine();
            System.out.printf("Case #%d: ", t);
            for(int i = 0; i < S.length(); i++){
                int num = (int) (S.charAt(i) - '0');
                while(num > count) { count++; System.out.print('('); }
                while(num < count) { count--; System.out.print(')'); }
                System.out.print(num);
                
            }
            while(count > 0) { count--; System.out.print(')'); }
            System.out.println();
        }
    }
}