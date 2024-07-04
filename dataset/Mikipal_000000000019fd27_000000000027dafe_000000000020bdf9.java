
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //activities
            in.nextLine();
            int acts[][] = new int[n][2];
            for (int j = 0; j < n; j++) {
                String mom[] = new String[2];
                mom = in.nextLine().split(" ");
                for (int k = 0; k < 2; k++) {
                    acts[j][k] = Integer.parseInt(mom[k]);
                }

            }
            int tm = 0;
            char seq[] = new char[n];
            String answ = "";
            int c = -1, j = -1;

            int max = 0;
            for (int k = 0; k < acts.length; k++) {
                if (acts[k][1] > max) {
                    max = acts[k][1];
                }

            }
            while (tm > -1) {
                for (int k = 0; k < acts.length; k++) {
                    if (tm == acts[k][1]) {
                        if (c == acts[k][0]) {
                            c = -1;
                        } else if (j == acts[k][0]) {
                            j = -1;
                        }
                    }
                }
                for (int k = 0; k < acts.length; k++) {
                    if (tm == acts[k][0]) {
                        if (c == -1) {
                            c = tm;
                            seq[k] = 'C';
                        } else if (j == -1) {
                            j = tm;
                            seq[k] = 'J';
                        } else {
                            tm = -3;
                        }
                    }
                }

                tm++;
                if (tm > max) {
                    tm = -1;
                }
            }

            if (tm == -2) {
                answ = "IMPOSSIBLE";
            }else{
                for(char ch : seq){
                    answ += ch;
                }
            }
            System.out.println("Case #" + i + ": " + answ);
        }
    }
}
