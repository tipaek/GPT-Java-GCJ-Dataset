
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i=0;i<cases;i++){
            String input = sc.next();
            // give all brackets blindly, then perform merge
            String one = input.replaceAll("1", "(1)");
            String two = one.replaceAll("2", "((2))");
            String three = two.replaceAll("3", "(((3)))");
            String four = three.replaceAll("4", "(((4)))");
            String five = four.replaceAll("5", "(((((5)))))");
            String six = five.replaceAll("6", "((((((6))))))");
            String seven = six.replaceAll("7", "(((((((7)))))))");
            String eight = seven.replaceAll("8", "((((((((8))))))))");
            String nine = eight.replaceAll("9", "(((((((((9)))))))))");
            String finality = nine.replaceAll("\\)\\(", "");
//            System.out.println(finality);

//            System.out.println(finality.contains(")("));
            while (finality.contains(")(")) {
//                System.out.println("still need to replace");
                finality = finality.replaceAll("\\)\\(", "");
            }
            System.out.println("Case #" + (i+1) + ": " + finality);
        }
    }
}
