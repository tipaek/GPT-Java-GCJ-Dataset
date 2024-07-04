import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();

        for (int test = 0; test < tests; test++) {
            in.nextLine();
            List<Guess> records = new ArrayList<>();
            for (double i = 0; i < Math.pow(10, 4); i++) {
                String a = in.nextLine();
                String localMax = a.split(" ")[0];

                String record = a.split(" ")[1];

                records.add(new Guess(localMax, record));
            }
            Comparator c = new Comparator<Guess>() {
                @Override
                public int compare(Guess t, Guess t1) {
                    int position = 0;
                    while (position < t.max.length()-1 && position < t1.max.length()-1) {                        
                        if (t.max.charAt(position) ==  t1.max.charAt(position)){
                            position++;
                            continue;
                        }
                        return t.max.charAt(position) - t1.max.charAt(position);
                    }
                    if (t.max.length() != t1.max.length()) {
                        return t.max.length()-t1.max.length();
                    }
                    return t.max.charAt(position) - t1.max.charAt(position);
                }
            };
            records.sort(c);
            List<Character> key = new ArrayList<>();
            for (Guess record : records) {
                if (record.max.startsWith("10")) {
                    if (record.max.length() == record.answer.length()) {
                        key.add(record.answer.charAt(1));
                        break;
                    }
                }
            }
            //key.add('T');
            int number = 1;
            for (Guess record : records) {
                if (record.max.charAt(0) - '0' != number) {
                    continue;
                }
                if(key.contains(record.answer.charAt(0))){
                    continue;
                }
                number++;
                key.add(record.answer.charAt(0));
            }
            StringBuilder sb = new StringBuilder();
            for (Character character : key) {
                sb.append(character);
            }
            System.out.println("Case #" + (test + 1) + ": " + sb.toString());
        }

    }

    private static class Guess {

        String max;
        String answer;

        public Guess(String max, String answer) {
            this.max = max;
            this.answer = answer;
        }
    }
}
