import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new    InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i=0; i<T; i++){
            String input = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println("Case #"+(i + 1)+": "+ processLine(input));
        }
        scanner.close();
    }

    //0((2)1), (((3))1(2)), ((((4)))), ((22)1)
    private static String processLine(String input) {
        StringBuilder sb = new StringBuilder();
        int openBraces = 0;
        for (char c : input.toCharArray()) {
            int num = Character.getNumericValue(c);
            if(openBraces <= num) {
                addBraces(sb,num-openBraces, '(');
                openBraces += num-openBraces;
            } else {
                addBraces(sb,openBraces-num, ')');
                openBraces -= openBraces-num;
            }
            sb.append(num);
        }
        addBraces(sb,openBraces, ')');
        return sb.toString();
    }

    private static void addBraces(StringBuilder sb, int n, char c) {
        for (int i =0; i<n; i++ ){
            sb.append(c);
        }
    }

}