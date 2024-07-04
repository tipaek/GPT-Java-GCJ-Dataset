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
        int x = in.nextInt();
        int y = in.nextInt();
        
        if((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        
        List<String> possibilities = new ArrayList<>();
        
        dfs("E", possibilities, x, y, 1, 0, 1);
        dfs("N", possibilities, x, y, 0, 1, 1);
        dfs("W", possibilities, x, y, -1, 0, 1);
        dfs("S", possibilities, x, y, 0, -1, 1);
        
        if(possibilities.isEmpty()) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        
        possibilities.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(possibilities.get(0));
    }
    
    public static void dfs(String s, List<String> poss, int x, int y, 
            int next_x, int next_y, int i) {
        if((next_x == x && next_y == y)) {
            poss.add(s);
        } else if(Math.abs(next_x) > 1_000_000_000 || Math.abs(next_y) > 1_000_000_000) {
            return;
        } else {
            dfs(s + "E", poss, x, y, next_x + (int)Math.pow(2, i), next_y, i + 1);
            dfs(s + "W", poss, x, y, next_x - (int)Math.pow(2, i), next_y, i + 1);
            dfs(s + "N", poss, x, y, next_x, next_y + (int)Math.pow(2, i), i + 1);
            dfs(s + "S", poss, x, y, next_x, next_y - (int)Math.pow(2, i), i + 1);
        }
    }
}
