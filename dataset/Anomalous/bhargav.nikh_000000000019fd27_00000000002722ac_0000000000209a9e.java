import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nCases = Integer.parseInt(input[0]);
        int nBits = Integer.parseInt(input[1]);

        for (int i = 1; i <= nCases; i++) {
            if (!solve(i, nBits, br)) {
                break;
            }
        }
    }

    public boolean solve(int caseNo, int nBits, BufferedReader br) throws Exception {
        int[] bits = new int[nBits + 1];
        for (int q = 1, b = 1; q <= 150 && b <= nBits; q++) {
            if (q % 10 == 1) {
                System.out.println(b);
                br.readLine();
                q++;
            }
            System.out.println(b);
            bits[b] = Integer.parseInt(br.readLine());
            b++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= nBits; i++) {
            result.append(bits[i]);
        }
        System.out.println(result);

        return br.readLine().equals("Y");
    }
}