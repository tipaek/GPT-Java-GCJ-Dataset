import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = -1;
            }

            // Initial population of the array
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                array[i - 1] = scanner.nextInt();
            }
            for (int i = 0; i <= 4; i++) {
                System.out.println(arraySize - i);
                array[arraySize - i - 1] = scanner.nextInt();
            }

            int sameIndex = -1;
            int diffIndex = -1;

            for (int r = 0; r < arraySize / 2; r += 4) {
                for (int i = 0; i < 5; i++) {
                    if (array[r + i] == array[arraySize - i - 1 - r] && array[r + i] != -1) {
                        sameIndex = r + i;
                    } else if (array[r + i] != -1) {
                        diffIndex = r + i;
                    }
                }

                if (sameIndex == -1) {
                    // Case: All elements are the same
                    System.out.println(1);
                    int a = scanner.nextInt();
                    System.out.println(1);
                    a = scanner.nextInt();
                    if (array[0] != a) {
                        reverseArray(array);
                    }
                } else if (diffIndex == -1) {
                    // Case: All elements are complementary
                    System.out.println(1);
                    int a = scanner.nextInt();
                    System.out.println(1);
                    a = scanner.nextInt();
                    if (array[0] != a) {
                        complementArray(array);
                    }
                } else {
                    // General case
                    System.out.println(sameIndex + 1);
                    int a = scanner.nextInt();
                    System.out.println(diffIndex + 1);
                    int b = scanner.nextInt();
                    if (a != array[sameIndex] && b != array[diffIndex]) {
                        complementArray(array);
                    } else if (a == array[sameIndex] && b != array[diffIndex]) {
                        reverseArray(array);
                    } else if (a != array[sameIndex] && b == array[diffIndex]) {
                        complementArray(array);
                        reverseArray(array);
                    }
                }

                // Further population of the array
                for (int i = r + 4 + 1; i < r + 8 + 1; i++) {
                    System.out.println(Math.min(arraySize, i + 1));
                    array[Math.min(arraySize - 1, i)] = scanner.nextInt();
                }
                for (int i = arraySize - r - 4 - 2; i > arraySize - r - 8 - 2; i--) {
                    System.out.println(Math.max(1, i + 1));
                    array[Math.max(0, i)] = scanner.nextInt();
                }
            }

            // Output the final array
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < arraySize; i++) {
                result.append(array[i]);
            }
            System.out.println(result.toString());

            String response = scanner.next();
            if (response.equals("N")) {
                break;
            }
        }
        scanner.close();
    }

    public static void reverseArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }

    public static void complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                array[i] = 1 - array[i];
            }
        }
    }
}