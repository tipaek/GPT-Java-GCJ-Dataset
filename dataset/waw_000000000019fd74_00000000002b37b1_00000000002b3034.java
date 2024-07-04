import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();

            List<String> patterns = new ArrayList<>();
            for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++){
                    patterns.add(scanner.nextLine());
                }
            }

            String result = solve(i + 1, n, patterns);
            System.out.println(String.format("Case #%s: %s", i + 1, result));
        }

    }

    private static String solve(int index, int n, List<String> patterns) {

        Collections.sort(patterns, (a, b) -> a.length() - b.length());

        String previous = patterns.get(0);
        for(int i=1;i<patterns.size();i++) {
            String current = patterns.get(i);
            if(current.endsWith(previous)) {
                previous = current;
            } else {
                return "*";
            }
        }

        return previous;


    }
}
