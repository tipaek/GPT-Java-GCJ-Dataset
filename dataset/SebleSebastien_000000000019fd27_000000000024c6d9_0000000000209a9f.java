import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * @author schenevotot
 */
public class Solution {

    private static final boolean DEBUG = false;
    
    public String solve(String line) {
        StringBuilder sb = new StringBuilder();
        
        char[] chars = line.toCharArray();
        if (chars.length == 1) {
            String res = solve('*', chars[0], '*');
            sb.append(res);
        }
        else {
            String res = solve('*', chars[0], chars[1]);
            sb.append(res);
        }
        
        for (int i = 1; i < chars.length - 1; i++) {
            String res = solve(chars[i - 1], chars[i], chars[i+1]);
            sb.append(res);
        }
        
        if (chars.length >= 2) {
            String res = solve(chars[chars.length - 2], chars[chars.length - 1], '*');
            sb.append(res);
        }
        String res2 = solve(chars[chars.length - 1], '*', '*');
        sb.append(res2);
        return sb.toString();
    }
    
    private String solve(char prec, char current, char next) {
        
        StringBuilder res = new StringBuilder();
        if (prec == '*') {
            //First char
            //return current times (
            int cur = Integer.parseInt(String.valueOf(current));
            for (int i = 0; i < cur; i++) {
                res.append("(");
            }
            res.append(current);
        }
        else {
            int pre = Integer.parseInt(String.valueOf(prec));
            
            //Last char
            if (current == '*') {
                for (int i = 0; i < pre; i++) {
                    res.append(")");
                }
            }
            else {
                //Nominal case
                //return prec - current times (
                int cur = Integer.parseInt(String.valueOf(current));
                if (pre - cur > 0) {
                    for (int i = 0; i < pre - cur; i++) {
                        res.append(")");
                    }
                } else if (pre - cur < 0) {
                    for (int i = 0; i < cur - pre; i++) {
                        res.append("(");
                    }
                }
                res.append(cur);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Solution solver = null;

        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream(Objects.requireNonNull(classLoader.getResource("Nesting-1.in")).getPath()) : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            scanner.nextLine();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                solver = new Solution();
                String line = scanner.nextLine();
                String result = solver.solve(line);
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
       //System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}