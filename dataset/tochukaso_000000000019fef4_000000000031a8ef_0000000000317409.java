import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution{
    
    public static String L = "(";
    public static String R = ")";
    public static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            char[] directions = sc.next().toCharArray();
            
            String ans = makeAns(x, y, directions);
            
            System.out.println(String.format("Case #%s: %s", i, ans));
        }

    }

    private static String makeAns(int x, int y, char[] directions) {
        
        for (int i = 0 ; i < directions.length; i++) {
            char c = directions[i];
            
            if(c == 'S') {
                y --;
            } else if(c == 'N') {
                y ++;
            } else if(c == 'W') {
                x --;
            } else {
                x ++;
            }
            
            if(Math.abs(x) + Math.abs(y) <= i + 1) {
                return String.valueOf(i + 1);
            }

        }
        
        return IMPOSSIBLE;
    } 
}
