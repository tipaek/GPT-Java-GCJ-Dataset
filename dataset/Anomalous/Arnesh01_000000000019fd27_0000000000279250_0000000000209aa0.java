import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);
            StringBuilder ans = new StringBuilder();

            switch (N) {
                case 2:
                    if (K == 2) {
                        ans.append("POSSIBLE\n1 2\n2 1\n");
                    } else if (K == 3) {
                        ans.append("IMPOSSIBLE\n");
                    } else {
                        ans.append("POSSIBLE\n2 1\n1 2\n");
                    }
                    break;
                case 3:
                    if (K == 3) {
                        ans.append("POSSIBLE\n1 2 3\n3 1 2\n2 3 1\n");
                    } else if (K == 4 || K == 5) {
                        ans.append("IMPOSSIBLE\n");
                    } else if (K == 6) {
                        ans.append("POSSIBLE\n3 1 2\n1 2 3\n2 3 1\n");
                    } else if (K == 7 || K == 8) {
                        ans.append("IMPOSSIBLE\n");
                    } else {
                        ans.append("POSSIBLE\n3 1 2\n2 3 1\n1 2 3\n");
                    }
                    break;
                case 4:
                    handleCase4(K, ans);
                    break;
                case 5:
                    handleCase5(K, ans);
                    break;
                default:
                    ans.append("IMPOSSIBLE\n");
                    break;
            }

            sb.append("Case #").append(t).append(": ").append(ans);
        }

        System.out.print(sb);
    }

    private static void handleCase4(int K, StringBuilder ans) {
        switch (K) {
            case 4:
                ans.append("POSSIBLE\n1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1\n");
                break;
            case 5:
                ans.append("IMPOSSIBLE\n");
                break;
            case 6:
                ans.append("POSSIBLE\n1 2 3 4\n2 1 4 3\n3 4 2 1\n4 3 1 2\n");
                break;
            case 7:
                ans.append("POSSIBLE\n1 2 3 4\n3 1 4 2\n4 3 2 1\n2 4 1 3\n");
                break;
            case 8:
                ans.append("POSSIBLE\n2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2\n");
                break;
            case 9:
                ans.append("POSSIBLE\n1 4 2 3\n3 1 4 2\n4 2 3 1\n2 3 1 4\n");
                break;
            case 10:
                ans.append("POSSIBLE\n1 4 2 3\n4 1 3 2\n2 3 4 1\n3 2 1 4\n");
                break;
            case 11:
                ans.append("POSSIBLE\n4 1 3 2\n2 4 1 3\n1 3 2 4\n3 2 4 1\n");
                break;
            case 12:
                ans.append("POSSIBLE\n3 4 1 2\n2 3 4 1\n1 2 3 4\n4 1 2 3\n");
                break;
            case 13:
                ans.append("POSSIBLE\n4 3 1 2\n2 4 3 1\n3 1 2 4\n1 2 4 3\n");
                break;
            case 14:
                ans.append("POSSIBLE\n3 4 1 2\n4 3 2 1\n1 2 4 3\n2 1 3 4\n");
                break;
            case 15:
                ans.append("IMPOSSIBLE\n");
                break;
            default:
                ans.append("POSSIBLE\n4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4\n");
                break;
        }
    }

    private static void handleCase5(int K, StringBuilder ans) {
        switch (K) {
            case 5:
                ans.append("POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n");
                break;
            case 10:
                ans.append("POSSIBLE\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n");
                break;
            case 15:
                ans.append("POSSIBLE\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n");
                break;
            case 20:
                ans.append("POSSIBLE\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n");
                break;
            case 25:
                ans.append("POSSIBLE\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n");
                break;
            case 6:
            case 24:
                ans.append("IMPOSSIBLE\n");
                break;
            case 7:
                ans.append("POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n2 4 1 5 3\n3 5 4 2 1\n4 3 5 1 2\n");
                break;
            case 23:
                ans.append("POSSIBLE\n5 4 3 2 1\n1 5 4 3 2\n4 2 5 1 3\n3 1 2 4 5\n2 3 1 5 4\n");
                break;
            case 8:
                ans.append("POSSIBLE\n2 1 3 4 5\n5 2 1 3 4\n1 4 2 5 3\n3 5 4 1 2\n4 3 5 2 1\n");
                break;
            case 22:
                ans.append("POSSIBLE\n4 5 3 2 1\n1 4 5 3 2\n5 2 4 1 3\n3 1 2 5 4\n2 3 1 4 5\n");
                break;
            case 9:
                ans.append("POSSIBLE\n1 3 2 4 5\n5 1 3 2 4\n3 4 1 5 2\n2 5 4 3 1\n4 2 5 1 3\n");
                break;
            case 21:
                ans.append("POSSIBLE\n5 3 4 2 1\n1 5 3 4 2\n3 2 5 1 4\n4 1 2 3 5\n2 4 1 5 3\n");
                break;
            case 11:
                ans.append("POSSIBLE\n1 4 3 2 5\n5 1 4 3 2\n4 2 1 5 3\n3 5 2 4 1\n2 3 5 1 4\n");
                break;
            case 19:
                ans.append("POSSIBLE\n5 2 3 4 1\n1 5 2 3 4\n2 4 5 1 3\n3 1 4 2 5\n4 3 1 5 2\n");
                break;
            case 13:
                ans.append("POSSIBLE\n1 5 3 4 2\n2 1 5 3 4\n5 4 1 2 3\n3 2 4 5 1\n4 3 2 1 5\n");
                break;
            case 17:
                ans.append("POSSIBLE\n5 1 3 2 4\n4 5 1 3 2\n1 2 5 4 3\n3 4 2 1 5\n2 3 4 5 1\n");
                break;
            case 12:
                ans.append("POSSIBLE\n2 3 1 4 5\n5 2 3 1 4\n3 4 2 5 1\n1 5 4 3 2\n4 1 5 2 3\n");
                break;
            case 18:
                ans.append("POSSIBLE\n4 3 5 2 1\n1 4 3 5 2\n3 2 4 1 5\n5 1 2 3 4\n2 5 1 4 3\n");
                break;
            case 14:
                ans.append("POSSIBLE\n2 4 3 1 5\n5 2 4 3 1\n4 1 2 5 3\n3 5 1 4 2\n1 3 5 2 4\n");
                break;
            default:
                ans.append("POSSIBLE\n4 2 3 5 1\n1 4 2 3 5\n2 5 4 1 3\n3 1 5 2 4\n5 3 1 4 2\n");
                break;
        }
    }
}