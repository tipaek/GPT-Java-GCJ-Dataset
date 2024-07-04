import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        int testCases = Integer.parseInt(str.nextToken());
        int caseNumber = 1;

        while (testCases-- > 0) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            char[] arr = new char[10];

            for (int i = 0; i < 10000; i++) {
                str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                char ch = str.nextToken().charAt(0);
                if (x < 10) {
                    arr[x] = ch;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                result.append(arr[i]);
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }
}