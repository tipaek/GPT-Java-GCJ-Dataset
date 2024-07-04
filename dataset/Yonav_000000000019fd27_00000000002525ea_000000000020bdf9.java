import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(TreeMap<Integer, ArrayList<String>> problem, int noA) {

        char[] result = new char[noA];

        int cLast = 0;
        int jLast = 0;
        for (Map.Entry<Integer, ArrayList<String>> entry : problem.entrySet()) {

            Collections.sort(entry.getValue());

            for (String value : entry.getValue()) {


                int cDist = entry.getKey() - cLast;
                int jDist = entry.getKey() - jLast;

                if (cDist < 0 && jDist < 0) {
                    return "IMPOSSIBLE";
                } else if (cDist < 0 && jDist >= 0) {
                    jLast = convertToInt(value);
                    result[getId(value)] = 'J';
                } else if (cDist >= 0 && jDist < 0) {
                    cLast = convertToInt(value);
                    result[getId(value)] = 'C';

                } else {
                    if (cDist <= jDist) {
                        cLast = convertToInt(value);
                        result[getId(value)] = 'C';
                    } else {
                        jLast = convertToInt(value);
                        result[getId(value)] = 'J';
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value.split("%")[0]);
    }

    public static int getId(String value) {
        return Integer.parseInt(value.split("%")[1]);
    }


    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("resources/qualification/parent/input.txt") : System.in;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)))) {

            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {

                TreeMap<Integer, ArrayList<String>> problem = new TreeMap<>();
                int nOA = in.nextInt();
                for (int j = 0; j < nOA; j++) {
                    int start = in.nextInt();
                    int end = in.nextInt();

                    if (problem.containsKey(start)) {
                        problem.get(start).add(end + "%" + j);
                    } else {
                        ArrayList<String> p = new ArrayList();
                        p.add(end + "%" + j);
                        problem.put(start, p);

                    }

                }
                String result = solve(problem, nOA);
                System.out.println("Case #" + i + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
