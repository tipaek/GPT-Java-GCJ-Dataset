import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] firstLine = sc.nextLine().split(" ");
        int T = Integer.parseInt(firstLine[0]);
        int B = Integer.parseInt(firstLine[1]);
        int[] actual = {0, 0, 0, 0, 1, 0, 0, 1, 1, 1};

        for (int testCase = 1; testCase <= T; testCase++) {          
            int[] arr = new int[B];
            for (int i = 0; i < B; i++) {
                arr[i] = -1;
            }
            
            for (int i = 0; i < B; i++) {
                System.out.println(i + 1);
                arr[i] = Integer.parseInt(sc.nextLine());
            }
            
            String result = "";
            for (int i = 0; i < B; i++) {
                result += arr[i];
            }
            System.out.println(result);

            String response = sc.nextLine();
            if (!response.equals("Y")) {
                System.exit(0);
            }
        }
    }
}
