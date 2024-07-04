import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            String[] middle = new String[N];
            String[] left = new String[N];
            String[] right = new String[N];
            String leftMax = "";
            String rightMax = "";
            for (int i=0; i<N; i++) {
                String word = in.next();
                String[] parts = word.split("[*]", -1);

                StringBuilder temp = new StringBuilder();
                for (int j=1; j<parts.length-1; j++) temp.append(parts[j]);
                middle[i] = temp.toString();
                left[i] = parts[0];
                right[i] = parts[parts.length-1];

                if (leftMax.length() < left[i].length()) {
                    leftMax = left[i];
                }
                if (rightMax.length() < right[i].length()) {
                    rightMax = right[i];
                }
            }

            int error = 0;
            StringBuilder middleSequence = new StringBuilder();
            for (int i=0; i<N; i++) {
                if (!leftMax.startsWith(left[i])) {
                    error = 1;
                }
                if (!rightMax.endsWith(right[i])) {
                    error = 1;
                }
                middleSequence.append(middle[i].replace("*", ""));
            }

            System.out.println(String.format("Case #%s: %s", t+1, error == 1 ? "*" : leftMax + middleSequence.toString() + rightMax));
        }
    }
}
