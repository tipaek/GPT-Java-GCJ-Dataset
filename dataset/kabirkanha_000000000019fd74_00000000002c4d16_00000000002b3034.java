import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            --T;
            ++cnt;
            boolean flag1 = true;
            boolean flag2 = true;
            int N = scanner.nextInt();
            StringBuilder[] arr1 = new StringBuilder[N];
            StringBuilder[] arr2 = new StringBuilder[N];
            for (int i = 0; i < N; ++i) {
                arr1[i] = new StringBuilder();
                arr2[i] = new StringBuilder();
                String temp = scanner.next();
                boolean star_flag = false;
                int post_star = 1;
                int pre_star = 1;
                arr1[i].insert(0, '*');
                arr2[i].insert(0, '*');
                for (int j = 0; j < temp.length(); ++j) {
                    if (temp.charAt(j) == '*')
                        star_flag = true;
                    else if (!star_flag)
                        arr1[i].insert(pre_star++, temp.charAt(j));
                    else
                        arr2[i].insert(post_star++, temp.charAt(j));
                }
                arr1[i].deleteCharAt(0);
                arr2[i].deleteCharAt(0);
                arr2[i].reverse();
            }

            String ans1 = "";
            String ans2 = "";

            StringBuilder final_str2;
            final_str2 = arr2[0];
            for (int i = 1; i < N; ++i) {
                if (final_str2.toString().startsWith(arr2[i].toString())) {
                } else if (arr2[i].toString().startsWith(final_str2.toString())) {
                    final_str2 = arr2[i];
                } else {
                    ans2 = "";
                    flag2 = false;
                    break;
                }
            }
            if (flag2) {
                ans2 = final_str2.reverse().toString();
            }

            StringBuilder final_str1;
            final_str1 = arr2[0];
            for (int i = 1; i < N; ++i) {
                if (final_str1.toString().startsWith(arr2[i].toString())) {
                } else if (arr2[i].toString().startsWith(final_str1.toString())) {
                    final_str1 = arr2[i];
                } else {
                    ans1 = "";
                    flag1 = false;
                    break;
                }
            }
            if (flag1) {
                ans2 = final_str1.toString();
            }

            System.out.print("Case #" + cnt + ": ");
            String ans = ans1 + ans2;
            if (ans.equals(""))
                System.out.println("*");
            else
                System.out.println(ans1 + ans2);
        }
    }
}
