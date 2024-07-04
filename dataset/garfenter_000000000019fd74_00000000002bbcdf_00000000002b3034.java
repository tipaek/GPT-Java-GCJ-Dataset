import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            String result = "";
            int patternsCount = in.nextInt();
            in.nextLine();
            List<List<String>> levels = new ArrayList<>();
            for (int i = 0; i < patternsCount; i++) {
                String pattern = in.nextLine();
                int actualLevel = 0;
                String levelString = "";
                for (int j = 0; j < pattern.length(); j++) {
                    char ch = pattern.charAt(j);
                    if (ch == '*') {
                        if (levels.size() <= actualLevel) {
                            levels.add(new ArrayList<>());
                        }
                        levels.get(actualLevel).add(levelString);
                        actualLevel++;
                        levelString = "";
                    } else {
                        levelString += ch;
                    }
                }
                if (levels.size() <= actualLevel) {
                    levels.add(new ArrayList<>());
                }
                levels.get(actualLevel).add(levelString);
            }
            boolean noMatch = false;
            for (int j = 0; j < levels.size(); j++) {
                List<String> level = levels.get(j);
                level.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                });
                String levelResult = "";
                for (int i = 0; i < level.size(); i++) {
                    if (j == 0 && level.get(i).startsWith(levelResult)) {
                        levelResult = level.get(i);
                    } else if (level.get(i).endsWith(levelResult)) {
                        levelResult = level.get(i);
                    } else {
                        noMatch = true;
                        break;
                    }
                }
                if (noMatch) {
                    break;
                }
                result += levelResult;
            }

            System.out.println("Case #" + c + ": " + (noMatch ? "*" : result));
        }
    }

}
