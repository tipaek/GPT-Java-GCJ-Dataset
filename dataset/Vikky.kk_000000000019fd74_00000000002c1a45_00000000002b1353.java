import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int binomialCoeff(int n, int k) {
        int res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    static long sumBinomialCoeff(int n, int k) {
        long sum = 0;
        for (int i = 1; i <= k; ++i) {
            sum += binomialCoeff(n, i);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t_i = 1; t_i <= test; ++t_i) {
            int ans = 0;
            int sum = Integer.parseInt(br.readLine());
            sb.append("Case #" + t_i + ": \n");
            int row = 3, col = 2;
            if (sum == 1) {
                sb.append("1 1\n");
            } else if (sum == 2) {
                sb.append("1 1\n2 1\n");
            } else if (sum == 3) {
                sb.append("1 1\n2 1\n3 1\n");
            } else {
                sb.append("1 1\n2 1\n");
                sum -= 2;
                while (sum > 0) {
                    sb.append(row).append(" ").append(col).append("\n");
                    int val = 1;
                    if (col != 1 && col != row)
                        val = binomialCoeff(row - 1, col - 1);
                    sum -= val;
                    if (sum >= sumBinomialCoeff(row, col - 1)) {
                        if (row % 2 == 0 && sumBinomialCoeff(row, col) < sum) {
                            ++col;
                        }
                        ++row;
                    } else if (col == 1) {
                        ++row;// move down for rest 1s
                    } else {
                        --col;// move left for collecting rest numbers from same row
                    }

                    // sb.append("\n----" + val + "----" + sum + "----\n");
                }
                //sb.append("\n----" + sum + "----\n");
            }
            // sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}