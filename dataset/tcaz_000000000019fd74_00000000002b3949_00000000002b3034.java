import java.util.*;

public class Solution {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().start();
    }

    void start() {
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            System.out.println("Case #" + (i+1) +": " + getAnswer());
        }
    }

    String getAnswer() {
        int n = scan.nextInt();
        List<String> strs = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            strs.add(scan.next());
        }
        String largest = "";
        for (String s : strs) {
            if (s.length() >= largest.length()) {
                largest = s;
            }
        }
        for (String s : strs) {
            if (!largest.endsWith(s.substring(1))) {
                return "*";
            }
        }
       return largest.substring(1);
    }

}
