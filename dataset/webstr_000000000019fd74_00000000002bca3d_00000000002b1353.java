import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int n = in.nextInt();
            List<Integer> res1 = new ArrayList<>();
            List<Integer> res2 = new ArrayList<>();
            int sumk = 0;
            List<Integer> tr = new ArrayList<>();
            tr.add(1);
            int sum = sum(tr);
            int k = 1;
            boolean start = true;

            if (n > 501) {
                for (int i = 0; i < 8; i++) {
                    res1.add(k);
                    res2.add(1);
                    sumk++;
                    k++;
                    tr = buildNext(tr);
                }
                sum = sum(tr);
            }

            while (sumk + sum <= n) {
                sumk += sum;
                for (int i = 0; i < tr.size(); i++) {
                    res1.add(k);
                    if (start) {
                        res2.add(i + 1);
                    } else {
                        res2.add(tr.size() - i);
                    }
                }
                tr = buildNext(tr);
                start = !start;
                k++;
                sum = sum(tr);
            }

            while (sumk < n) {
                res1.add(k);
                if (start) {
                    res2.add(1);
                } else {
                    res2.add(k);
                }
                sumk++;
                k++;
            }

            System.out.print("Case #" + t + ":" + toString(res1, res2));
        }
    }

    public static String toString(List<Integer> res1, List<Integer> res2) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < res1.size(); i++) {
            stringBuilder.append(res1.get(i)).append(" ").append(res2.get(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    public static List<Integer> buildNext(List<Integer> tr) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < tr.size() - 1; i++) {
            res.add(tr.get(i) + tr.get(i + 1));
        }
        res.add(1);
        return res;
    }

    public static int sum(List<Integer> tr) {
        int sum = 0;
        for (Integer i : tr) {
            sum += i;
        }
        return sum;
    }
}