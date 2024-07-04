import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = Integer.parseInt(inp.nextLine());
        int k=t;
        while (k-- > 0) {
            char[] s = inp.nextLine().toCharArray();
            int[] arr = new int[s.length];
            for (int i=0; i<s.length; i++) {
                arr[i] = Character.getNumericValue(s[i]);
            }
            int dep = 0;
            String ans = "";
            for (int i=0; i<arr.length; i++) {
                if (dep == arr[i]) ans += arr[i];
                else if (dep > arr[i]) {
                    while(dep > arr[i]) {
                        ans += ")";
                        dep--;
                    }
                    ans += arr[i];
                }
                else if (dep < arr[i]) {
                    while(dep < arr[i]) {
                        ans += "(";
                        dep++;
                    }
                    ans += arr[i];
                }
            }
            while(dep > 0) {
                ans += ")";
                dep--;
            }
            System.out.println("Case #" + (t-k) + ": " + ans);
        }
    }
}