import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {
            StringBuilder result = new StringBuilder();
            Vector<Integer> line = new Vector<>();
            Arrays.stream(reader.readLine().split(""))
                    .map(Integer::parseInt)
                    .forEach(line::add);

            int prev, actual, next;
            for (int j = 0; j < line.size(); j++) {
                if (j == 0) {
                    prev = 0;
                } else {
                    prev = line.get(j - 1);
                }
                if (j == line.size() - 1) {
                    next = 0;
                } else {
                    next = line.get(j + 1);
                }
                actual = line.get(j);
                int before = actual - prev;
                if (before > 0){
                    while(before > 0) {
                        result.append("(");
                        before--;
                    }
                }
                result.append(actual);
                int after = actual - next;
                if (after > 0){
                    while(after > 0) {
                        result.append(")");
                        after--;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}