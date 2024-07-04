import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static void reverse(char[] output) {
        for (int i = 0; i < output.length / 2; i++) {
            char temp = output[i];
            output[i] = output[output.length - 1 - i];
            output[output.length - 1 - i] = temp;
        }
    }

    static void flip(char[] output) {
        for (int i = 0; i < output.length; i++) {
            if (output[i] == '_') continue;
            if (output[i] == '1') {
                output[i] = '0';
            } else if (output[i] == '0') {
                output[i] = '1';
            }
        }
    }

    public static boolean solve(Scanner input, int B) {
        char[] output = new char[B];
        Arrays.fill(output, '_');
        Set<Integer> same = new HashSet<>();
        Set<Integer> different = new HashSet<>();
        int start = 0;
        int end = B - 1;
        for (int i = 0; i < 75; i++) {
            if (i % 5 == 0) {
                if (same.size() > 0) {
                    int index = same.iterator().next();
                    System.out.println(index + 1);
                    char s = input.next().charAt(0);
                    if (s != output[index]) {
                        flip(output);
                    }
                } else {
                    System.out.println(1);
                    input.next().charAt(0);
                }

                if (different.size() > 0) {
                    int index = different.iterator().next();
                    System.out.println(index + 1);
                    char s = input.next().charAt(0);
                    if (s != output[index]) {
                        reverse(output);
                    }
                } else {
                    System.out.println(1);
                    input.next().charAt(0);
                }


            } else {
                System.out.println(start + 1);
                char s = input.next().charAt(0);
                System.out.println(end + 1);
                char e = input.next().charAt(0);
                if (s == e) {
                    same.add(start);
                    same.add(end);
                } else {
                    different.add(start);
                    different.add(end);
                }
                output[start] = s;
                output[end] = e;
                start++;
                end--;
                if (start > end) {
                    start = 0;
                    end = B - 1;
                }
            }
        }
        System.out.println(output);
        return (input.next().charAt(0) == 'Y');
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int tc = 0; tc < T; tc++) {
            if (!solve(input, B)) break;
        }
    }
}