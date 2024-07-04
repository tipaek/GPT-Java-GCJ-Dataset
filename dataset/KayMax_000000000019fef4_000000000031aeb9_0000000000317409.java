import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        
        for(int i = 1; i <= tc; i++) {
            System.out.printf("Case #%d: ", i);
            solve(in);
        }
    }
    
    public static void solve(Scanner in) {
        int X = in.nextInt(), Y = in.nextInt();
        String path = in.next();
        char[] p = path.toCharArray();
        List<Integer> dist = new ArrayList<>();
        dist.add(Math.abs(X) + Math.abs(Y));
        for(char c : p) {
            if(c == 'N')
                Y++;
            else if (c == 'S')
                Y--;
            else if (c == 'E')
                X++;
            else
                X--;
            dist.add(Math.abs(X) + Math.abs(Y));
        }
        int size = dist.size();
        for(int i = 0; i < size; i++) {
            if(dist.get(i) <= i) {
                System.out.println(i);
                return;
            }    
        }
        System.out.println("IMPOSSIBLE");
    }
}
