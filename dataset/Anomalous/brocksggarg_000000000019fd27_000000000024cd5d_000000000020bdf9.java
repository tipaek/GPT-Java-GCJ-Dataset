import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair implements Comparable<Pair> {
    int start;
    int end;
    String assignedTo;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            solve(reader, i);
        }
    }

    private static void solve(BufferedReader reader, int caseNumber) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Map<Integer, Pair> pairMap = new HashMap<>();
        List<Pair> pairs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = reader.readLine().split(" ");
            Pair pair = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            pairMap.put(i, pair);
            pairs.add(pair);
        }

        Collections.sort(pairs);

        int cEnd = 0, jEnd = 0;
        boolean impossible = false;

        for (Pair pair : pairs) {
            if (pair.start >= cEnd) {
                pair.assignedTo = "C";
                cEnd = pair.end;
            } else if (pair.start >= jEnd) {
                pair.assignedTo = "J";
                jEnd = pair.end;
            } else {
                impossible = true;
                break;
            }
        }

        if (impossible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                result.append(pairMap.get(i).assignedTo);
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}