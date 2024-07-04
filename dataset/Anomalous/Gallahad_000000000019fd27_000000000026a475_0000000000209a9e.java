import java.util.Scanner;

class Solution {
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int[] arr = new int[arraySize];
            int index = 1;

            while (index <= 100) {
                System.out.println(index);
                arr[index - 1] = scanner.nextInt();

                if (index == arraySize) {
                    printArray(arr);
                    char response = scanner.next().charAt(0);

                    if (response == 'N') {
                        System.exit(0);
                    } else {
                        break;
                    }
                }
                index++;
            }
        }
    }
}