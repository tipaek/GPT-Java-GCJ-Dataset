import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = input(reader).get(0);
        for(int i = 1; i <= t; i++) {
            output(i, solve(reader));
        }

        reader.close();
    }

    private static String provideParenthesis(int digit, char openOrClosed) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            sb.append(openOrClosed);
        }

        return sb.toString();
    }

    private static String solve(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String inputString = reader.readLine();
        int nOpen = 0;

        // Provide an opening parenthesis to the output string
        // with as opening braces as
        // (value of digit - opened parenthesis)

        for (char ch : inputString.toCharArray()) {
            int inputDigit = Integer.parseInt(String.valueOf(ch));

            if (inputDigit > nOpen) {
                sb.append(provideParenthesis(inputDigit - nOpen, '('));
            } else if (inputDigit < nOpen) {
                sb.append(provideParenthesis(nOpen - inputDigit, ')'));
            }

            nOpen = inputDigit;
            sb.append(ch);
        }

        sb.append(provideParenthesis(nOpen, ')'));

        return sb.toString();
    }

    private static List<Integer>  input(BufferedReader reader) throws IOException {
        return input(reader, Integer::valueOf);
    }

    private static <T> List<T> input(BufferedReader reader, Function<String, T> mapper) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(mapper)
                .collect(Collectors.toList());
    }

    private static <T> void output(int idx, T answer) {
        System.out.println(
                String.format(
                        "Case #%d: %s",
                        idx,
                        answer.toString()
                )
        );
    }
}