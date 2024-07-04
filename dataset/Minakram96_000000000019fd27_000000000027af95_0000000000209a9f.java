import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static String y = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            y = "";
//            int n = in.nextInt();
            solve(in);
            int temp = i + 1;
            System.out.println("Case #" + temp + ": " + y);
        }
    }

    private static void solve(Scanner in) {
        int nob = 0;
        String[] input = in.next().split("(?!^)");
        List<Integer> numbersArrays = new LinkedList<>();
        Arrays.stream(input).forEach(i -> {
            int v = Integer.parseInt(i);
            numbersArrays.add(v);
        });
        Iterator<Integer> it = numbersArrays.iterator();

        while (it.hasNext()) {
            int num = it.next();
            if (nob > num) {
                addClosingBrackets(nob - num);
                nob = num;
            }
            if (nob < num) {
                addOpeningBrackets(num - nob);
                nob = num;
            }
            y = y.concat(num + "");
        }
        addClosingBrackets(nob);
    }

    private static void addOpeningBrackets(int n) {
        for (int i = 0; i < n; i++) {
            y += "(";
        }
    }

    private static void addClosingBrackets(int n) {
        for (int i = 0; i < n; i++) {
            y += ")";
        }
    }
}
