import java.io.*;
import java.util.*;

public class Solution
{
    public static void solve10(Scanner in) {
        int B = 10;
        boolean[] result = new boolean[B];
        for (int i = 0; i < B; i++)
        {
            System.out.println(i + 1);
            result[i] = in.nextInt() == 1;
        }
        String ans = "";
        for (boolean b : result)
        {
            ans += b ? "1" : "0";
        }
        System.out.println(ans);
    }
    public static void solve(int B, Scanner in) {
        boolean[] arr = new boolean[B];
        Arrays.fill(arr, false);
        boolean R = false;
        boolean C = false;

        int sMarker = -1;
        int dMarker = -1;
        int fluctuate = 10;
        for (int i = 0; i < B / 2; i++)
        {
            if (fluctuate == 0) {
                if (sMarker != -1 && dMarker != -1) {
                    boolean dSame;
                    System.out.println(sMarker + 1);
                    C = arr[sMarker] != (in.nextInt() == 1);
                    System.out.println(dMarker + 1);
                    dSame = (arr[dMarker]) == (in.nextInt() == 1);
                    if (dSame) {
                        R = C;
                    } else {
                        R = !C;
                    }
                } else if (sMarker != -1) {
                    System.out.println(sMarker + 1);
                    C = arr[sMarker] != (in.nextInt() == 1);
                    System.out.println(1);
                    in.nextInt();
                } else {
                    System.out.println(dMarker + 1);
                    R = arr[dMarker] != (in.nextInt() == 1);
                    System.out.println(1);
                    in.nextInt();
                }
                fluctuate = 8;
            }
            boolean left, right;
            System.out.println(i + 1);
            left = in.nextInt() == 1;
            System.out.println(B - i);
            right = in.nextInt() == 1;
            if (left == right) {
                if (sMarker == -1) {
                    sMarker = i;
                }
            } else {
                if (dMarker == -1) {
                    dMarker = i;
                }
            }
            if (C) {
                left = !left;
                right = !right;
            }
            if (R) {
                boolean temp = left;
                left = right;
                right = temp;
            }
            arr[i] = left;
            arr[B - 1 - i] = right;
            fluctuate -= 2;
        }
        String result = "";
        for (int i = 0; i < B; i++)
        {
            int index = R ? B - i - 1 : i;
            if (arr[index] != C) {
                result += "1";
            } else {
                result += "0";
            }
        }
        System.out.println(result);
        in.nextLine();
        in.nextLine();
    }
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new FileReader("in.txt"));

        int T = in.nextInt();
        int B = in.nextInt();
        for (int t = 0; t < T; t++)
        {
            if (B == -1) {
                solve10(in);
            } else {
                solve(B, in);
            }
        }

        in.close();
    }
}
