import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int LIMIT = 10^4;

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            int numberOfPatters = Integer.parseInt(reader.readLine());
            List<String> patterns = new ArrayList<>(numberOfPatters);
            for (int r = 0; r < numberOfPatters; r++) {
                patterns.add(reader.readLine());
            }
            System.out.println("Case #" + i + ": " + process(patterns));
        }

    }

    public String process(List<String> patterns) {
        List<LinkedList<String>> pieces = new ArrayList<>(patterns.size());
        List<Integer> sizes = new ArrayList<>(patterns.size());
        List<String> begin = new ArrayList<>();
        List<String> end = new ArrayList<>();
        String stringBegin = "";
        String stringEnd = "";
        for (String pattern : patterns) {
            LinkedList<String> piece = new LinkedList<>(Arrays.asList(pattern.split("\\*+", -1)));
            int size = piece.stream().mapToInt(String::length).sum();
            if (size > LIMIT)
                return "*";
            if (!pattern.startsWith("*")) {
                String first = piece.removeFirst().trim();
                begin.add(first);
                size -= first.length();
            }
            if (!pattern.endsWith("*")) {
                String last = piece.removeLast().trim();
                end.add(last);
                size -= last.length();
            }
            if (size == 0) {
                continue;
            }
            pieces.add(piece);
            sizes.add(size);
        }

        if (begin.size() > 0) {
            begin.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return -1 * Integer.compare(o1.length(), o2.length());
                }
            });
            stringBegin = begin.remove(0);
            for (String e : begin) {
                if (!stringBegin.startsWith(e))
                    return "*";
            }
        }


        if (end.size() > 0) {
            end.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return -1 * Integer.compare(o1.length(), o2.length());
                }
            });
            stringEnd = end.remove(0);
            for (String e : end) {
                if (!stringEnd.endsWith(e))
                    return "*";
            }
        }

        while (!pieces.isEmpty()) {
            throw new RuntimeException();
            /*boolean operationPerformed = false;
            for (LinkedList<String> pattern : pieces) {
                Iterator<String> iter = pattern.iterator();
            }*/
        }

        if (stringBegin.length() > 0 && stringEnd.length() > 0) {
            char c = stringEnd.charAt(0);
            int foundPos = -1;
            int idx = stringBegin.length();
            do {
                idx = stringBegin.lastIndexOf(c, idx - 1);
                if (idx != -1 && stringBegin.length() - idx <= stringEnd.length()) {
                    if (stringBegin.endsWith(stringEnd.substring(0, stringBegin.length() - idx))) {
                        foundPos = stringBegin.length() - idx;
                    }
                }
            } while (idx != -1);
            if (foundPos != -1) {
                stringEnd = stringEnd.substring(foundPos);
            }
        }
        String result = stringBegin + stringEnd;
        if (result.length() > LIMIT || result.length() == 0)
            return "*";
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
