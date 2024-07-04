import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= T; testCase++) {
            int[] a1 = new int[B];
            int[] a2 = new int[B];
            int[] a3 = new int[B];
            int[] a4 = new int[B];

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                int b1 = Integer.parseInt(sc.nextLine());
                a1[i - 1] = b1;
                a2[i - 1] = ~b1;
                a3[i - 1] = a1[B - 1];
                a4[i - 1] = ~a1[B - 1];
            }

            System.out.println(1);
            int b2 = Integer.parseInt(sc.nextLine());
            
            if (processArray(a1, b2, sc) || processArray(a2, b2, sc) || processArray(a3, b2, sc) || processArray(a4, b2, sc)) {
                continue;
            } else {
                break;
            }
        }

        sc.close();
    }

    private static boolean processArray(int[] array, int b2, Scanner sc) {
        if (b2 == array[0]) {
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                s1.append(array[i]);
            }
            System.out.println(s1);
            String output = sc.nextLine();
            return output.equals("Y");
        }
        return false;
    }
}