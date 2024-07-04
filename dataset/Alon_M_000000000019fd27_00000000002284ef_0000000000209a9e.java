import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        int query = 0;
        scanner.nextLine(); //check if it cleans it up
        for (int i = 0; i < t; i++){
            String line = "";
            for (int j = 0; j < b; j++){
                System.out.println(j + 1);
                line = line.concat(scanner.nextLine());
                query++;
            }
            String[] parsed = new String[b / 10];

            for (int j = 0; j < b/10; j++){
                parsed[j] = line.substring(10*j, 10*j + 10);
            } //parsed input to the array

            boolean sucseeded = false;

            while (!sucseeded && query < 150) {
                String test = "";
                for (int j = 0; j < 10; j++) {
                    System.out.println(j + 1);
                    test = test.concat(scanner.nextLine());
                }

                if (parsed[0].equals(test)) {
                    System.out.println(line);
                    sucseeded = scanner.nextLine().equals("Y");
                }
                else if (!sucseeded && isNeg(parsed[0], test)) {
                    System.out.println(createNeg(line));
                    sucseeded = scanner.nextLine().equals("Y");
                }
                else if (!sucseeded && isRev(parsed[0], test)) {
                    System.out.println(createRev(line));
                    sucseeded = scanner.nextLine().equals("Y");
                }

                else if (!sucseeded) {
                    System.out.println(createRevNeg(line));
                    sucseeded = scanner.nextLine().equals("Y");
                }
            }
        }
    }

    private static String createRevNeg(String line) {
        String output = createRev(createNeg(line));
        return output;
    }

    private static String createRev(String line) {
        String output = "";
        for (int i = 0; i < line.length(); i++ ){
            output = output + line.charAt(line.length() - i - 1);
        }
        return output;
    }

    private static String createNeg(String line) {
        String output = "";
        for (int i = 0; i < line.length(); i++ ){
            int tmp = Math. abs(Integer.parseInt(String.valueOf(line.charAt(i))) - 1);
            output = output + tmp;
        }
        return output;
    }

    private static boolean isNeg(String s, String test) {
        for (int i = 0; i<s.length(); i++){
            if (Character.compare(s.charAt(i), test.charAt(i)) == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean isRev(String s, String test) {
        for (int i = 0; i<s.length(); i++){
            if (Character.compare(s.charAt(i), test.charAt(9 - i)) != 0){
                return false;
            }
        }
        return true;
    }
}
