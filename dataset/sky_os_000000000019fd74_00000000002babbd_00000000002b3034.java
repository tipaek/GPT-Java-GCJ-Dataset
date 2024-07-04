import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author namhcn
 */
public class Solution {

    private static final boolean DEBUG = false;

    public static String process(List<String> lst) {
        Collections.sort(lst, new Comparator<String>() {
            @Override
            public int compare(final String object1, final String object2) {
                return object2.length() - object1.length();
            }
        });
        List<String> filter = new ArrayList<>();

        for (int i = 0; i < lst.size(); i++) {
            String str = lst.get(i);
            if (str.equals("")) {
                continue;
            }
            for (int j = i + 1; j < lst.size(); j++) {
                String comp = str.replace("*", "aaa");
                boolean isMatch = comp.matches(lst.get(j).replace("*", "(.*)"));
                if (isMatch) {
                    lst.set(j, "");
                }
            }
        }
        for (String string : lst) {
            if (!string.equals("")) {
                filter.add(string);
            }
        }
        String ret = "";

        String str = filter.get(0).replace("*", "");
        for (int j = 1; j < filter.size(); j++) {
            str = filter.get(j).replace("*", str);
            for (int k = 0; k < filter.size(); k++) {
                if (!str.matches(filter.get(k).replace("*", "(.*)"))) {
                    return "*";
                }
            }
        }
        return str;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/input.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int rowCount = scanner.nextInt();
//                SortedMap<Integer, List<String>> sortedMap = new TreeMap<>();
                List<String> lst = new ArrayList<>();
                for (int i = 0; i < rowCount; i++) {
                    String str = scanner.next();
                    lst.add(str);
//                    if (sortedMap.get(str.length()) != null) {
//                        sortedMap.get(str.length()).add(str);
//                    } else {
//                        List<String> lst = new ArrayList<>();
//                        lst.add(str);
//                        sortedMap.put(str.length(), lst);
//                    }
                }
                System.err.println("Case #" + testNumber + ":" + process(lst));
            }
        }
    }
}
