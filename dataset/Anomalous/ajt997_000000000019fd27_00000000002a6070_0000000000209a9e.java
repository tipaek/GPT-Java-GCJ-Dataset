import java.util.*;
import java.io.*;

public class Vestigium {

    public static int[] flip(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        return arr;
    }

    public static int[] reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            int[] arr = new int[B];
            int currIndex = 0;
            boolean isReverse = false;
            int currentTime = 0;
            int flipIndex = -1;
            int nonFlipIndex = -1;
            boolean isComplete = false;
            boolean isBacktrack = false;
            int backtrackIndex = -1;

            while (!isComplete) {
                if (isReverse) {
                    System.out.println(B - currIndex);
                } else {
                    System.out.println(currIndex + 1);
                }
                System.out.flush();

                int next = Integer.parseInt(reader.readLine());

                if (isReverse) {
                    arr[B - currIndex - 1] = next;
                } else {
                    arr[currIndex] = next;
                }

                if (isReverse && next != arr[currIndex] && flipIndex == -1) {
                    flipIndex = currIndex;
                } else if (isReverse && next == arr[currIndex] && nonFlipIndex == -1) {
                    nonFlipIndex = currIndex;
                }

                if (currentTime % 10 == 0) {
                    if (isReverse) {
                        backtrackIndex = currIndex + 1;
                    } else {
                        backtrackIndex = currIndex;
                    }
                    isReverse = !isReverse;
                    isBacktrack = true;

                    if (flipIndex == -1 && nonFlipIndex == -1) {
                        isBacktrack = false;
                    } else if (flipIndex == -1) {
                        currIndex--;
                        while (isBacktrack) {
                            System.out.println(currIndex + 1);
                            System.out.flush();
                            int check = Integer.parseInt(reader.readLine());

                            if (check != arr[currIndex]) {
                                arr = flip(arr);
                            }
                            isBacktrack = false;
                            currIndex = backtrackIndex;
                            currentTime++;
                        }
                    } else if (nonFlipIndex == -1) {
                        currIndex = flipIndex;
                        while (isBacktrack) {
                            System.out.println(currIndex + 1);
                            System.out.flush();
                            int check = Integer.parseInt(reader.readLine());

                            if (check != arr[currIndex]) {
                                arr = flip(arr);
                            }
                            isBacktrack = false;
                            currIndex = backtrackIndex;
                            currentTime++;
                        }
                    } else {
                        currIndex = flipIndex;
                        while (isBacktrack) {
                            System.out.println(currIndex + 1);
                            System.out.flush();
                            int check1 = Integer.parseInt(reader.readLine());

                            System.out.println(nonFlipIndex + 1);
                            System.out.flush();
                            int check2 = Integer.parseInt(reader.readLine());

                            if (check1 == arr[currIndex]) {
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
                            isBacktrack = false;
                            currIndex = backtrackIndex;
                        }
                    }
                } else {
                    isReverse = !isReverse;
                    if (!isReverse) {
                        currIndex++;
                    }
                }

                if (currIndex == B / 2) {
                    isComplete = true;
                }
                currentTime++;
            }

            StringBuilder result = new StringBuilder();
            for (int j : arr) {
                result.append(j);
            }
            System.out.println(result);

            if (reader.readLine().charAt(0) == 'N') {
                System.exit(0);
            }
        }
    }
}