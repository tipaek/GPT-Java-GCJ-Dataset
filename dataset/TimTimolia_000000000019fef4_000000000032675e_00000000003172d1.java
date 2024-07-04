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
            List<Long> angles = new ArrayList<>();
            for (int i = 0; i < slices; i++) angles.add(scanner.nextLong());
            Collections.sort(angles, new AnglesComparator());

            int cuts = 0;
            while (true) {
                if (containsSameAngles(angles, diners)) {
                    System.out.println("Case #" + caseNumber + ": " + cuts);
                    continue a;
                }
                List<Long> newAngles = new ArrayList<>();
                for (long angle : angles) {
                    newAngles.add(angle / 2);
                    newAngles.add(angle / 2);
                    newAngles.add(angle);
                }
                angles = newAngles;
                cuts++;
            }
        }

    }

    private static boolean containsSameAngles(List<Long> angles, int diners) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (long i : angles) {
            map.put(i, map.getOrDefault(i,0) + 1);
            if (map.get(i) >= diners) return true;
        }
        return false;
    }

    private static class AnglesComparator implements Comparator<Long> {

        @Override
        public int compare(Long o1, Long o2) {
            if (o1 > o2) return -1;
            else if (o1 < o2) return 1;
            else return 0;
        }
    }
}
