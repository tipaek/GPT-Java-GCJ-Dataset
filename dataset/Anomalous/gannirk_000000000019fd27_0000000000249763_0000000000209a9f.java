import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int z = 1; z <= t; z++) {
            String s = sc.nextLine();
            StringBuilder sd = new StringBuilder();
            int l = Character.getNumericValue(s.charAt(0));

            for (int j = 0; j < l; j++) {
                sd.append('(');
            }
            sd.append(s.charAt(0));

            for (int i = 1; i < s.length(); i++) {
                int r = Character.getNumericValue(s.charAt(i));
                if (r < l) {
                    for (int j = 0; j < l - r; j++) {
                        sd.append(')');
                    }
                } else if (r > l) {
                    for (int j = 0; j < r - l; j++) {
                        sd.append('(');
                    }
                }
                sd.append(s.charAt(i));
                l = r;
            }

            for (int j = 0; j < l; j++) {
                sd.append(')');
            }

            System.out.println("Case #" + z + ": " + sd.toString());
        }
        
        sc.close();
    }
}