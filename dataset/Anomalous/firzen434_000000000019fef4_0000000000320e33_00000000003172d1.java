import java.util.*;
import java.io.*;

public class Solution {

    private static String findSolution(int numSlices, int numDiners, List<Long> slices) {
        if (numDiners == 1) {
            return "0";
        } else if (numDiners == 2) {
            Collections.sort(slices);
            for (int i = 0; i < slices.size() - 1; i++) {
                if (slices.get(i).equals(slices.get(i + 1))) {
                    return "0";
                }
            }
            return "1";
        } else if (numDiners == 3) {
            Collections.sort(slices);
            for (int i = 0; i < slices.size() - 2; i++) {
                if (slices.get(i).equals(slices.get(i + 1)) && slices.get(i).equals(slices.get(i + 2))) {
                    return "0";
                }
            }
            for (int i = 0; i < slices.size(); i++) {
                for (int j = 0; j < slices.size(); j++) {
                    if (slices.get(j) * 2 == slices.get(i)) {
                        return "1";
                    }
                }
            }
            return "2";
        }
        return "0";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int numSlices = scanner.nextInt();
            int numDiners = scanner.nextInt();
            List<Long> slices = new ArrayList<>();
            for (int j = 0; j < numSlices; j++) {
                slices.add(scanner.nextLong());
            }
            System.out.println("Case #" + i + ": " + findSolution(numSlices, numDiners, slices));
        }
    }
}