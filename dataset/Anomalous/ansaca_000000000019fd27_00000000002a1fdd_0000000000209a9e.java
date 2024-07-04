import java.util.Scanner;

public class Solution {
    static int counter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            counter = 1;
            int[] array = new int[arraySize];
            int diffIndex = -1, equalIndex = -1;
            int operations = 0;

            while (counter <= arraySize / 2) {
                operations = 0;

                if (diffIndex != -1) {
                    processIndex(array, diffIndex, scanner);
                    operations++;
                }

                if (equalIndex != -1) {
                    processIndex(array, equalIndex, scanner);
                    operations++;
                }

                if (operations % 2 != 0) {
                    System.out.println(1);
                    scanner.nextLine();
                    operations++;
                }

                while (operations < 10 && counter <= arraySize / 2) {
                    processPair(array, counter, arraySize, scanner);
                    if (equalIndex == -1 && array[counter - 1] == array[arraySize - counter]) {
                        equalIndex = counter;
                    }
                    if (diffIndex == -1 && array[counter - 1] != array[arraySize - counter]) {
                        diffIndex = counter;
                    }
                    counter++;
                    operations += 2;
                }

                if (equalIndex != -1 && diffIndex != -1) break;
            }

            if (counter > arraySize / 2) {
                if (!displayResults(array, scanner)) break;
                continue;
            }

            while (operations < 10) {
                System.out.println(1);
                scanner.nextLine();
                operations++;
            }

            if (equalIndex != -1 && diffIndex != -1) {
                solveNormalCase(array, equalIndex, diffIndex, scanner);
            } else if (equalIndex != -1) {
                solveEqualCase(array, equalIndex, scanner);
            } else if (diffIndex != -1) {
                solveDiffCase(array, diffIndex, scanner);
            }

            if (!displayResults(array, scanner)) break;
        }
    }

    private static void processIndex(int[] array, int index, Scanner scanner) {
        int before = array[index - 1];
        System.out.println(index);
        int after = Integer.parseInt(scanner.nextLine());
        if (after != before) invertArray(array);
    }

    private static void processPair(int[] array, int counter, int size, Scanner scanner) {
        System.out.println(counter);
        array[counter - 1] = Integer.parseInt(scanner.nextLine());
        System.out.println(size - (counter - 1));
        array[size - counter] = Integer.parseInt(scanner.nextLine());
    }

    private static boolean displayResults(int[] array, Scanner scanner) {
        StringBuilder result = new StringBuilder(array.length);
        for (int value : array) {
            result.append(value);
        }
        System.out.println(result.toString());
        String response = scanner.nextLine();
        return response.equals("Y");
    }

    private static void solveNormalCase(int[] array, int equalIndex, int diffIndex, Scanner scanner) {
        while (counter <= array.length / 2) {
            int equalValue = array[equalIndex - 1];
            int diffValue = array[diffIndex - 1];

            int newEqualValue = getNewValue(equalIndex, scanner);
            int newDiffValue = getNewValue(diffIndex, scanner);

            if (newEqualValue != equalValue) {
                invertArray(array);
                if (newDiffValue == diffValue) {
                    reverseArray(array);
                }
            } else if (newDiffValue != diffValue) {
                reverseArray(array);
            }

            fillArray(array, equalIndex, diffIndex, scanner);
        }
    }

    private static void solveEqualCase(int[] array, int equalIndex, Scanner scanner) {
        while (counter <= array.length / 2) {
            int equalValue = array[equalIndex - 1];

            int newEqualValue = getNewValue(equalIndex, scanner);
            getNewValue(equalIndex, scanner); // Discard the second value

            if (newEqualValue != equalValue) {
                invertArray(array);
            }

            fillArray(array, equalIndex, -1, scanner);
        }
    }

    private static void solveDiffCase(int[] array, int diffIndex, Scanner scanner) {
        while (counter <= array.length / 2) {
            int diffValue = array[diffIndex - 1];

            int newDiffValue = getNewValue(diffIndex, scanner);
            getNewValue(diffIndex, scanner); // Discard the second value

            if (newDiffValue != diffValue) {
                invertArray(array);
            }

            fillArray(array, -1, diffIndex, scanner);
        }
    }

    private static int getNewValue(int index, Scanner scanner) {
        System.out.println(index);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void fillArray(int[] array, int equalIndex, int diffIndex, Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            while (counter == equalIndex || counter == diffIndex) counter++;
            if (counter > array.length / 2) break;
            processPair(array, counter, array.length, scanner);
            counter++;
        }
    }

    private static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
    }

    private static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}