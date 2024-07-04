import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {
    private static final boolean DEBUG = false;
    private static final String DEBUG_INPUT_PATH = "Round 1C/src/Problem2/custom.in";
    private static InputStream is;

    static {
        try {
            is = DEBUG ? new FileInputStream(DEBUG_INPUT_PATH) : System.in;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));

    private static ArrayList<StringBuilder> permute(StringBuilder str) {
        if (str.length() == 0) {
            ArrayList<StringBuilder> empty = new ArrayList<>();
            empty.add(new StringBuilder());
            return empty;
        }
        char ch = str.charAt(0);
        StringBuilder subStr = new StringBuilder(str.substring(1));
        ArrayList<StringBuilder> prevResult = permute(subStr);
        ArrayList<StringBuilder> res = new ArrayList<>();
        for (StringBuilder val : prevResult) {
            for (int i = 0; i <= val.length(); i++) {
                res.add(new StringBuilder(val.substring(0, i) + ch + val.substring(i)));
            }
        }
        return res;
    }

    private static String solve(int U) {
        Set<Character> seen = new HashSet<>();
        Map<String, Integer> input = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int Q = in.nextInt();
            String R = in.nextLine().replaceAll("\\s","");
            input.put(R, Q);
            for (char c : R.toCharArray()) {
                if (Character.isLetter(c))
                    seen.add(c);
            }
        }
        Set<Character> zero = new HashSet<>(seen);
        for (Map.Entry<String, Integer> entry : input.entrySet())
                zero.remove(entry.getKey().charAt(0));
        seen.removeAll(zero);
        Character zeroChar = zero.iterator().next();
        StringBuilder digitStr = new StringBuilder();
        for (Character c : seen)
            digitStr.append(c);
        ArrayList<StringBuilder> permute = permute(digitStr);
        for (StringBuilder perms : permute) {
            Map<Character, Integer> alphabet = new HashMap<>();
            alphabet.put(zeroChar, 0);
            for (int i = 0; i <= 8; i++)
                alphabet.put(perms.charAt(i), i+1);
            boolean correct = true;
            for (Map.Entry<String, Integer> entry : input.entrySet()) {
                int value = 0;
                String str = entry.getKey();
                int n = str.length() - 1;
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (i == 0 && alphabet.get(c) == 0) {
                        correct = false;
                        break;
                    }
                    value += alphabet.get(c) * Math.pow(10, n-i);
                }
                if (value > entry.getValue()) {
                    correct = false;
                    break;
                }
            }
            if (correct)
                return perms.toString();
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        long beginTime = System.nanoTime();
        int test = Integer.parseInt(in.nextLine());
        for (int T = 1; T <= test; T++) {

            // Custom code
            int U = in.nextInt();
            String result = solve(U);
            // End of custom code

            System.out.println("Case #" + T + ": " + result);
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}
