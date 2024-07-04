import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int casei = 1; casei <= t; ++casei) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.nextLine();
            boolean isAbleToTakePic = false;
            int smallestMinutesToTakePic = 0;

            for (int i = 1; i < m.length(); i++) {
                if (m.charAt(i) == 'N') {
                    y++;
                }else if (m.charAt(i) == 'S') {
                    y--;
                }else if (m.charAt(i) == 'E') {
                    x++;
                }else if (m.charAt(i) == 'W') {
                    x--;
                }
                smallestMinutesToTakePic++;
                int manh = Math.abs(x)+Math.abs(y);
                if (manh <= smallestMinutesToTakePic
                        ) {
                    isAbleToTakePic=true;
                    break;
                }
                //System.out.println("[] x:"+x+" y:"+y+" min:"+smallestMinutesToTakePic);
            }

            if (isAbleToTakePic) {
                System.out.println("Case #" + casei + ": " + smallestMinutesToTakePic);
            }else {
                System.out.println("Case #" + casei + ": IMPOSSIBLE");
            }
        }
    }
}
