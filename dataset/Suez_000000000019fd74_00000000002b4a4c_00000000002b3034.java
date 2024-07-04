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
                String[] str = in.next().split("[*]");
                left[i] = str[0];
                right[i] = str[1];
                if (leftMax.length() < left[i].length()) {
                    leftMax = left[i];
                }
                if (rightMax.length() < right[i].length()) {
                    rightMax = right[i];
                }
            }

            int error = 0;
            for (int i=0; i<N; i++) {
                int leftPadding = leftMax.length() - left[i].length();
                for (int j=leftPadding; j<leftMax.length(); j++) {
                    if (leftMax.charAt(j) != left[i].charAt(j-leftPadding)) {
                        error = 1;
                    }
                }

                for (int j=0; j<right[i].length(); j++) {
                    if (rightMax.charAt(j) != right[i].charAt(j)) {
                        error = 1;
                    }
                }
            }

            System.out.println(String.format("Case #%s: %s", t+1, error == 1 ? "*" : leftMax + rightMax));
        }
    }
}
