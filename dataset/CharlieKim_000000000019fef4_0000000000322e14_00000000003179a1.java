import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int u = scanner.nextInt();

            List<RandomPoint> points = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                points.add(new RandomPoint(scanner.nextInt(), scanner.next()));
            }

            Collections.sort(points);

            System.out.println("Case #" + (i + 1) + ": " + solve(points));
        }
    }

    private static String solve(List<RandomPoint> points) {
        Character[] result = new Character[10];
        Arrays.fill(result, ' ');

        for (RandomPoint point : points) {
            if (point.q < 10) {
                if (result[point.q] == ' ') {
                    int count = 0;
                    for (int i = 1; i < point.q; i++) {
                        if (point.r.charAt(0) == result[i]) {
                            count += 1;
                        }
                    }

                    if (count == 0) {
                        result[point.q] = point.r.charAt(0);
                    }
                }
            } else {
                if (point.r.length() > 1) {
                    int count = 0;
                    for (int i = 1; i <= 9; i++) {
                        if (point.r.charAt(1) == result[i]) {
                            count += 1;
                        }
                    }

                    if (count == 0) {
                        result[0] = point.r.charAt(1);
                        break;
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Character character : result) {
            builder.append(character);
        }

        return builder.toString();
    }
}

class RandomPoint implements Comparable<RandomPoint> {

    int q;
    String r;

    public RandomPoint(int q, String r) {
        this.q = q;
        this.r = r;
    }

    @Override
    public int compareTo(RandomPoint point) {
        return q - point.q;
    }
}