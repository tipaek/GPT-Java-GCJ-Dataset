import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = initializeScanner();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String[] nd = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            long[] arr = Arrays.stream(scanner.nextLine().split(" "))
                               .mapToLong(Long::parseLong)
                               .toArray();

            String result = resolveSingleCase(arr, d);
            System.out.println("Case #" + i + ": " + result);
            System.out.flush();
        }
        scanner.close();
    }

    private static Scanner initializeScanner() throws Exception {
        if (isDevelopmentMode()) {
            System.err.println("Development mode, reading from file");
            return new Scanner(new FileInputStream("input.txt"));
        } else {
            return new Scanner(System.in);
        }
    }

    private static boolean isDevelopmentMode() {
        String userName = System.getProperty("user.name");
        return "Alexey".equals(userName) || "Aleksiej_Mitrofanov".equals(userName);
    }

    private static String resolveSingleCase(long[] slices, int d) {
        Arrays.sort(slices);
        long minCuts = d - 1;

        for (int i = 0; i < slices.length; i++) {
            int availableD = 1;
            int availableDAll = 1;
            long minCutsCandidate = d - 1;

            for (int j = i + 1; j < slices.length; j++) {
                availableDAll += slices[j] / slices[i];
                if (availableD >= d) break;

                if (slices[j] == slices[i]) {
                    minCutsCandidate--;
                    availableD += slices[j] / slices[i];
                } else if (slices[j] % slices[i] == 0) {
                    availableD += slices[j] / slices[i];
                    if (minCutsCandidate != 1) {
                        minCutsCandidate--;
                    }
                }
            }

            if (availableDAll >= d && minCutsCandidate < minCuts) {
                minCuts = minCutsCandidate;
            }
        }

        return String.valueOf(minCuts);
    }
}