import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        class Group {
            private final int value;
            private int count;

            public Group(int value) {
                this.value = value;
                this.count = 1;
            }

            public int getValue() {
                return value;
            }

            public int getCount() {
                return count;
            }

            public void incrementCount() {
                this.count++;
            }
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < testCases; i++) {
                String input = scanner.nextLine();
                List<Group> groups = new ArrayList<>();
                Group currentGroup = null;

                for (char ch : input.toCharArray()) {
                    int digit = ch - '0';

                    if (currentGroup == null) {
                        currentGroup = new Group(digit);
                    } else if (currentGroup.getValue() == digit) {
                        currentGroup.incrementCount();
                    } else {
                        groups.add(currentGroup);
                        currentGroup = new Group(digit);
                    }
                }

                if (currentGroup != null) {
                    groups.add(currentGroup);
                }

                StringBuilder result = new StringBuilder();
                int openBrackets = 0;

                for (Group group : groups) {
                    int value = group.getValue();
                    int count = group.getCount();

                    if (openBrackets > value) {
                        for (int j = 0; j < openBrackets - value; j++) {
                            result.append(')');
                        }
                        openBrackets = value;
                    } else if (openBrackets < value) {
                        for (int j = 0; j < value - openBrackets; j++) {
                            result.append('(');
                        }
                        openBrackets = value;
                    }

                    for (int j = 0; j < count; j++) {
                        result.append(value);
                    }
                }

                for (int j = 0; j < openBrackets; j++) {
                    result.append(')');
                }

                System.out.format("Case #%d: %s\n", i + 1, result.toString());
            }
        }
    }
}