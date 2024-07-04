import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int B = in.nextInt();

        int samplingBudget = 5;
        int samplingFactor = B / samplingBudget;
        List<Integer> samples = new ArrayList<>(samplingBudget);
        for (int i = 0;i<B;i++) {
            if (i%samplingFactor == 0) samples.add(i);
        }

        for (int t = 1; t <= T; ++t) {
            int[] arr = new int[B];
            Arrays.fill(arr, -1);
            int queries = 1;

            for (int sample : samples) {
                System.out.println(sample);
                queries++;
                System.out.flush();
                arr[sample] = in.nextInt();
            }

            boolean shouldContinue = false;

            int i = 0;
            while((queries)%10 != 1) {
                if (i<B && arr[i] == -1 && i%samplingFactor!=0) {
                    System.out.println(i);
                    queries++;
                    System.out.flush();
                    arr[i] = in.nextInt();
                    shouldContinue = true;
                }
                i++;
                if (i>=B) {
                    shouldContinue = false;
                    break;
                }
            }

            if (shouldContinue) {

                while (queries <= 150) {
                    int[] temp = new int[B];
                    for (int sample : samples) {
                        System.out.println(sample);
                        queries++;
                        System.out.flush();
                        temp[sample] = in.nextInt();
                    }

                    int[] t1 = arr;
                    int comp = compScore(arr, temp, samples);

                    int[] complements = complement(arr);
                    int score = compScore(complements, temp, samples);
                    if (score >= comp) {
                        t1 = complements;
                        comp = score;
                    }

                    int[] reversed = reverseCopy(arr);
                    score = compScore(reversed, temp, samples);
                    if (score >= comp) {
                        t1 = reversed;
                        comp = score;
                    }

                    int[] revComped = complement(reversed);
                    score = compScore(revComped, temp, samples);
                    if (score >= comp) {
                        t1 = revComped;
                        comp = score;
                    }

                    arr = t1;

                    i = 0;
                    shouldContinue = false;
                    while((queries)%10 != 1) {
                        if (i<B && arr[i] == -1 && i%samplingFactor!=0) {
                            System.out.println(i);
                            queries++;
                            System.out.flush();
                            arr[i] = in.nextInt();
                            shouldContinue = true;
                        }
                        i++;
                        if (i>B) {
                            shouldContinue = false;
                            break;
                        }
                    }
                    if (!shouldContinue) break;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (i = 0;i<B;i++) {
                builder.append(arr[i]);
            }
            System.out.println(builder.toString());
            System.out.flush();
            if (!in.next().equals("Y")) break;
        }
    }

    private static int compScore(int[] src, int[] target, List<Integer> samples) {
        int score = 0;
        for (int sample : samples) {
            if (src[sample] == target[sample]) score++;
        }
        return score;
    }

    private static int[] complement(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        for(int i = 0;i<arr.length;i++) {
            if (copy[i] == 1) copy[i] = 0;
            else if (copy[i] == 0) copy[i] = 1;
        }
        return copy;
    }

    private static int[] reverseCopy(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = arr.length-1;i>=0;i--) {
            copy[arr.length-1-i] = arr[i];
        }
        return copy;
    }
}