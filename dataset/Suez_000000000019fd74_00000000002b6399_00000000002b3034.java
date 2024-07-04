import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            String[] left = new String[N];
            String[] right = new String[N];
            String leftMax = "";
            String rightMax = "";
            for (int i=0; i<N; i++) {
                String[] str = in.next().split("[*]", 0);
                left[i] = str[0];
                right[i] = str.length <2 ? "" : str[1];
                if (leftMax.length() < left[i].length()) {
                    leftMax = left[i];
                }
                if (rightMax.length() < right[i].length()) {
                    rightMax = right[i];
                }
            }

            int error = 0;
            for (int i=0; i<N; i++) {
                if (!leftMax.startsWith(left[i])) {
                    error = 1;
                }
                if (!rightMax.endsWith(right[i])) {
                    error = 1;
                }
            }

            System.out.println(String.format("Case #%s: %s", t+1, error == 1 ? "*" : leftMax + rightMax));
        }
    }
}
