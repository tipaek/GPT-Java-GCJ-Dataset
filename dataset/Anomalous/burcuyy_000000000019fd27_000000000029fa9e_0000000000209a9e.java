import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    
    public static int[] reverseArray(int[] array, int length) {
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
        return array;
    }

    public static int[] complementArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
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
        int numberOfTestCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int[] array = new int[arraySize];
            int lastIndex = -1;
            int currentIndex = arraySize;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueProcess = true;
            boolean differentIndexChecked = true;
            boolean sameIndexChecked = true;
            boolean differentIndexChanged = false;
            boolean sameIndexChanged = false;
            
            for (int i = 1; i <= 150; i++) {
                if (i % 10 == 0) {
                    continueProcess = false;
                    if (differentIndex != -1) differentIndexChecked = false;
                    if (sameIndex != -1) sameIndexChecked = false;
                    differentIndexChanged = false;
                    sameIndexChanged = false;
                }
                
                if (!continueProcess) {
                    if (!differentIndexChecked) {
                        differentIndexChecked = true;
                        System.out.println(differentIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != differentValue) {
                            differentIndexChanged = true;
                            differentValue = response;
                        }
                    } else if (!sameIndexChecked) {
                        sameIndexChecked = true;
                        System.out.println(sameIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != sameValue) {
                            sameIndexChanged = true;
                            sameValue = response;
                        }
                    } else {
                        if (!differentIndexChanged && sameIndexChanged) {
                            array = complementArray(array, arraySize);
                            array = reverseArray(array, arraySize);
                        } else if (differentIndexChanged && !sameIndexChanged) {
                            array = reverseArray(array, arraySize);
                        } else if (differentIndexChanged && sameIndexChanged) {
                            array = complementArray(array, arraySize);
                        }
                        continueProcess = true;
                    }
                }
                
                if (continueProcess) {
                    if (currentIndex == lastIndex) {
                        currentIndex = arraySize - 1 - lastIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        array[currentIndex] = scanner.nextInt();
                        if (differentIndex == -1 && array[lastIndex] != array[currentIndex]) {
                            differentIndex = lastIndex;
                            differentValue = array[differentIndex];
                        }
                        if (sameIndex == -1 && array[lastIndex] == array[currentIndex]) {
                            sameIndex = lastIndex;
                            sameValue = array[sameIndex];
                        }
                    } else if (currentIndex == arraySize - 1 - lastIndex) {
                        lastIndex++;
                        currentIndex = lastIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        array[currentIndex] = scanner.nextInt();
                    }
                }
                
                if (continueProcess && currentIndex == arraySize / 2) {
                    printArray(array);
                    break;
                }
            }
            
            String result = scanner.next();
            if (result.equals("N")) break;
        }
    }
}