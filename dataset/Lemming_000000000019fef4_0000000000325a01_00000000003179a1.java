public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            StringBuilder[] responses = {new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder()};
            for (int j = 0; j < 10000; j++) {
                int q = in.nextInt();
                String r = in.next();
                if (q > 0 && q < 11) {
                    responses[q - 1].append(r);
                }
            }
            String d = String.valueOf(responses[0].charAt(0));// char for 1
            for (int j = 1; j < 9; j++) {
                Pattern regex = Pattern.compile("[^" + d + "]");
                Matcher matcher = regex.matcher(responses[j].toString());
                if (!matcher.find()) {
                    throw new RuntimeException("Not all digits found");
                }
                d = d + matcher.group();
            }
            Pattern regex = Pattern.compile("[^" + d + "]");
            Matcher matcher = regex.matcher(responses[9].toString());
            if (!matcher.find()) {
                throw new RuntimeException("Not all digits found");
            }
            d = matcher.group() + d; // char for digit 0
            System.out.println("Case #" + i + ": " + d);
        }
        in.close();
    }

}