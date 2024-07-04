import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int x = 1; x <= cases; x++) {
            int tasks = Integer.parseInt(br.readLine());

            ArrayList<Integer> cStart = new ArrayList<>();
            ArrayList<Integer> jStart = new ArrayList<>();
            ArrayList<Integer> cEnd = new ArrayList<>();
            ArrayList<Integer> jEnd = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < tasks; i++) {
                String[] task = br.readLine().split(" ");
                int currStart = Integer.parseInt(task[0]);
                int currEnd = Integer.parseInt(task[1]);
                boolean assigned = false;

                if (cStart.isEmpty()) {
                    output.append("J");
                    cStart.add(currStart);
                    cEnd.add(currEnd);
                    assigned = true;
                } else {
                    if (isPlaceable(cStart, cEnd, currStart, currEnd)) {
                        output.append("J");
                        cStart.add(currStart);
                        cEnd.add(currEnd);
                        assigned = true;
                    }
                }

                if (!assigned) {
                    if (jStart.isEmpty()) {
                        output.append("C");
                        jStart.add(currStart);
                        jEnd.add(currEnd);
                        assigned = true;
                    } else {
                        if (isPlaceable(jStart, jEnd, currStart, currEnd)) {
                            output.append("C");
                            jStart.add(currStart);
                            jEnd.add(currEnd);
                            assigned = true;
                        }
                    }
                }

                if (!assigned) {
                    for (int j = i + 1; j < tasks; j++) {
                        br.readLine();
                    }
                    break;
                }
            }

            if (output.length() < tasks)
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + x + ": " + output);
        }
    }

    private static boolean isPlaceable(ArrayList<Integer> start, ArrayList<Integer> end, int currStart, int currEnd) {
        for (int i = 0; i < start.size(); i++) {
            if (!(currStart >= end.get(i) || currEnd <= start.get(i))) {
                return false;
            }
        }
        return true;
    }
}