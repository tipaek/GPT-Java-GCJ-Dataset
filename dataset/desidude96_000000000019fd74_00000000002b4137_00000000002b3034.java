import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int numString = in.nextInt();
            List<String> numPatterns = new ArrayList<>();
            for (int j = 0; j < numString; j++) numPatterns.add(in.next());
            System.out.println("Case #" + i + ": " + buildString(numPatterns));
        }
    }

    private static String buildString(List<String> strings) {
        String res = strings.get(0).substring(1);
        for (int i = 1; i < strings.size(); i++) {
            String newString = strings.get(i).substring(1);
            if (newString.contains(res)) res = newString;
            else if (!res.contains(newString)) {
                res = "*";
                break;
            }
        }
        return res;
    }
}
