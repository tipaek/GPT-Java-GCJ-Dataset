import java.util.Scanner;

public class Solution {

    private static void reverseArray(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = temp;
        }
    }

    private static void complementArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }

    private static void solve(Scanner scanner, int size) {
        int queryCount = 0;
        int[] array = new int[size];
        int sameIndex = -1;
        int diffIndex = -1;
        int currentIndex = 0;

        while (currentIndex < size / 2) {
            if ((queryCount + 1) % 10 == 1 && queryCount != 0) {
                if (sameIndex != -1 && diffIndex != -1) {
                    System.out.println(sameIndex + 1);
                    if (scanner.nextInt() == array[sameIndex]) {
                        System.out.println(diffIndex + 1);
                        if (scanner.nextInt() != array[diffIndex]) {
                            reverseArray(array);
                        }
                    } else {
                        System.out.println(diffIndex + 1);
                        if (scanner.nextInt() == array[diffIndex]) {
                            reverseArray(array);
                        }
                        complementArray(array);
                    }
                    System.out.println(sameIndex + 1);
                    scanner.nextInt();
                    queryCount += 3;
                } else if (sameIndex == -1) {
                    System.out.println(diffIndex + 1);
                    if (scanner.nextInt() != array[diffIndex]) {
                        complementArray(array);
                    }
                    queryCount++;
                } else {
                    System.out.println(sameIndex + 1);
                    if (scanner.nextInt() != array[sameIndex]) {
                        complementArray(array);
                    }
                    queryCount++;
                }
            } else {
                System.out.println(currentIndex + 1);
                array[currentIndex] = scanner.nextInt();
                System.out.println(size - currentIndex);
                array[size - 1 - currentIndex] = scanner.nextInt();

                if (array[currentIndex] == array[size - 1 - currentIndex]) {
                    sameIndex = currentIndex;
                } else {
                    diffIndex = currentIndex;
                }

                queryCount += 2;
                currentIndex++;
            }
        }

        StringBuilder output = new StringBuilder();
        for (int num : array) {
            output.append(num);
        }

        System.out.println(output);
        String response = scanner.next();
        if (!response.equals("Y")) {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(scanner, arraySize);
        }
    }
}