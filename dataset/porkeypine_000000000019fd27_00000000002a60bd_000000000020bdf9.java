public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] output = new String[t];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] in = new int[n][2];
            String out = "";
            for (int j = 0; j < n; j++) {
                in[j][0] = sc.nextInt();
                in[j][1] = sc.nextInt();
            }
            int[] C = new int[]{0, 0};
            int[] J = new int[]{0, 0};
            Arrays.sort(in);
            for (int j = 0; j < n; j++) {
                int[] curr = in[j];
                if (curr[0] >= C[1]) {
                    C = curr;
                    out += "C";
                } else if (curr[0] >= J[1]) {
                    J = curr;
                    out += "J";
                } else {
                    out = "IMPOSSIBLE";
                    break;
                }
            }
            output[i] = out;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(String.format("Case #%d: %s",
                    i + 1, output[i]));
        }
    }
}