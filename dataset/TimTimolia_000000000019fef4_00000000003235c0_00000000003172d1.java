import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

            if (containsSameAngles(angles, diners)) {
                System.out.println("Case #" + caseNumber + ": 0");
                continue a;
            }

            if (diners == 3) {
                for (long a1 : angles) {
                    for (long a2 : angles) {
                        if (a1 / 2 == a2) {
                            System.out.println("Case #" + caseNumber + ": 1");
                            continue a;
                        }
                    }
                }
                System.out.println("Case #" + caseNumber + ": 2");
            } else {
                System.out.println("Case #" + caseNumber + ": 1");
            }


//            System.out.println("Case #" + caseNumber + ": " + (diners - 1));
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

}
