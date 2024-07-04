import java.util.*;

public class Solution{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int TN = 0;
        while (TN++ < T) {
            String case_ = scanner.next();
            String answer = help(case_);
            System.out.println(String.format("Case #%d: %s", TN, answer));
        }
    }

    public static String help(String case_) {
        int size = case_.length();
        if (size == 0)
            return "";
        List<Character> res = new ArrayList<>();
        if (case_.charAt(0) == '0')
            res.add('0');
        if (case_.charAt(0) == '1') {
            res.add('(');
            res.add('1');
        }
        int i = 0;
        for (i = 1; i < size; i++) {
            if (case_.charAt(i) == '0' && case_.charAt(i - 1) == '0') {
                res.add('0');
            } else if (case_.charAt(i) == '0' && case_.charAt(i - 1) == '1') {
                res.add(')');
                res.add('0');
            } else if (case_.charAt(i) == '1' && case_.charAt(i - 1) == '0') {
                res.add('(');
                res.add('1');
            } else if (case_.charAt(i) == '1' && case_.charAt(i - 1) == '1') {
                res.add('1');
            }
        }
        if (case_.charAt(i - 1) == '1')
            res.add(')');
        return String.valueOf(res).replace(",","").replace("[","").replace("]","");
    }

}