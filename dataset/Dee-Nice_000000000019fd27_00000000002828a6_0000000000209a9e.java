import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        int b = scan.nextInt();
        scan.nextLine();
        for (int i = 1; i <= t; i++) {
            solve(scan, b);
        }
    }

    static void solve(Scanner scan, int b) {
        int[] arr = new int[b];
        int arrPos = 0;
        for (int i = 1; i <= 150; i++) {
            if (arrPos >= b) {
                break;
            }
            arr[arrPos] = query(scan, (arrPos + 1));
            if (i % 10 != 1) {
                arrPos++;
            }
            else {
                arr[arrPos] = query(scan, (arrPos + 1));
                arrPos++;
                i++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < b; i++) {
            ans.append(arr[i]);
        }
        System.out.println(ans.toString());
        System.out.flush();
        scan.next();
    }

    static int query(Scanner scan, int pos) {
        System.out.println(pos);
        System.out.flush();
        return scan.nextInt();
    }
}