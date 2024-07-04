import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(TreeMap<Integer, String> problem){

        char[] result = new char[problem.size()];

        int cLast = 0;
        int jLast = 0;
        for (Map.Entry<Integer, String> entry : problem.entrySet()) {
            if (cLast <= entry.getKey()) {
                cLast = convertToInt(entry.getValue());

                result[getId(entry.getValue())] = 'C';
            } else if(jLast <= entry.getKey()){
                jLast = convertToInt(entry.getValue());

                result[getId(entry.getValue())] = 'J';
            } else {
                return "IMPOSSIBLE";
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< result.length; i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value.split("%")[1]);
    }

    public static int getId(String value) {
        return Integer.parseInt(value.split("%")[0]);
    }


    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("resources/qualification/parent/input.txt") : System.in;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)))) {

            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {

                TreeMap<Integer, String> problem = new TreeMap<>();
                int nOA = in.nextInt();
                for(int j = 0 ; j< nOA; j++){

                    problem.put(in.nextInt(), j + "%"+in.nextInt());
                }
                String result = solve(problem);
                System.out.println("Case #" + i + ": " + result);
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
}