import java.util.*;
public class Solution {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for(int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    public static void solve() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String m = scanner.next();
        int minutes;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < m.length(); i++) {
            if(m.charAt(i) == 'N') {
                y++;
            }
            else if(m.charAt(i) == 'S') {
                y--;
            }
            else if(m.charAt(i) == 'E') {
                x++;
            }
            else {
                x--;
            }
            minutes = Math.abs(x) + Math.abs(y);
            if(minutes <= i+1) {
                smallest = i+1;
                break;
            }
        }
        if(smallest < Integer.MAX_VALUE) {
            System.out.println(smallest + "\n");
        }
        else {
            System.out.println("IMPOSSIBLE\n");
        }
    }
}
