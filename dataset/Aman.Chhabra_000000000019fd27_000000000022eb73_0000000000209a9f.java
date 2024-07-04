import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> resultList = new ArrayList<>();
        while(testCases-->0) {
            String input = scanner.next();
            resultList.add(solveProblem(input));
        }
        int count = 0;
        for(String result: resultList) {
            System.out.println("Case #"+ ++count +": "+result);
        }
    }

    private static String solveProblem(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int prevNum = Integer.parseInt(Character.toString(input.charAt(0)));
        for(int i=0;i<prevNum;i++) stringBuilder.append('(');
        stringBuilder.append(prevNum);
        for(int i =1;i<input.length();i++) {
            int present = Integer.parseInt(Character.toString(input.charAt(i)));
            if(present<prevNum) {
                for(int j=0;j<(prevNum-present);j++) stringBuilder.append(')');
            } else if(present>prevNum) {
                for(int j=0;j<(present-prevNum);j++) stringBuilder.append('(');
            }
            stringBuilder.append(present);
            prevNum = present;
        }
        for(int i=0;i<prevNum;i++) stringBuilder.append(')');
        return stringBuilder.toString();
    }

}
