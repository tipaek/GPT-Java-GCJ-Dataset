import java.util.*;

public class Solution {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        for(int c = 1; c <= tc; c++) {
            int n = in.nextInt();
            ArrayList<String> startsWithPatterns = new ArrayList<String>();
            ArrayList<String> endsWithPatterns = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String s = in.next();
                if (s.startsWith("*")) {
                    startsWithPatterns.add(s.replace("*", ""));
                } else if (s.endsWith("*")) {
                    endsWithPatterns.add(s.replace("*", ""));
                } else {
                    String[] array = s.split("\\*");
                    startsWithPatterns.add(array[1]);
                    endsWithPatterns.add(array[0]);
                }
            }
            Collections.sort(startsWithPatterns, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.compare(s1.length(), s2.length());
                }
            });
            Collections.sort(endsWithPatterns, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.compare(s1.length(), s2.length());
                }
            });

            String result = solve(startsWithPatterns, endsWithPatterns);
            System.out.println("Case #" + c + ": " + result);
        }
    }

    private static String solve(ArrayList<String> startsWithPatterns, ArrayList<String> endsWithPatterns) {
        int n = startsWithPatterns.size();

        //Check to make sure they are all substrings of the longer strings
        for (int i = 0; i < n-1; i++) {
            String smallerString = startsWithPatterns.get(i);
            for (int j = i+1; j < n; j++) {
                String largerString = startsWithPatterns.get(j);
                if (!largerString.endsWith(smallerString)) {
                    return "*";
                }
            }
        }
        String endsWith = !startsWithPatterns.isEmpty() ? startsWithPatterns.get(n-1).replace("*", "") : "";

        n = endsWithPatterns.size();
        //Check to make sure they are all substrings of the longer strings
        for (int i = 0; i < n-1; i++) {
            String smallerString = endsWithPatterns.get(i);
            for (int j = i+1; j < n; j++) {
                String largerString = endsWithPatterns.get(j);
                if (!largerString.startsWith(smallerString)) {
                    return "*";
                }
            }
        }

        String startsWith = !endsWithPatterns.isEmpty() ? endsWithPatterns.get(n-1).replace("*", "") : "";

        return startsWith+endsWith;
    }
}
