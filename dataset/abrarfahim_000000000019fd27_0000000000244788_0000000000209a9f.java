import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            String s = sc.next();
            //logic
            StringBuilder y = new StringBuilder();
            int d = 0;

            int first = Character.getNumericValue(s.charAt(0));

            for(int a = 0; a < first; a++) {
                y.append("(");
                d++;
            }
            y.append(first);

            int prev = first;


            for(int j = 1; j < s.length(); j++) {
                int num = Character.getNumericValue(s.charAt(j));
                if(num < prev) {
                    for(int a = 0; a < prev - num; a++) {
                        y.append(")");
                        d--;
                    }
                    y.append(num);
                    prev = num;
                }

                else if(num > prev) {
                    for(int a = 0; a < num - prev; a++) {
                        y.append("(");
                        d++;
                    }
                    y.append(num);
                    prev = num;
                }
                else {
                    y.append(num);
                }


            }
            for(; d > 0; d--) {
                y.append(")");
            }
            //output
            System.out.println("Case #" + (i + 1) + ": " + y);
        }




    }
}

