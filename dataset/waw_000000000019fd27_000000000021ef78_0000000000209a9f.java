import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        scanner.nextLine();
        for(int i=0;i<cases;i++){
            String line = scanner.nextLine();

            solve(i + 1, line);

        }

    }

    private static void solve(int index, String line) {

        StringBuilder result = new StringBuilder(line.length() * 2);

        boolean previousOne = false;
        for(char ch : line.toCharArray()) {
            if(ch == '1' && !previousOne) {
                result.append('(');
            }
            if(ch == '0' && previousOne) {
                result.append(')');
            }
            previousOne = ch == '1';
            result.append(ch);
        }

        if(line.charAt(line.length() - 1) == '1') {
            result.append(')');
        }

        System.out.println(String.format("Case #%d: %s", index, result));
    }
}
