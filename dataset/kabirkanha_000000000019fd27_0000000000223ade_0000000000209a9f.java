import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            --T;
            ++cnt;
            String str = scanner.next();
            int arr[] = new int[str.length()];
            for (int i = 0; i < str.length(); ++i) {
                arr[i] = str.charAt(i) - '0';
            }
            int open = 0;
            String ans = "";
            for (int i = 0; i < arr.length; ++i) {
                int add = arr[i] - open;
                if (add >= 0) {
                    for (int j = 0; j < add; ++j) {
                        ans += "(";
                        open++;
                    }
                    ans+=arr[i];
                } else {
                    for (int j = 0; j > add; --j) {
                        ans += ")";
                        open--;
                    }
                    ans+=arr[i];
                }
            }
            for (int i=0;i<open;++i)
                ans+=")";
            System.out.println("Case #"+cnt+": "+ans);
        }
    }
}
