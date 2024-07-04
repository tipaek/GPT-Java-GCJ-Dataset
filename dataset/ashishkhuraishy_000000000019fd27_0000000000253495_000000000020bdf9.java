import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            List<List<Integer>> val = new ArrayList<>();

            StringBuilder C = new StringBuilder();
            StringBuilder J = new StringBuilder();

            StringBuilder result = new StringBuilder();

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j2 = 0; j2 < 2; j2++) {
                    temp.add(sc.nextInt());
                }
                val.add(temp);
            }

            C.append(repeatString('F', 1440));
            J.append(repeatString('F', 1440));

            for (int k = 0; k < n; k++) {

                int start = val.get(k).get(0);
                int end = val.get(k).get(1);

                if (!C.substring(start, end).contains("T")) {
                    C.replace(start, end, repeatString('T' ,end - start));
                    result.append("C");
                } else if (!J.substring(start, end).contains("T")) {
                    J.replace(start, end, repeatString('T' ,end - start));
                    result.append("J");
                }else{
                    result.replace(0, result.length(), "IMPOSSIBLE");
                    break;
                }

            }

            System.out.println("Case #" + i + ": " + result);

        }

        sc.close();
    }

    static String repeatString(char c, int n){

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++)  result.append(c);

        return result.toString();

    }
}

