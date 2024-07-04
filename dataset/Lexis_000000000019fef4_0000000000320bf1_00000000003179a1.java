import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {

    private static int nlines = (int) Math.pow(10, 4);

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            int upperBound = Integer.parseInt(reader.readLine());

            ArrayList<String> lines = new ArrayList<String>(nlines);
            for (int l = 0; l < nlines; l++)
                lines.add(reader.readLine());

            System.out.println("Case #" + i + ": " + process(lines));
        }

    }

    public String process(ArrayList<String> lines) {
        Map<Integer, Set<String>> find = new HashMap<Integer, Set<String>>();
        Set<String> abc = new HashSet<>();
        for (String line : lines) {
            String[] pieces = line.split(" ");
            if (pieces[0].length() == pieces[1].length()) {
                int digit = Integer.parseInt(pieces[0].charAt(0) + "");
                String val = pieces[1].charAt(0) + "";
                find.computeIfAbsent(digit, x -> new HashSet<>()).add(val);
            }
            for (int i = 0; i < pieces[1].length(); i++) {
                abc.add(pieces[1].charAt(i) + "");
            }
        }
        StringBuilder result = new StringBuilder();
        Set<String> used = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            Set<String> keys = find.get(i);
            keys.removeAll(used);
            if (keys.size() != 1)
                throw new IllegalStateException("aa");
            String key = keys.iterator().next();
            result.append(key);
            used.add(key);
        }
        abc.removeAll(used);
        return abc.iterator().next() + result.toString();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
