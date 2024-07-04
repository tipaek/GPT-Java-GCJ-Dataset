import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int t = Integer.parseInt(reader.readLine());
        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(reader.readLine());
            writer.printf("Case #%d:\n", tt + 1);
            
            if (n == 1) {
                writer.println("1 1");
                continue;
            }

            int base = calculateBase(n);
            int baseG = calculateBaseG(n);
            int remaining = n - base - baseG;

            if (remaining < 0) {
                handleNegativeRemaining(writer, n, base, baseG);
            } else {
                handleNonNegativeRemaining(writer, n, base, baseG, remaining);
            }
        }

        reader.close();
        writer.close();
    }

    private static void handleNegativeRemaining(PrintWriter writer, int n, int base, int baseG) {
        for (int i = 0; i < baseG; i++) {
            writer.printf("%d 1\n", i + 1);
        }
        for (int i = 0; i < baseG - 1; i++) {
            writer.printf("%d %d\n", baseG, i + 2);
        }
        int x = n - (base / 2) - (baseG - 1);
        for (int i = 0; i < x; i++) {
            int y = baseG + i + 1;
            writer.printf("%d %d\n", y, y);
        }
    }

    private static void handleNonNegativeRemaining(PrintWriter writer, int n, int base, int baseG, int remaining) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < baseG + 1; i++) {
            list.add(String.format("%d %d", baseG + 1, baseG - i + 1));
        }

        int pow = 1;
        int counter = 1;
        for (int i = 0; i < baseG - 1; i++) {
            pow *= 2;
            counter++;
        }

        boolean forward = true;
        for (int i = 0; i < baseG; i++) {
            if (remaining >= pow - 1) {
                remaining -= (pow - 1);
                if (forward) {
                    for (int j = 0; j < counter; j++) {
                        list.add(String.format("%d %d", counter, j + 1));
                    }
                } else {
                    for (int j = counter - 1; j >= 0; j--) {
                        list.add(String.format("%d %d", counter, j + 1));
                    }
                }
                forward = !forward;
            } else {
                if (forward) {
                    list.add(String.format("%d 1", counter));
                } else {
                    list.add(String.format("%d %d", counter, counter));
                }
            }
            pow /= 2;
            counter--;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            writer.println(list.get(i));
        }
    }

    public static int calculateBase(int x) {
        if (x == 0) {
            return 0;
        }
        int count = 1;
        while (x > 1) {
            x /= 2;
            count *= 2;
        }
        return count;
    }

    public static int calculateBaseG(int x) {
        if (x == 0) {
            return 0;
        }
        int count = 0;
        while (x > 1) {
            x /= 2;
            count++;
        }
        return count;
    }
}