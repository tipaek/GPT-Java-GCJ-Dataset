import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static String solve(Scanner in) {
        int x = in.nextInt();
        List<String> names = new ArrayList<String>();
        for (int i=0;i<x;i++) {
            names.add(in.next());
        }
        List<String> first = new ArrayList<String>();
        List<String> last = new ArrayList<String>();
        List<String> middle = new ArrayList<String>();
        for (String name : names) {
            String[] splitted = name.split("\\*");
            for (int i = 0; i < splitted.length; i++) {
                if (i == 0 && name.charAt(0) != '*') { // verificar string menor
                    first.add(splitted[0]);
                }
                if (i == splitted.length - 1 && name.charAt(name.length() - 1) != '*') { //verificar string menor
                    last.add(splitted[splitted.length - 1]);
                    break;
                }
                if (!(i == 0 && name.charAt(0) != '*') && !(i == splitted.length - 1 && name.charAt(name.length() - 1) != '*')) {
                    if (!splitted[i].equals(""))
                        middle.add(splitted[i]);
                }
            }
        }
        if (first.size()>1) {
            Collections.sort(first, Comparator.comparingInt(String::length));
            for (String firstElem : first) {
                if (!first.get(first.size()-1).contains(firstElem)) {
                    return "*";
                }
            }
        }
        if (last.size()>1) {
            Collections.sort(last, Comparator.comparingInt(String::length));
            for (String lastElem : last) {
                if (!last.get(last.size()-1).contains(lastElem)) {
                    return "*";
                }
            }
        }
        String result = "";
        if (first.size()>0) result += first.get(first.size()-1);
        for (String elem : middle) result+=elem;
        if (last.size()>0) result += last.get(last.size()-1);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int prob = 1; prob <= N; ++prob) {
            System.out.println("Case #" + prob + ": " + solve(in));
        }

    }
}
