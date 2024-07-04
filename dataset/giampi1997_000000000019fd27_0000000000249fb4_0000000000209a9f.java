import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= T; t++){
            String input = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            int aperte = 0;

            for (int i = 0; i < input.length(); i++) {
                char curr = input.charAt(i);
                if (Character.isDigit(curr)){
                    int val = Character.digit(curr, 10);
                    while (aperte < val){
                        builder.append('(');
                        aperte++;
                    }
                    while (aperte > val){
                        builder.append(')');
                        aperte--;
                    }
                    builder.append(curr);


                }
                else{
                    if (curr == '(') {
                        builder.append('(');
                        aperte++;
                    }
                    else{
                        aperte--;

                        if (aperte < 0){
                            builder.append('(');
                            aperte = 0;
                        }

                        builder.append(')');
                    }
                }
            }

            while (aperte > 0){
                builder.append(')');
                aperte--;
            }

            System.out.println("Case #" + t + ": " + builder);

        }
    }
}