import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            final String IMPOSSIBLE = "IMPOSSIBLE";

            for (int t = 1; t <= testCases; ++t) {
                int n = scanner.nextInt();
                StringBuilder result = new StringBuilder();
                ArrayList<Integer> jStart = new ArrayList<>();
                ArrayList<Integer> jEnd = new ArrayList<>();
                ArrayList<Integer> cStart = new ArrayList<>();
                ArrayList<Integer> cEnd = new ArrayList<>();

                boolean possible = true;

                for (int j = 0; j < n; ++j) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    boolean isJFree = true;
                    boolean isCFree = true;

                    for (int k = 0; k < jStart.size(); k++) {
                        if ((jStart.get(k) < start && start < jEnd.get(k)) || 
                            (jStart.get(k) < end && end < jEnd.get(k)) || 
                            (jStart.get(k) > start && jEnd.get(k) < end) || 
                            (jStart.get(k) < start && jEnd.get(k) > end)) {
                            isJFree = false;
                            break;
                        }
                    }

                    for (int k = 0; k < cStart.size(); k++) {
                        if ((cStart.get(k) < start && start < cEnd.get(k)) || 
                            (cStart.get(k) < end && end < cEnd.get(k)) || 
                            (cStart.get(k) > start && cEnd.get(k) < end) || 
                            (cStart.get(k) < start && cEnd.get(k) > end)) {
                            isCFree = false;
                            break;
                        }
                    }

                    if (isJFree) {
                        jStart.add(start);
                        jEnd.add(end);
                        result.append("J");
                    } else if (isCFree) {
                        cStart.add(start);
                        cEnd.add(end);
                        result.append("C");
                    } else {
                        result = new StringBuilder(IMPOSSIBLE);
                        possible = false;
                        break;
                    }
                }

                System.out.println("Case #" + t + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}