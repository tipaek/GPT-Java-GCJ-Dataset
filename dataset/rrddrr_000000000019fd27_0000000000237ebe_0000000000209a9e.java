import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int T, int B) {
        int[] arr = new int[B + 1];
        int si=1, ei=arr.length-1;
        int guessNum = 1;
        int sameIdx = -1, diffIdx = -1;

        while (si <= ei) {
            if (guessNum > 10 && guessNum % 10 == 1) {
                updateArr(input, arr, sameIdx, diffIdx, si, ei);
            }
            else {
                System.out.println(si);
                byte sb = Byte.parseByte(input.next());
                System.out.println(ei);
                byte eb = Byte.parseByte(input.next());

                arr[si] = sb;
                arr[ei] = eb;

                if (sameIdx == -1 && sb == eb) {
                    sameIdx = si;
                }
                else if (diffIdx == -1 && sb != eb) {
                    diffIdx = si;
                }

                si++;
                ei--;
            }
            guessNum += 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append(i);
        sb.deleteCharAt(0);
        System.out.println(sb.toString());
    }

    public static void updateArr(Scanner input, int[] arr, int sameIdx, int diffIdx, int si, int ei) {
        // all vals so far are the same
        if (sameIdx == -1 || diffIdx == -1) {
            int oldVal = arr[sameIdx + diffIdx + 1];
            System.out.println(sameIdx + diffIdx + 1);
            int newVal = Byte.parseByte(input.next());

            // throwaway
            System.out.println(1);
            input.next();

            // complement all so far
            if (oldVal != newVal) {
                complement(arr, si);
            }
        }
        else {
            int val1 = arr[sameIdx];
            int val2 = arr[diffIdx];
            System.out.println(sameIdx);
            int newVal1 = Byte.parseByte(input.next());
            System.out.println(diffIdx);
            int newVal2 = Byte.parseByte(input.next());
            if (newVal1 == val1 && newVal2 == val2) {
                // unchanged
            }
            else if (newVal1 != val1 && newVal2 != val2) {
                complement(arr, si);
                // complement
            }
            else if (newVal1 == val1 && newVal2 != val2) {
                reverse(arr, si);
                // reverse
            }
            else if (newVal1 != val1 && newVal2 == val2) {
                complement(arr, si);
                reverse(arr, si);
                // flip and reverse
            }
        }
    }

    public static void complement(int[] arr, int si) {
        for (int i=1; i<si; ++i) {
            arr[i] = arr[i] == 0 ? 1 : 0;
            arr[arr.length - i] = arr[arr.length - i] == 0 ? 1 : 0;
        }
    }

    public static void reverse(int[] arr, int si) {
        for (int i=1; i<si; ++i) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i];
            arr[arr.length - i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            solve(input, T, B);
        }
    }

    // 10
// 01 01 10 10

// 1110
// 0001 0111 1000 1110

// first 10
// second 10

// goal is to find a pair of bits that aren't symmetric- like 11 10
// then we check the '11' to see the values, and we can figure out what happened to the array
// if they are symmetric, like '11 11', we only need to check one to figure out all their values (or 1100)
// 1100
// 0011 0011 1100 1100
    // 11111111110000000000
}