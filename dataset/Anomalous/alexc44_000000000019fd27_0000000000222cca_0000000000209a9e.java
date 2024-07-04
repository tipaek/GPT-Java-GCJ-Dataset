import java.util.Scanner;

public class Solution {

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
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    public static void solve(Scanner scanner, int size) {
        int queryCount = 0;
        int[] guessArray = new int[size];
        int sameIndex = -1;
        int diffIndex = -1;
        int currentIndex = 0;

        while (currentIndex < size / 2) {
            if ((queryCount + 1) % 10 == 1 && queryCount != 0) {
                if (sameIndex != -1 && diffIndex != -1) {
                    System.out.println(sameIndex + 1);
                    if (scanner.nextInt() == guessArray[currentIndex]) {
                        System.out.println(diffIndex + 1);
                        if (scanner.nextInt() != guessArray[diffIndex]) {
                            reverseArray(guessArray);
                        }
                    } else {
                        System.out.println(diffIndex + 1);
                        if (scanner.nextInt() == guessArray[diffIndex]) {
                            reverseArray(guessArray);
                        }
                        complementArray(guessArray);
                    }
                    System.out.println(sameIndex + 1);
                    scanner.nextInt();
                    queryCount += 3;
                } else if (sameIndex == -1) {
                    System.out.println(diffIndex + 1);
                    if (scanner.nextInt() != guessArray[diffIndex]) {
                        complementArray(guessArray);
                    }
                    queryCount++;
                } else {
                    System.out.println(sameIndex + 1);
                    if (scanner.nextInt() != guessArray[currentIndex]) {
                        complementArray(guessArray);
                    }
                    queryCount++;
                }
            } else {
                System.out.println(currentIndex + 1);
                guessArray[currentIndex] = scanner.nextInt();
                System.out.println(size - currentIndex);
                guessArray[size - 1 - currentIndex] = scanner.nextInt();

                if (guessArray[currentIndex] == guessArray[size - 1 - currentIndex]) {
                    sameIndex = currentIndex;
                } else {
                    diffIndex = currentIndex;
                }

                queryCount += 2;
                currentIndex++;
            }
        }

        StringBuilder output = new StringBuilder();
        for (int value : guessArray) {
            output.append(value);
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