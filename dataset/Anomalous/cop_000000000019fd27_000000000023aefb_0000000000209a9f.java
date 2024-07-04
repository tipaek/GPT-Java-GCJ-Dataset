import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Group {
        private final int value;
        private int count;

        public Group(int value) {
            this.value = value;
            this.count = 1;
        }

        public void incrementCount() {
            this.count++;
        }

        public int getValue() {
            return value;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            scanner.nextLine();

            for (int caseIndex = 1; caseIndex <= totalCases; caseIndex++) {
                String input = scanner.nextLine();
                List<Group> groups = new ArrayList<>();
                Group currentGroup = null;

                for (char ch : input.toCharArray()) {
                    int value = ch - '0';
                    if (currentGroup == null || currentGroup.getValue() != value) {
                        currentGroup = new Group(value);
                        groups.add(currentGroup);
                    } else {
                        currentGroup.incrementCount();
                    }
                }

                StringBuilder result = new StringBuilder();
                for (Group group : groups) {
                    int value = group.getValue();
                    int count = group.getCount();
                    result.append("(".repeat(value))
                          .append(String.valueOf(value).repeat(count))
                          .append(")".repeat(value));
                }

                System.out.printf("Case #%d: %s%n", caseIndex, result);
            }
        }
    }
}