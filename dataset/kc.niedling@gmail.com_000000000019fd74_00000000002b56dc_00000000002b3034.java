import java.util.*;

public class Solution {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        for(int c = 1; c <= tc; c++) {
            int n = in.nextInt();
            ArrayList<String> patterns = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                patterns.add(in.next());
            }
            Collections.sort(patterns, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.compare(s1.length(), s2.length());
                }
            });

            String result = solve(patterns);
            System.out.println("Case #" + c + ": " + result);
        }
    }

    private static String solve(ArrayList<String> patterns) {
        StringBuilder sb = new StringBuilder();
        int n = patterns.size();

        //Check to make sure they are all substrings of the longer strings
        for (int i = 0; i < n-1; i++) {
            String s = patterns.get(i).substring(1, patterns.get(i).length());
            for (int j = i+1; j < n; j++) {
                String largerString = patterns.get(j).substring(1, patterns.get(j).length());
                if (!largerString.contains(s)) {
                    return "*";
                }
            }
        }

        return patterns.get(n-1).substring(1, patterns.get(n-1).length());
    }


}
