import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static int[] reverseArray(int[] array, int size) {
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        return array;
    }

    public static int[] toggleBits(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value);
        }
        System.out.println();
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int[] array = new int[b];
            int last = -1;
            int recent = b;
            int diffIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int diffValue = -1;
            boolean continueLoop = true;
            boolean diffChecked = true;
            boolean sameChecked = true;
            boolean diffChanged = false;
            boolean sameChanged = false;

            for (int i = -1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    continueLoop = false;
                    if (diffIndex != -1) diffChecked = false;
                    if (sameIndex != -1) sameChecked = false;
                    diffChanged = false;
                    sameChanged = false;
                }

                if (!continueLoop) {
                    if (!diffChecked) {
                        diffChecked = true;
                        System.out.println(diffIndex + 1);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (value != diffValue) {
                            diffChanged = true;
                            diffValue = value;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        System.out.println(sameIndex + 1);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (value != sameValue) {
                            sameChanged = true;
                            sameValue = value;
                        }
                    } else {
                        if (!diffChanged && sameChanged) {
                            array = toggleBits(array, b);
                            array = reverseArray(array, b);
                        } else if (diffChanged && !sameChanged) {
                            array = reverseArray(array, b);
                        } else if (diffChanged && sameChanged) {
                            array = toggleBits(array, b);
                        }
                        continueLoop = true;
                    }
                }

                if (continueLoop) {
                    if (recent == last) {
                        recent = b - 1 - last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        array[recent] = scanner.nextInt();
                        if (diffIndex == -1 && array[last] != array[recent]) {
                            diffIndex = last;
                            diffValue = array[diffIndex];
                        }
                        if (sameIndex == -1 && array[last] == array[recent]) {
                            sameIndex = last;
                            sameValue = array[sameIndex];
                        }
                    } else if (recent == b - 1 - last) {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        array[recent] = scanner.nextInt();
                    }
                }

                if (continueLoop && recent == b / 2) {
                    printArray(array);
                    break;
                }
            }

            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }
}