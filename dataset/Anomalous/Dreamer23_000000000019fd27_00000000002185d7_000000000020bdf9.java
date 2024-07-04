import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static void test() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data/testIn"));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            total.append(line).append("\n");
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the line below to enable testing with the test() method
        // test();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int caseNum = 1; caseNum <= t; caseNum++) {
                int numChores = Integer.parseInt(scanner.nextLine());
                System.out.println("Case #" + caseNum + ": " + getResult(numChores, scanner));
            }
        }
    }

    private static String getResult(int numChores, Scanner scanner) {
        List<HouseholdChore> chores = new ArrayList<>(numChores);
        char[] choreAssignment = new char[numChores];
        for (int i = 0; i < numChores; i++) {
            String[] input = scanner.nextLine().split(" ");
            int startTime = Integer.parseInt(input[0]);
            int endTime = Integer.parseInt(input[1]);
            chores.add(new HouseholdChore(startTime, endTime, i));
        }
        Collections.sort(chores);
        int cameronFreeAt = 0;
        int jamieFreeAt = 0;
        for (HouseholdChore chore : chores) {
            if (chore.startTime >= cameronFreeAt) {
                cameronFreeAt = chore.endTime;
                choreAssignment[chore.originalPosition] = 'C';
            } else if (chore.startTime >= jamieFreeAt) {
                jamieFreeAt = chore.endTime;
                choreAssignment[chore.originalPosition] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(choreAssignment);
    }

    private static class HouseholdChore implements Comparable<HouseholdChore> {
        private final int startTime;
        private final int endTime;
        private final int originalPosition;

        private HouseholdChore(int startTime, int endTime, int originalPosition) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.originalPosition = originalPosition;
        }

        @Override
        public int compareTo(HouseholdChore other) {
            return Integer.compare(this.startTime, other.startTime);
        }
    }
}