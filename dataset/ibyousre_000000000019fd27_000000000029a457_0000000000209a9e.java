
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
//        System.err.println(b);
        for (int ti = 0; ti < t; ti++) {
//            System.err.println(ti);
            int[] data = new int[b];
            int similarPairIndex = -1, differentPairIndex = -1;
            int nQueries = 0;
            for (int i = 0; i < (b + 1) / 2; i++) {
                if (nQueries % 10 == 0 && (similarPairIndex != -1 || differentPairIndex != -1)) {
                    int similarPairResult = query(Math.max(0, similarPairIndex));
                    int differentPairResutlt = query(Math.max(0, differentPairIndex));
                    nQueries += 2;
                    boolean similarPairChange = similarPairIndex != -1 && data[similarPairIndex] != similarPairResult;
                    boolean differentPairChange = differentPairIndex != -1 && data[differentPairIndex] != differentPairResutlt;
                    boolean flip, reverse;
                    if (similarPairIndex == -1) { // only different pairs
                        if (differentPairChange) {
                            flip = true;
                            reverse = false;
                        } else {
                            flip = reverse = false;
                        }
                    } else if (differentPairIndex == -1) { // only similar pairs
                        if (similarPairChange) {
                            flip = true;
                            reverse = false;
                        } else {
                            flip = reverse = false;
                        }
                    } else {
//                        System.err.println(similarPairChange + "," + differentPairChange);
                        flip = similarPairChange;
                        reverse = similarPairChange ^ differentPairChange;
                    }
                    if (flip) {
                        flip(data);
                    }
                    if (reverse) {
                        reverse(data);
                    }
                    debug(data);
                }
                data[i] = query(i);
                data[b - 1 - i] = query(b - 1 - i);
                nQueries += 2;
                debug(data);
                if (data[i] == data[b - 1 - i]) {
                    similarPairIndex = i;
                } else {
                    differentPairIndex = i;
                }
            }
            String result = Arrays.toString(data).replace(", ", "");
            System.out.println(result.substring(1, result.length() - 1));
            if (!"Y".equals(in.nextLine())) {
                return;
            }
        }
    }

    private static void debug(int[] data) {
//        String result = Arrays.toString(data).replace(", ", "");
//        System.err.println(result.substring(1, result.length() - 1));
    }

    private static void flip(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 - data[i];
        }
    }

    private static void reverse(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            int tmp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = tmp;
        }
    }

    private static int query(int n) {
        System.out.println(n + 1);
        System.out.flush();
        String line = in.nextLine();
//        System.err.println(">>" + (n + 1));
//        System.err.println("<<" + line);
        return Integer.parseInt(line);
    }
}
