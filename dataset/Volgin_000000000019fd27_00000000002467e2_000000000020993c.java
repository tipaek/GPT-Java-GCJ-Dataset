import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    final static char ZERO = '0';
    final static char ONE = '1';

    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader);
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int k = 0;
        int r = 0;
        int c = 0;
        Set<Integer>[] columns = new Set[n];
        for (int i = 0; i < n; i++) {
            columns[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            Set<Integer> rowItems = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int mij = Integer.parseInt(row[j]);
                columns[j].add(mij);
                rowItems.add(mij);
                if (i == j) {
                    k += mij;
                }
            }
            r += (rowItems.size() < n) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            c += (columns[i].size() < n) ? 1 : 0;
        }
        System.out.println("Case #" + caseId + ": " + k + " " + r + " " + c);
    }
}