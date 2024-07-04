package round1A;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                int c = scanner.nextInt();
                ArrayList<String> inputs = new ArrayList<>();
                for (int ii = 0; ii < c; ii++) {
                    inputs.add(scanner.nextLine());
                }
                System.out.println("Case #" + i + ": " + getAns(inputs));
            }
        } catch (Exception e) {
        }
    }

    public static String getAns(List<String> inputs) {
        String ans = "*";
        boolean flag = true;
        int curIdx = 1;
        int max = 0;
        String maxS ="";
        while (flag) {
            for (int i = 0; i < inputs.size(); i++) {
                if (inputs.get(i).length() > max ) {
                    maxS = inputs.get(i);
                    max = inputs.get(i).length();
                }
            }
            
        }
        ans += maxS;
        return ans;
    }

}
