import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= t; i++) {
                String s = reader.readLine();
                StringBuilder s1 = new StringBuilder();
                int count = 0;

                for (int j = 0; j < s.length(); j++) {
                    int a = Character.getNumericValue(s.charAt(j));

                    if (a > count) {
                        for (int k = count; k < a; k++) {
                            s1.append("(");
                        }
                    } else if (a < count) {
                        for (int k = count; k > a; k--) {
                            s1.append(")");
                        }
                    }

                    s1.append(a);
                    count = a;

                    if (j == s.length() - 1) {
                        for (int k = count; k > 0; k--) {
                            s1.append(")");
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + s1.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}