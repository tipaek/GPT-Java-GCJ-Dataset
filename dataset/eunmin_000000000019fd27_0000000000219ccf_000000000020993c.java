public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            for (int row = 0; row < n; row++) {
                int value = in.nextInt();
                System.out.println(value);
            }
            int k = 0;
            int r = 0;
            int c = 0;
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}