import java.util.Scanner;

public class Solution
{  
    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);
        int t = read.nextInt();
        for (int it = 1; it <= t; it++) {
            int x = read.nextInt();
            int y = read.nextInt();
            String s = read.next();
            boolean pos = false;
            int min = s.length();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'E') {
                    x++;
                }
                if (s.charAt(i) == 'W') {
                    x--;
                }
                if (s.charAt(i) == 'N') {
                    y++;
                }
                if (s.charAt(i) == 'S') {
                    y--;
                }
                //System.out.println(it + " " + x + " " + y);
                if (Math.abs(x) + Math.abs(y) <= i + 1 && i < min) {
                    min = i + 1;
                    pos = true;
                }
            }
            if (pos) {
                System.out.println("Case #"+it+": " + min);
            } else {
                System.out.println("Case #"+it+": IMPOSSIBLE");
            }
            //System.out.println(min);
        }
    }
}