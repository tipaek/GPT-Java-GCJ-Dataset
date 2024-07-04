
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            String next = in.next();
            List<Integer> num = next.chars().mapToObj(s -> Character.digit(s, 10)).collect(Collectors.toList());
            check(i + 1, num);
        }
    }

    private static void check(int testCaseNum, List<Integer> num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.size(); i++) {
            StringBuilder mid = new StringBuilder();
            mid.append(num.get(i));
            int j = i + 1;
            while (j < num.size() && num.get(i).equals(num.get(j))){
                mid.append(num.get(j));
                j++;
            }
            i += (j - i - 1);
            StringBuilder start = new StringBuilder();
            StringBuilder end = new StringBuilder();
            for (int k = 0; k < num.get(i); k++) {
                start.append("(");
            }
            for (int k = 0; k < num.get(i); k++) {
                end.append(")");
            }
            start.append(mid);
            start.append(end);
            res.append(start);
        }
        int len = res.length();
        int shorter = 0;
        while (len != shorter){
            len = res.length();
            shorten(res);
            shorter = res.length();
        }

        System.out.println("Case #" + testCaseNum + ": " + res);
    }

    private static void shorten(StringBuilder start) {
        for (int i = 0; i < start.length(); i++) {
            if(i < start.length() - 2 && start.charAt(i) == ')' && start.charAt(i+1) == '('){
                start.delete(i, i+2);
                i = i - 1;
                break;
            }
        }
        for (int i = 0; i < start.length(); i++) {
            if(i < start.length() - 2 && start.charAt(i) == '(' && start.charAt(i+1) == ')'){
                start.delete(i, i+2);
                i = i - 1;
                break;
            }
        }
    }
}
