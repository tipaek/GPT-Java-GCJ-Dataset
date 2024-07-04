public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            String S = in.next();
            int n = 0;
            StringBuilder r = new StringBuilder();
            for (char c : S.toCharArray()) {
                int v = Character.getNumericValue(c);
                if (n == v) {
                    //Nothing to do
                } else if (n < v) {
                    n++;
                    r.append('(');
                } else if (n > v) {
                    n--;
                    r.append(')');
                }
                r.append(c);
            }
            //close all
            for (int i = 0; i < n; i++) {
                r.append(')');
            }

            System.out.println("Case #" + t + ": " + r.toString());
        }
    }
}