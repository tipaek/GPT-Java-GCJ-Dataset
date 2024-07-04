import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int[] array = new int[B];
            int counter = 0;
            
            while (counter < B) {
                if (counter == 0) {
                    counter = initializeArray(input, array, counter);
                } else {
                    counter = updateArray(input, array, counter, B);
                }
            }
            
            printArray(array, B);
            if (input.next().equals("N")) {
                break;
            }
        }
    }

    private static int initializeArray(Scanner input, int[] array, int counter) {
        for (int j = 0; j < 5; j++) {
            array[counter++] = getInput(input, j + 1);
        }
        for (int j = array.length - 5; j < array.length; j++) {
            array[counter++] = getInput(input, j + 1);
        }
        return counter;
    }

    private static int updateArray(Scanner input, int[] array, int counter, int B) {
        int halfCounter = counter / 2;
        int equalIndex = findEqualIndex(array, halfCounter, B);
        int notEqualIndex = findNotEqualIndex(array, halfCounter, B);
        
        boolean changeEqual = false;
        boolean changeNotEqual = false;
        
        if (equalIndex != -1) {
            changeEqual = checkAndUpdateArray(input, array, equalIndex);
        }
        if (notEqualIndex != -1) {
            changeNotEqual = checkAndUpdateArray(input, array, notEqualIndex);
        }
        
        if (equalIndex == -1 && notEqualIndex == -1) {
            input.next(); // Dummy read
        }
        
        updateArrayValues(array, halfCounter, B, changeEqual, changeNotEqual);
        
        counter = fillArray(input, array, counter, halfCounter, B);
        
        return counter;
    }

    private static int getInput(Scanner input, int position) {
        System.out.println(position);
        return Integer.parseInt(input.next());
    }

    private static int findEqualIndex(int[] array, int halfCounter, int B) {
        for (int j = 0; j < halfCounter; j++) {
            if (array[j] == array[B - j - 1]) {
                return j;
            }
        }
        return -1;
    }

    private static int findNotEqualIndex(int[] array, int halfCounter, int B) {
        for (int j = 0; j < halfCounter; j++) {
            if (array[j] != array[B - j - 1]) {
                return j;
            }
        }
        return -1;
    }

    private static boolean checkAndUpdateArray(Scanner input, int[] array, int index) {
        int value = getInput(input, index + 1);
        return value != array[index];
    }

    private static void updateArrayValues(int[] array, int halfCounter, int B, boolean changeEqual, boolean changeNotEqual) {
        for (int j = 0; j < halfCounter; j++) {
            if (array[j] == array[B - j - 1] && changeEqual) {
                array[j] = array[B - j - 1] = 1 - array[j];
            } else if (array[j] != array[B - j - 1] && changeNotEqual) {
                array[j] = 1 - array[j];
                array[B - j - 1] = 1 - array[B - j - 1];
            }
        }
    }

    private static int fillArray(Scanner input, int[] array, int counter, int halfCounter, int B) {
        for (int j = halfCounter; j < halfCounter + 4 && counter < B; j++) {
            array[counter++] = getInput(input, j + 1);
        }
        for (int j = B - 1 - halfCounter; j > B - 1 - halfCounter - 4 && counter < B; j--) {
            array[counter++] = getInput(input, j + 1);
        }
        return counter;
    }

    private static void printArray(int[] array, int B) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < B; k++) {
            sb.append(array[k]);
        }
        System.out.println(sb.toString());
    }
}