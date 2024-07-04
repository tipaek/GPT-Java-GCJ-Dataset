
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] testCases = new String[T + 1];
        String[] answers = new String[T + 1];
        for (int i = 1; i <= T; i++) {
            testCases[i] = br.readLine();
        }

        for (int i = 1; i <= T; i++) {
            String curr_case = testCases[i];
            List<Integer> indexOfZeroes = new ArrayList<>();
            for (int j = 0; j < curr_case.length(); j++) {
                if (curr_case.charAt(j) == '0') {
                    indexOfZeroes.add(j);
                }
            }
            StringBuilder sb = new StringBuilder();


            if (indexOfZeroes.size() == 1) {
                sb.append(solutionWithOutZero(curr_case.substring(0, indexOfZeroes.get(0))));
                sb.append('0');
                sb.append(solutionWithOutZero(curr_case.substring(indexOfZeroes.get(0) + 1)));

            } else if(indexOfZeroes.size()>0) {
                int start = 0;
                int end = indexOfZeroes.get(0);

                for (int z = 0; z < indexOfZeroes.size(); z++) {
                    System.out.println("ander hu");
                    sb.append(solutionWithOutZero(curr_case.substring(start, end)));
                    start = end + 1;
                    end = indexOfZeroes.get(z + 1);
                }
            }

            System.out.println("answer");
            System.out.println(sb);
        }

    }

    public static String addDepth(char ch, int min, int count) {
        StringBuilder sb = new StringBuilder("");
        int num = Integer.parseInt(ch + "");
        int pad_length = num - min;
        int x = pad_length, y = pad_length;

        if (num == 0) {
            while (count > 0) {
                sb.append('0');
                count--;
            }
            return sb.toString();
        }

        while (x > 0) {
            sb.append("(");
            x--;
        }

        while (count > 0) {
            sb.append(ch);
            count--;
        }


        while (y > 0) {
            sb.append(")");
            y--;
        }
        return sb.toString();
    }

    public static String solutionWithOutZero(String curr_case) {
        StringBuilder str = new StringBuilder("");
        System.out.println("for case " + curr_case);
        //fiind minimum
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < curr_case.length(); j++) {
            int x = Integer.parseInt(curr_case.charAt(j) + "");
            if (x < min) {
                min = x;
            }
        }

        int j = 0;
        int len = curr_case.length();


        //add opening parenthesis
        for (int x = 0; x < min; x++) {
            str.append('(');
        }


        while (j < len) {
            char ch = curr_case.charAt(j);
            int count = 1;


            while (j < len - 1 && curr_case.charAt(j) == curr_case.charAt(j + 1)) {
                j++;
                count++;

            }

            String padded = addDepth(ch, min, count);
            str.append(padded);
            j++;
        }


        //add closing parenthesis
        for (int x = 0; x < min; x++) {
            str.append(')');
        }

        return str.toString();
        //System.out.println("Case #"+i+": "+ str);
    }
}


