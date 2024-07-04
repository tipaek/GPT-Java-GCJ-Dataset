import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseAmount = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        scanner.nextLine();
        a: for (int caseNumber = 1; caseNumber <= caseAmount; caseNumber++) {
            int slices = scanner.nextInt();
            int diners = scanner.nextInt();
            List<Double> angles = new ArrayList<>();
            for (int i = 0; i < slices; i++) angles.add(scanner.nextDouble());
            Collections.sort(angles, new AnglesComparator());

            if (containsSameAngles(angles, diners)) {
                System.out.println("Case #" + caseNumber + ": " + 0);
                continue a;
            }

            int cuts = 0;
            while (true) {
                if (containsSameAngles(angles, diners)) {
                    System.out.println("Case #" + caseNumber + ": " + (cuts - 1));
                    continue a;
                }
                cuts++;
                List<Double> newAngles = new ArrayList<>();
                for (double angle : angles) {
                    if (newAngles.contains(angle)) {
                        newAngles.add(angle);
                        continue;
                    }
                    double d = angle / cuts;
                    for (int i = 0; i < cuts; i++) newAngles.add(d);
                }
                angles = newAngles;
            }
        }

    }

    private static boolean containsSameAngles(List<Double> angles, int diners) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (double i : angles) {
            map.put(i, map.getOrDefault(i,0) + 1);
            if (map.get(i) >= diners) return true;
        }
        return false;
    }

    private static class AnglesComparator implements Comparator<Double> {

        @Override
        public int compare(Double o1, Double o2) {
            if (o1 > o2) return -1;
            else if (o1 < o2) return 1;
            else return 0;
        }
    }
}