import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            String input = sc.next();
            StringBuilder builder = new StringBuilder();
            int prev = 0;
            for(char c : input.toCharArray()) {
                int num = c - '0';
                if(builder.length() == 0) {
                    if(num > 0) {
                        int temp = num;
                        while (temp-- > 0) {
                            builder.append('(');
                        }
                    }
                }else if(prev>num) {
                    int diff = prev - num;
                    while(diff-- > 0) {
                        builder.append(')');
                    }
                } else {
                    int diff = num - prev;
                    while(diff-- > 0) {
                        builder.append('(');
                    }
                }
                builder.append(num);
                prev = num;
            }
            while(prev-- > 0) {
                builder.append(')');
            }
            System.out.println("Case #" + t + ": " + builder);
        }
    }
}
