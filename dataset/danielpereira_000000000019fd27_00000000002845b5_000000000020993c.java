import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            Set<String>[] columnSets = new HashSet[n];
            for (int x = 0; x < n; x++) {
                columnSets[x] = new HashSet<>();
            }
            int k = 0;
            int r = 0;
            int c = 0;
            for (int x = 0; x < n; x++) {
                String[] line = reader.readLine().split(" ");
                Set<String> rowSet = new HashSet<>();
                for (int z = 0; z < line.length; z++) {
                    columnSets[z].add(line[z]);
                    rowSet.add(line[z]);
                    if (x == z) {
                        k += Integer.parseInt(line[z]);
                    }
                }

                boolean hasRepeatedNumber = rowSet.size() < n;
                if (hasRepeatedNumber) {
                    r++;
                }
            }

            for (int x = 0; x < n; x++) {
                if (columnSets[x].size() < n) {
                    c++;
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", (i + 1), k, r, c));
        }
    }

}