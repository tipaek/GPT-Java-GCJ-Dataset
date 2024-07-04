import java.util.*;
import java.io.*;

public class Solution {

    public static int[] invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
        }
        return array;
    }

    public static int[] reverseArray(int[] array) {
        int mid = array.length / 2;
        for (int i = 0; i < mid; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        int arrayLength = Integer.parseInt(tokenizer.nextToken());

        for (int t = 0; t < testCases; t++) {
            int currentIndex = 0;
            boolean isReversed = false;
            int currentTime = 0;
            int flipIndex = -1;
            int nonFlipIndex = -1;
            boolean isComplete = false;
            boolean isBacktracking = false;
            int backtrackIndex = -1;

            int[] array = new int[arrayLength];

            while (!isComplete) {
                if (isReversed) {
                    System.out.println(arrayLength - currentIndex);
                } else {
                    System.out.println(currentIndex);
                }
                System.out.flush();

                int response = Integer.parseInt(reader.readLine());
                if (isReversed && response != array[currentIndex] && flipIndex == -1) {
                    flipIndex = currentIndex;
                } else if (isReversed && response == array[currentIndex] && nonFlipIndex == -1) {
                    nonFlipIndex = currentIndex;
                }

                if (currentTime % 10 == 0) {
                    if (isReversed) {
                        backtrackIndex = currentIndex + 1;
                        isReversed = !isReversed;
                    } else {
                        backtrackIndex = currentIndex;
                        isReversed = !isReversed;
                    }
                    isBacktracking = true;
                    if (flipIndex == -1 && nonFlipIndex == -1) {
                        isBacktracking = false;
                    } else if (flipIndex == -1) {
                        currentIndex--;
                        while (isBacktracking) {
                            System.out.println(currentIndex);
                            System.out.flush();
                            int check = Integer.parseInt(reader.readLine());

                            if (check != array[currentIndex]) {
                                array = invertArray(array);
                            }
                            isBacktracking = false;
                            currentIndex = backtrackIndex;
                            currentTime++;
                        }
                    } else if (nonFlipIndex == -1) {
                        currentIndex = flipIndex;
                        while (isBacktracking) {
                            System.out.println(currentIndex);
                            System.out.flush();
                            int check = Integer.parseInt(reader.readLine());

                            if (check != array[currentIndex]) {
                                array = invertArray(array);
                            }
                            isBacktracking = false;
                            currentIndex = backtrackIndex;
                            currentTime++;
                        }
                    } else {
                        while (isBacktracking) {
                            System.out.println(currentIndex);
                            System.out.flush();
                            int check1 = Integer.parseInt(reader.readLine());

                            System.out.println(nonFlipIndex);
                            System.out.flush();
                            int check2 = Integer.parseInt(reader.readLine());

                            if (check1 == array[currentIndex]) {
                                if (check2 != array[nonFlipIndex]) {
                                    array = invertArray(array);
                                    array = reverseArray(array);
                                }
                            } else {
                                if (check2 != array[nonFlipIndex]) {
                                    array = invertArray(array);
                                } else {
                                    array = reverseArray(array);
                                }
                            }

                            currentTime += 2;
                            isBacktracking = false;
                            currentIndex = backtrackIndex;
                        }
                    }
                } else {
                    isReversed = !isReversed;
                    currentTime++;
                    currentIndex++;
                }

                if (currentIndex == arrayLength / 2) {
                    isComplete = true;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < arrayLength; j++) {
                result.append(array[j]);
            }

            System.out.println(result);

            if (reader.readLine().charAt(0) == 'N') {
                System.exit(0);
            }
        }
    }
}