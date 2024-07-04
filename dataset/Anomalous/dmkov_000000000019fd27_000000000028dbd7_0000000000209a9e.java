import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        int arrayLength = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int[] array = new int[arrayLength + 1];
            int index = 0;
            int remainingQueries = 10;

            while (index <= arrayLength / 2 - 1) {
                if (remainingQueries == 0) {
                    int[] result = processRemainingQueries(array, index, scanner);
                    remainingQueries = result[0];
                    index = result[1];
                }
                if (remainingQueries == 1) {
                    fetchNumber(1, scanner);
                }
                while (remainingQueries > 1 && index <= arrayLength / 2 - 1) {
                    array[1 + index] = fetchNumber(1 + index, scanner);
                    array[arrayLength - index] = fetchNumber(arrayLength - index, scanner);
                    remainingQueries -= 2;
                    index++;
                }
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 1; i < array.length; i++) {
                resultBuilder.append(array[i]);
            }
            System.out.println(resultBuilder.toString());

            scanner.nextLine(); // Consume the newline character
            String response = scanner.nextLine();
            if (response.equals("N")) {
                break;
            }
        }
    }

    private static int[] processRemainingQueries(int[] array, int index, Scanner scanner) {
        int remainingQueries = 10;
        int k = 0;
        HashSet<Integer> scenarios = new HashSet<>(java.util.Arrays.asList(1, 2, 3, 4));
        boolean equalCheck = false;
        boolean notEqualCheck = false;

        while (remainingQueries > 0 && k <= index) {
            int startValue = array[1 + k];
            int endValue = array[array.length - 1 - k];

            if (startValue == endValue && equalCheck) {
                k++;
                continue;
            } else if (startValue != endValue && notEqualCheck) {
                k++;
                continue;
            }

            int newValue = fetchNumber(1 + k, scanner);

            if (startValue == newValue && startValue == endValue) {
                scenarios.remove(2);
                scenarios.remove(4);
                equalCheck = true;
            } else if (startValue == newValue && startValue != endValue) {
                scenarios.remove(1);
                scenarios.remove(2);
                notEqualCheck = true;
            } else if (startValue != newValue && startValue == endValue) {
                scenarios.remove(1);
                scenarios.remove(3);
                equalCheck = true;
            } else if (startValue != newValue && startValue != endValue) {
                scenarios.remove(3);
                scenarios.remove(4);
                notEqualCheck = true;
            }

            remainingQueries--;
            k++;

            if (scenarios.size() == 1) {
                break;
            }
        }

        applyScenario(array, scenarios.iterator().next());
        return new int[]{remainingQueries, index};
    }

    private static void applyScenario(int[] array, int scenario) {
        int n = array.length - 1;
        if (scenario == 1) {
            for (int i = 0; i < n / 2; i++) {
                int temp = array[1 + i];
                array[1 + i] = array[n - i];
                array[n - i] = temp;
            }
        } else if (scenario == 2) {
            for (int i = 1; i <= n; i++) {
                array[i] = (array[i] == 1) ? 0 : 1;
            }
        } else if (scenario == 4) {
            applyScenario(array, 1);
            applyScenario(array, 2);
        }
    }

    private static int fetchNumber(int index, Scanner scanner) {
        System.out.println(index);
        return scanner.nextInt();
    }
}