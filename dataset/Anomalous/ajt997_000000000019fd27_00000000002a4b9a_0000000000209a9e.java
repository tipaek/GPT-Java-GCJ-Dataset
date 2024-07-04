import java.util.*;
import java.io.*;

public class Solution {

    private static int[] flip(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        return arr;
    }

    private static int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int T = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());

        for (int t = 0; t < T; t++) {
            int[] arr = new int[B];
            int currentIdx = 0;
            boolean needDirection = false;
            int currentTime = 0;
            int flipIndex = -1;
            int nonFlipIndex = -1;
            boolean isComplete = false;
            boolean isBacktracking = false;
            int backtrackIdx = -1;

            while (!isComplete) {
                if (needDirection) {
                    System.out.println(B - currentIdx);
                } else {
                    System.out.println(currentIdx + 1);
                }
                System.out.flush();

                int nextValue = Integer.parseInt(reader.readLine());

                if (needDirection && nextValue != arr[currentIdx] && flipIndex == -1) {
                    flipIndex = currentIdx;
                } else if (needDirection && nextValue == arr[currentIdx] && nonFlipIndex == -1) {
                    nonFlipIndex = currentIdx;
                }

                if (currentTime % 10 == 0) {
                    if (needDirection) {
                        backtrackIdx = currentIdx + 1;
                    } else {
                        backtrackIdx = currentIdx;
                    }
                    needDirection = !needDirection;
                    isBacktracking = true;

                    if (flipIndex == -1 && nonFlipIndex == -1) {
                        isBacktracking = false;
                    } else if (flipIndex == -1) {
                        currentIdx--;
                        while (isBacktracking) {
                            System.out.println(currentIdx + 1);
                            System.out.flush();
                            int check = Integer.parseInt(reader.readLine());
                            if (check != arr[currentIdx]) {
                                arr = flip(arr);
                            }
                            isBacktracking = false;
                            currentIdx = backtrackIdx;
                            currentTime++;
                        }
                    } else if (nonFlipIndex == -1) {
                        currentIdx = flipIndex;
                        while (isBacktracking) {
                            System.out.println(currentIdx + 1);
                            System.out.flush();
                            int check = Integer.parseInt(reader.readLine());
                            if (check != arr[currentIdx]) {
                                arr = flip(arr);
                            }
                            isBacktracking = false;
                            currentIdx = backtrackIdx;
                            currentTime++;
                        }
                    } else {
                        currentIdx = flipIndex;
                        while (isBacktracking) {
                            System.out.println(currentIdx + 1);
                            System.out.flush();
                            int check1 = Integer.parseInt(reader.readLine());

                            System.out.println(nonFlipIndex + 1);
                            System.out.flush();
                            int check2 = Integer.parseInt(reader.readLine());

                            if (check1 == arr[currentIdx]) {
                                if (check2 != arr[nonFlipIndex]) {
                                    arr = flip(arr);
                                    arr = reverse(arr);
                                }
                            } else {
                                if (check2 != arr[nonFlipIndex]) {
                                    arr = flip(arr);
                                } else {
                                    arr = reverse(arr);
                                }
                            }
                            currentTime += 2;
                            isBacktracking = false;
                            currentIdx = backtrackIdx;
                        }
                    }
                } else {
                    needDirection = !needDirection;
                    currentTime++;
                    if (!needDirection) {
                        currentIdx++;
                    }
                }

                if (currentIdx == B / 2) {
                    isComplete = true;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < B; j++) {
                result.append(arr[j]);
            }
            System.out.println(result);
            System.out.flush();

            if (reader.readLine().charAt(0) == 'N') {
                System.exit(0);
            }
        }
    }
}