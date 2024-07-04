import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        int size = sc.nextInt();

        String[] arr = new String[size];
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int additionalSteps = (int)Math.ceil(size / 10) + size%10;

            for (int p = 1, i = 1; p <= size + additionalSteps; p++) {
                System.out.println(i);

                String bit = sc.next();
                if (p % 10 != 1) {
                    arr[i-1] = bit;
                    i++;
                }
            }

            String out = String.join("", arr);
            System.out.println(out);

            String result = sc.next();
            if (result != "Y") {
                System.exit(0);
            }
        }
    }
}