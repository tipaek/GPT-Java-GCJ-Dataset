import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final PrintWriter out = new PrintWriter(System.out);

    public static void main(final String[] args) throws IOException {
        int t = in.nextInt();
        int i = 1;
        while (t > 0) {
            out.print("Case #" + i + ": ");
            extractedAna();
            --t;
            i++;
        }
        out.flush();
        out.close();
        in.close();
    }

    private static void extractedAna() throws IOException {
        int n = in.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        Schedule j[] = new Schedule[n];
        for (int i = 0; i < end.length; i++) {
            j[i] = new Schedule();
            start[i] = in.nextInt();
            j[i].start = start[i];
            end[i] = in.nextInt();
            j[i].end = end[i];
            j[i].index = i;
        }

        Arrays.sort(j, (j1, j2) -> {

                    return j1.start - j2.start != 0 ? j1.start - j2.start : j1.end - j2.end;
        });
        Schedule Charrine = null, jams = null;
        for (int i = 0; i < j.length; i++) {
            if (Charrine == null || j[i].start >= Charrine.end) {
                 j[i].value = 'C';
                Charrine = j[i];
            } else if (jams == null || j[i].start >= jams.end) {
                j[i].value = 'J';
                jams = j[i];
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }
        char chh[] = new char[n];
        for (int i = 0; i < j.length; i++) {
            chh[j[i].index] = j[i].value;
        }
        for (char dd : chh) {
            out.print(dd);
        }
        out.println();
    }

    static class Schedule {
        int start, end, index;
        char value;
    }
}