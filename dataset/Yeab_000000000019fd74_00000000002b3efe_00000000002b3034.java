
import java.util.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    public static String check(List<String> strings) {
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (int i = 1; i < strings.size(); i++) {
            if (!strings.get(i).startsWith(strings.get(i-1))) {
                return null;
            }
        }

        return strings.get(strings.size() - 1);

    }


    public static void main(String[] args) {
        int cases = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(scan.nextLine());

            List<String> strings = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String in = scan.nextLine();
                in = new StringBuilder(in.substring(1)).reverse().toString();
                strings.add(in);

            }

            String check = check(strings);
            if (check != null) {
                System.out.printf("Case %d: %s\n", (i + 1), new StringBuilder(check).reverse().toString());
            } else {
                System.out.printf("Case %d: *\n", (i + 1));
            }
        }

    }
}