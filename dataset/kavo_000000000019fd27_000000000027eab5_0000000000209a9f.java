import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int casei = 1; casei <= t; ++casei) {
            //String s = in.nextLine();
            StringBuilder s = new StringBuilder(in.nextLine());
            int prev_height = 0;
            int checker = 0;

            for (int i = 0;; i++) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int val = ((int) ch)-48;
                    int diff = val - prev_height;
                    if (diff > 0) {
                        s.ensureCapacity(s.capacity()+diff);
                        for (int j = 0; j < diff; j++) {
                            s.insert(i, '(');
                            checker++;
                            //System.out.println(i+"：" + s.toString());
                        }
                    } else if (diff < 0) {
                        int cnt = diff * -1;
                        //System.out.println("cnt" + cnt);
                        s.ensureCapacity(s.capacity()+cnt);
                        for (int j = 0; j < cnt; j++) {
                            s.insert(i, ')');
                            checker--;
                            //System.out.println(i+"：" + s.toString());
                        }

                    } else {
                        //noop
                    }
                    prev_height=val;
                }
                if (i > s.length()-2) {
                    break;
                }
            }
            if(checker>0) {
                for (int j = 0; j < checker; j++) {
                    s.insert(s.length(), ')');
                }
            }

            System.out.println("Case #" + casei + ": " + s.toString());
        }
    }
}