import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class ParentingPartnering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int dataSize = Integer.parseInt(scanner.next());
        int caseNumber = 1;

        while (dataSize > 0) {
            int numActivities = Integer.parseInt(scanner.next());
            boolean[] cBusy = new boolean[1441];
            boolean[] jBusy = new boolean[1441];
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < numActivities; i++) {
                int start = Integer.parseInt(scanner.next());
                int end = Integer.parseInt(scanner.next());

                if (schedule.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                if (isAvailable(start, end, cBusy)) {
                    markBusy(start, end, cBusy);
                    schedule.append("C");
                } else if (isAvailable(start, end, jBusy)) {
                    markBusy(start, end, jBusy);
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            caseNumber++;
            dataSize--;
        }
    }

    private static boolean isAvailable(int start, int end, boolean[] parent) {
        for (int i = start; i < end; i++) {
            if (parent[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int start, int end, boolean[] parent) {
        for (int i = start; i < end; i++) {
            parent[i] = true;
        }
    }
}