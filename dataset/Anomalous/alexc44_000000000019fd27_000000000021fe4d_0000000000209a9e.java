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

    public static void processQuery(Scanner scanner, int size) {
        int queries = 0;
        int[] array = new int[size];
        int sameIndex = -1;
        int diffIndex = -1;
        int currentIndex = 0;

        while (currentIndex < size / 2) {
            if ((queries + 1) % 10 == 1 && queries != 1) {
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
                } else if (sameIndex == -1) {
                    System.out.println(diffIndex + 1);
                    if (scanner.nextInt() != array[diffIndex]) {
                        complementArray(array);
                    }
                } else {
                    System.out.println(sameIndex + 1);
                    if (scanner.nextInt() != array[currentIndex]) {
                        complementArray(array);
                    }
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
                queries += 2;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value);
        }

        System.out.println(result);
        String response = scanner.next();
        if (!response.equals("Y")) {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int size = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processQuery(scanner, size);
        }
    }
}