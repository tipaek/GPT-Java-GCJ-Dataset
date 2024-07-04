import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        in.nextLine();

        for (int n = 0; n < numTests; n++) {
            int numEvents = in.nextInt();
            Map<Integer, Integer> starts = new TreeMap<Integer, Integer>();
            int[] times = new int[1441];
            boolean valid = true;

            for (int e = 0; e < numEvents; e++) {
                int start = in.nextInt();
                int end = in.nextInt();

                // for string building
                starts.put(start, end);

                // marking start and end
                times[start]++;
                times[end]--;
            }

            for (int i = 1; i < times.length; i++) {
                times[i] += times[i - 1];
                if (times[i] > 2) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                // assembling the string
                StringBuilder result = new StringBuilder();
                boolean cameron = true; // start w cameron
                int prev = 1;
                int prevStart = 0;
                for (int i : starts.keySet()) {
                    if (times[i] == 2) {
                        if (prev == 1) {
                            // swap
                            cameron = !cameron;
                        }
                        else {
                            // 2 and 2, figure out if need to swap
                            int prevEnd = starts.get(prevStart);
                            if (i < prevEnd) {
                                // swap
                                cameron = !cameron;
                            }
                        }
                        prev = 2;
                    }
                    else {
                        prev = 1;
                    }

                    prevStart = i;

                    if (cameron) {
                        result.append('C');
                    }
                    else {
                        result.append('J');
                    }
                }

                System.out.println("Case #" + (n + 1) + ": " + result);
            }
            else {
                System.out.println("Case #" + (n + 1) + ": IMPOSSIBLE");
            }
        }
    }
}