import java.util.Scanner;

public class Solution {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String res = "";
        for (int t = 1; t <= T; t++) {
            String input = sc.nextLine();
            int[] arr = new int[input.length()];
            int i=0;
            while (i<input.length()) {
                arr[i] = Integer.parseInt(input.charAt(i++) + "");
            }
            int level = 0;

            String result = "";
            for (i = 0; i < arr.length; ) {
                int a = arr[i];
                if (level < a) {
                    while (level<a){
                        result += "(";
                        level++;
                    }
                } else if (level>a){
                    while (level>a){
                        result += ")";
                        level--;
                    }
                }
                result += arr[i];
                i++;
            }
            for (i = 0; i < level; i++) result += ")";
            res += "Case #" + t + ": " + result;
            if (t != T) res += "\n";
        }
        System.out.print(res);
    }
}