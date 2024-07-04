import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());
        int[][] results = new int[testCases][3];

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Set<Integer>> columnSets = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String inputLine = br.readLine();
                Set<Integer> rowSet = new HashSet<>();

                StringTokenizer tokenizer = new StringTokenizer(inputLine);
                for (int k = 0; k < n; k++) {
                    int value = Integer.parseInt(tokenizer.nextToken());
                    rowSet.add(value);

                    if (j == k) {
                        results[i][0] += value;
                    }

                    if (j == 0) {
                        columnSets.add(new HashSet<>());
                    }
                    columnSets.get(k).add(value);
                }

                if (rowSet.size() != n) {
                    results[i][1]++;
                }
            }

            for (Set<Integer> columnSet : columnSets) {
                if (columnSet.size() != n) {
                    results[i][2]++;
                }
            }
        }

        for (int i = 0; i < results.length; i++) {
            System.out.printf("Case No #%d: %d %d %d\n", i, results[i][0], results[i][1], results[i][2]);
        }
    }
}