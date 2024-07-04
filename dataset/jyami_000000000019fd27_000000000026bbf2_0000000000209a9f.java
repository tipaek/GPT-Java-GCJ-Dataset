import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> indexList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BRACKET[] bracket = BRACKET.values();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] input = new String[t];
        for (int i = 0; i < t; i++) {
            input[i] = br.readLine();
            process(input[i], i);
        }

        for(int k =0 ; k<t; k++){
            StringBuilder sb = new StringBuilder();
            String str = input[k];
            List<Integer> check = indexList.get(k);
            for (int i = 0; i < check.size() - 1; i++) {
                String substring = str.substring(check.get(i), check.get(i + 1));
                int value = str.getBytes()[check.get(i)] - '0';
                String open = bracket[value].open;
                String close = bracket[value].close;
                sb.append(open);
                sb.append(substring);
                sb.append(close);
            }
            System.out.println(String.format("Case #%d: %s",k+1, sb.toString()));
        }
    }

    public static void process(String a, int t) {
        List<Integer> index = new ArrayList<>();
        char[] chars = a.toCharArray();
        int num = chars[0] - '0';
        index.add(0);
        for (int i = 1; i < a.length(); i++) {
            int now = chars[i] - '0';
            if (num != now) {
                index.add(i);
                num = now;
            }
        }
        index.add(chars.length);
        indexList.add(index);
    }

    enum BRACKET {
        ZERO("", ""),
        ONE("(", ")"),
        TWO("((", "))"),
        THREE("(((", ")))"),
        FOUR("((((", "))))"),
        FIVE("(((((", ")))))"),
        SIX("((((((", "))))))"),
        SEVEN("(((((((", ")))))))"),
        EIGHT("((((((((", "))))))))"),
        NIGHT("(((((((((", ")))))))))");

        String open;
        String close;

        BRACKET(String open, String close) {
            this.open = open;
            this.close = close;
        }
    }
}


