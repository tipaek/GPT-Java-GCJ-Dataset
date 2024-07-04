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

    public static void solve(Scanner input, int size) {
        int queryCount = 0;
        int[] guessArray = new int[size];
        int sameIndex = -1;
        int diffIndex = -1;
        int currentIndex = 0;

        while (currentIndex < size / 2) {
            if ((queryCount + 1) % 10 == 1 && queryCount != 1) {
                if (sameIndex != -1 && diffIndex != -1) {
                    System.out.println(sameIndex + 1);
                    if (input.nextInt() == guessArray[currentIndex]) {
                        System.out.println(diffIndex + 1);
                        if (input.nextInt() != guessArray[diffIndex]) {
                            reverseArray(guessArray);
                        }
                    } else {
                        System.out.println(diffIndex + 1);
                        if (input.nextInt() == guessArray[diffIndex]) {
                            reverseArray(guessArray);
                        }
                        complementArray(guessArray);
                    }
                } else if (sameIndex == -1) {
                    System.out.println(diffIndex + 1);
                    if (input.nextInt() != guessArray[diffIndex]) {
                        complementArray(guessArray);
                    }
                } else {
                    System.out.println(sameIndex + 1);
                    if (input.nextInt() != guessArray[currentIndex]) {
                        complementArray(guessArray);
                    }
                }
            } else {
                System.out.println(currentIndex + 1);
                guessArray[currentIndex] = input.nextInt();
                System.out.println(size - currentIndex);
                guessArray[size - 1 - currentIndex] = input.nextInt();

                if (guessArray[currentIndex] == guessArray[size - 1 - currentIndex]) {
                    sameIndex = currentIndex;
                } else {
                    diffIndex = currentIndex;
                }

                currentIndex++;
                queryCount += 2;

                for (int i = 0; i < 200; i++) {
                    System.out.println("1");
                    input.nextInt();
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for (int value : guessArray) {
            output.append(value);
        }

        System.out.println(output);
        String result = input.next();
        if (!result.equals("Y")) {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        int arraySize = input.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(input, arraySize);
        }
    }
}