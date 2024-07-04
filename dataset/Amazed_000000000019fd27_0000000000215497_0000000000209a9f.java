
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in);
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            in = sc.nextLine();
            StringTokenizer ab = new StringTokenizer(in);
            String N = ab.nextToken();
            List<String> nums = new ArrayList<>(N.length());
            for (int index = 0; index < N.length(); index++) {
                String a = "";
                if (index == N.length() - 1) {
                    a = N.substring(index);
                } else {
                    a = N.substring(index, index + 1);
                }
                nums.add(a);
            }
            int paren = 0;

            List<String> sP = new ArrayList<>();
            for (int index = 0; index < nums.size(); index++) {
                int a = Integer.parseInt(nums.get(index));
                int needed = a - paren;
                paren += needed;
                for (int count = 0; count < needed; count++) {
                    sP.add("(");
                }
                Integer tempI = a;
                String tempS = Integer.toString(tempI);
                sP.add(tempS);

                if (index == nums.size() - 1) {
                    for (int count = 0; count < paren; count++) {
                        sP.add(")");
                    }
                } else {
                    int b = Integer.parseInt(nums.get(index + 1));
                    if (a > b) {
                        int c = a - b;
                        paren -= c;
                        for (int count = 0; count < c; count++) {
                            sP.add(")");
                        }

                    }
                }
            }
            String ans = "";
            for (int index = 0; index < sP.size(); index++) {
                ans += sP.get(index);
            }
            out.println("Case #" + (i + 1) + ": " + ans);
        }
        out.close();

    }

}
