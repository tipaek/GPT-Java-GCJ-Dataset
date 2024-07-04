import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();

            scanner.nextLine();
            List<String> patterns = new ArrayList<>();
            for(int j=0;j<n;j++) {
                    patterns.add(scanner.nextLine());
            }

            String result = solve(i + 1, n, patterns);
            System.out.println(String.format("Case #%d: %s", i + 1, result));
        }

    }

    private static String solve(int index, int n, List<String> patterns) {

        Collections.sort(patterns, (a, b) -> a.length() - b.length());

        System.out.println(patterns);

        String previous = patterns.get(0);
        for(int i=1;i<patterns.size();i++) {
            String current = patterns.get(i);
            if(current.endsWith(previous.substring(1))) {
                previous = current;
            } else {
                return "*";
            }
        }

        return previous.substring(1);


    }
}
