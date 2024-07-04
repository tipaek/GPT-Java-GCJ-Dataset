import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tAsString = br.readLine();
        int t = Integer.parseInt(tAsString);
        for(int i = 0; i < t; ++i) {
            String numbers = br.readLine();
            StringBuilder builder = new StringBuilder();
            int acc = 0;
            for(int j = 0; j < numbers.length(); ++j) {
                int number = Character.getNumericValue(numbers.charAt(j));
                while(acc < number) {
                    builder.append("(");
                    ++acc; 
                }while(acc > number) {
                    builder.append(")");
                    --acc;
                }
                builder.append(numbers.charAt(j));
            }
            while(acc > 0){
                builder.append(")");
                --acc;
            }
            System.out.println("Case #"+(i + 1)+" "+builder.toString());
        }
    }
}
