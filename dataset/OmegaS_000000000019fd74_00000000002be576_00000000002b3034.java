import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int tc = 1; tc <= t; tc++) {
            int n = in.nextInt();

            List<Pattern> startWithAst = new ArrayList<>();
            List<Pattern> endsWithAst = new ArrayList<>();

            boolean stringExists = true;

            for (int i = 0; i < n; i++) {
                String pattern = in.next();
                String[] slices = pattern.split("\\*");
                if (slices.length == 2 && pattern.startsWith("*")) {
                    startWithAst.add(new Pattern(slices[1]));
                } else if (slices.length == 1 && pattern.endsWith("*")) {
                    endsWithAst.add(new Pattern(slices[0]));
                } else {
                    for (int j = 0; j < slices.length; j++) {
                        if (slices[j].length() == 0) {
                            continue;
                        }

                        if (j - 1 >= 0) {
                            startWithAst.add(new Pattern(slices[j]));
                        }

                        if (j + 1 < slices.length) {
                            endsWithAst.add(new Pattern(slices[j]));
                        }
                    }
                }
            }

            // Sort

            startWithAst.sort(Comparator.comparing(Solution.Pattern::getLength));
            endsWithAst.sort(Comparator.comparing(Solution.Pattern::getLength));

            String s = "";
            for (Pattern pattern : startWithAst) {
                if (s.length() == 0) {
                    s = pattern.getPattern();
                    continue;
                }

                if (!s.contains(pattern.getPattern())) {
                    stringExists = false;
                    break;
                }
            }

            String e = "";
            if (stringExists) {
                e = "";
                for (Pattern pattern : endsWithAst) {
                    if (e.length() == 0) {
                        e = pattern.getPattern();
                        continue;
                    }

                    if (!e.contains(pattern.getPattern())) {
                        stringExists = false;
                        break;
                    }
                }
            }

            if (stringExists) {
                System.out.println("Case #" + tc + ": " + e + s);
            } else {
                System.out.println("Case #" + tc + ": *");
            }
        }
    }


    static class Pattern {
        String pattern;

        public Pattern(String patternParam) {
            this.pattern = patternParam;
        }

        public String getPattern() {
            return  this.pattern;
        }

        public int getLength() {
            return pattern.length() * -1;
        }
    }

}
