import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int test = 1; test <= numberOfTests; test++) {
            int[] array = new int[arraySize + 1];
            int index = 0;
            int remainingQueries = 10;
            
            while (index <= arraySize / 2 - 1) {
                if (remainingQueries == 0) {
                    int[] result = handleRemainingQueries(array, index, scanner);
                    remainingQueries = result[0];
                    index = result[1];
                }
                
                if (remainingQueries == 1) {
                    fetchNumber(1, scanner);
                    remainingQueries--;
                }
                
                while (remainingQueries > 1 && index <= arraySize / 2 - 1) {
                    array[1 + index] = fetchNumber(1 + index, scanner);
                    array[arraySize - index] = fetchNumber(arraySize - index, scanner);
                    remainingQueries -= 2;
                    index++;
                }
            }

            StringBuilder resultString = new StringBuilder();
            for (int j = 1; j < array.length; j++) {
                resultString.append(array[j]);
            }
            System.out.println(resultString.toString());

            scanner.nextLine();
            String response = scanner.nextLine();
            if (response.equals("N")) {
                break;
            }
        }
    }

    private static int[] handleRemainingQueries(int[] array, int index, Scanner scanner) {
        int remainingQueries = 10;
        int currentIndex = 0;
        HashSet<Integer> scenarios = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        boolean equalCheck = false;
        boolean notEqualCheck = false;

        while (remainingQueries > 0 && currentIndex <= index) {
            int start = array[1 + currentIndex];
            int end = array[array.length - 1 - currentIndex];

            if (start == end && equalCheck) {
                currentIndex++;
                continue;
            } else if (start != end && notEqualCheck) {
                currentIndex++;
                continue;
            }

            int startValue = fetchNumber(1 + currentIndex, scanner);

            if (start == startValue && start == end) {
                scenarios.remove(2);
                scenarios.remove(4);
                equalCheck = true;
            }
            if (start == startValue && start != end) {
                scenarios.remove(1);
                scenarios.remove(2);
                notEqualCheck = true;
            }
            if (start != startValue && start == end) {
                scenarios.remove(1);
                scenarios.remove(3);
                equalCheck = true;
            }
            if (start != startValue && start != end) {
                scenarios.remove(3);
                scenarios.remove(4);
                notEqualCheck = true;
            }

            remainingQueries--;
            currentIndex++;

            if (scenarios.size() == 1) {
                break;
            }
        }

        applyScenario(array, scenarios.iterator().next());
        return new int[]{remainingQueries, index};
    }

    private static void applyScenario(int[] array, Integer scenario) {
        int length = array.length - 1;
        if (scenario == 1) {
            for (int i = 0; i <= length / 2 - 1; i++) {
                int temp = array[1 + i];
                array[1 + i] = array[length - i];
                array[length - i] = temp;
            }
        } else if (scenario == 2) {
            for (int i = 1; i <= length; i++) {
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