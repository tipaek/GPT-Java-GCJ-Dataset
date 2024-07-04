import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Solution class to process the test cases and find the shortest path.
 */
public class Solution {

    private final Map<String, Data> paths = new HashMap<>();
    private final List<Data> shortestPaths = new ArrayList<>();

    private static class Data {
        long x;
        long y;
        int len;
        char[] path;

        Data(long x, long y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.path = new char[len];
        }
    }

    private void processTestCase(int caseNum, Scanner scan, PrintWriter out) {
        long targetX = scan.nextLong();
        long targetY = scan.nextLong();
        Data shortest = paths.get(targetX + ";" + targetY);
        if (shortest == null) {
            out.printf("Case #%d: IMPOSSIBLE%n", caseNum);
        } else {
            out.printf("Case #%d: %s%n", caseNum, new String(shortest.path));
        }
    }

    private void process(InputStream inStream, OutputStream outStream) {
        try (Scanner scan = new Scanner(inStream); PrintWriter out = new PrintWriter(outStream)) {
            calculatePaths(10);
            int t = scan.nextInt();
            for (int i = 0; i < t; i++) {
                processTestCase(i + 1, scan, out);
            }
        }
    }

    private void calculatePaths(int maxLen) {
        int curLen = 0;
        long curStep = 1L;
        Data next = new Data(0, 0, 0);
        paths.put("0;0", next);
        
        while (next.len < maxLen) {
            explorePath(next, curStep, 0, 'E');
            explorePath(next, -curStep, 0, 'W');
            explorePath(next, 0, curStep, 'N');
            explorePath(next, 0, -curStep, 'S');
            next = shortestPaths.remove(0);
            if (next.len > curLen) {
                curLen = next.len;
                curStep *= 2;
            }
        }
    }

    private void explorePath(Data data, long horizontal, long vertical, char step) {
        long newX = data.x + horizontal;
        long newY = data.y + vertical;
        paths.computeIfAbsent(newX + ";" + newY, key -> {
            Data newPath = new Data(newX, newY, data.len + 1);
            newPath.path = Arrays.copyOf(data.path, data.len + 1);
            newPath.path[data.len] = step;
            shortestPaths.add(newPath);
            return newPath;
        });
    }

    public static void main(String[] args) {
        new Solution().process(System.in, System.out);
    }
}