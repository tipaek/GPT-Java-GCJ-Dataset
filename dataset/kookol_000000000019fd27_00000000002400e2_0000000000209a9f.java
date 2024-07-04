import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            String s = in.next();

            StringBuilder sb = new StringBuilder();

            int opened = 0;
            for(int j = 0; j < s.length() - 1; j++ ){

                int th = Character.getNumericValue(s.charAt(j));
                int next = Character.getNumericValue(s.charAt(j+1));
                if ((th - opened) <= 0 ) {
                    if ((th - next) <= 0) {
                        sb.append(th);
                    } else {
                        sb.append(th).append(")".repeat(th - next));
                    }
                } else {
                    if((th - next) <= 0) {
                        sb.append("(".repeat(th - opened)).append(th);
                    } else {
                        sb.append("(".repeat(th - opened)).append(th).append(")".repeat(th - next));
                    }
                }
                opened = th;

            }
            int th = Character.getNumericValue(s.charAt(s.length() - 1));
            if ((th - opened) <= 0 ) {
                sb.append(th).append(")".repeat(th));
            } else {
                sb.append("(".repeat(th - opened)).append(th).append(")".repeat(th));
            }
            System.out.println("Case #" + i + ": " + sb);
        }
    }
}