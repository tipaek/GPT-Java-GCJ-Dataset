import java.util.Scanner;

public class Solution {
    public static void reverseArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    public static void complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    public static void solve(Scanner scanner, int size) {
        int queryCount = 0;
        int[] array = new int[size];
        int sameIndex = -1;
        int diffIndex = -1;
        int currentIndex = 0;

        while (currentIndex < size / 2) {
            if ((queryCount + 1) % 10 == 1 && queryCount != 0) {
                if (sameIndex != -1 && diffIndex != -1) {
                    System.out.println(sameIndex + 1);
                    if (scanner.nextInt() == array[currentIndex]) {
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
                    if (scanner.nextInt() != array[currentIndex]) {
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

                currentIndex++;
            }
            queryCount += 2;
        }

        StringBuilder output = new StringBuilder();
        for (int value : array) {
            output.append(value);
        }

        System.out.println(output.toString());
        if (scanner.next().equals("Y")) {
            return;
        } else {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int size = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(scanner, size);
        }
    }
}