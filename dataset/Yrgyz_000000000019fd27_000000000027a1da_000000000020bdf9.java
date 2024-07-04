import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int start, end;
        List<Integer> c = new ArrayList<Integer>();
        List<Integer> j = new ArrayList<Integer>();
        String result;
        boolean possible, cConflict, jConflict;
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            c.clear();
            j.clear();
            StringBuilder answer = new StringBuilder();
            possible = true;
            while (n > 0) {
                start = in.nextInt();
                end = in.nextInt();
                n--;
                if (!possible) continue;
                if (c.isEmpty()) {
                    answer.append("C");
                    c.add(start);
                    c.add(end);
                } else if (j.isEmpty()) {
                    answer.append("J");
                    j.add(start);
                    j.add(end);
                } else {
                    cConflict = false;
                    jConflict = false;
                    for (int k = 0; k < c.size(); k = k+2) {
                        if (conflict(c.get(k), c.get(k + 1), start, end)) {
                            cConflict = true;
                            break;
                        }
                    }
                    if (!cConflict) {
                        answer.append("C");
                        c.add(start);
                        c.add(end);
                    }
                    if (cConflict) {
                        for (int k = 0; k < j.size(); k = k+2) {
                            if (conflict(j.get(k), j.get(k + 1), start, end)) {
                                jConflict = true;
                                break;
                            }
                        }
                        if (!jConflict) {
                            answer.append("J");
                            j.add(start);
                            j.add(end);
                        }
                    }
                    if (cConflict && jConflict) {
                        possible = false;
                    }
                }
            }

            result = possible ? answer.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean conflict(int start1, int end1, int start2, int end2) {
        return start2 < end1 && end2 > start1;
    }
}