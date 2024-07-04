import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        int T = scanIn.nextInt();
        String buffer = scanIn.nextLine();
        String[] results = new String[T];

        for (int x=0; x<T; x++) {
            String S = scanIn.nextLine();
            String Sx = " ";
            for (int i=0; i<S.length(); i++) {
                if (Character.isDigit(S.charAt(i))) {
                    int depth = getCurrentDepth(Sx);
                    int digit = Integer.parseInt(Character.toString(S.charAt(i)));
                    if (depth == digit) {
                        Sx += digit;
                    } else if (depth < digit) {
                        for (int j=0; j<(digit-depth); j++){
                            Sx += "(";
                        }
                        Sx += digit;
                    } else if (depth > digit) {
                        for (int j=0; j<(depth-digit); j++){
                            Sx += ")";
                        }
                        Sx += digit;
                    }
                }
            }
            int depth = getCurrentDepth(Sx);
            if (depth > 0) {
                for (int j=0; j<depth; j++){
                    Sx += ")";
                }
            }
            results[x] = Sx;
        }
        for (int x=1; x<=T; x++) {
            System.out.printf("Case #%d: %s\n", x, results[x-1]);
        }

    }

    public static int getCurrentDepth(String s) {
        if (s == null) return 0;
        int open = 0;
        int closed = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') closed++;
        }
        return (open - closed);
    }
}
