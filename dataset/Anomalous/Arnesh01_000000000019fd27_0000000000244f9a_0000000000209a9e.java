import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static StringBuffer reverse(StringBuffer str) {
        return new StringBuffer(str).reverse();
    }

    public static StringBuffer complement(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i) == '0' ? '1' : '0');
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int t = 1; t <= T; t++) {
            if (B == 10) {
                StringBuffer sb = new StringBuffer();
                for (int i = 1; i <= B; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    sb.append(n);
                }
                System.out.println(sb);
                System.out.flush();
                br.readLine(); // Read the response character
            } else if (B == 20) {
                StringBuffer a = new StringBuffer();
                StringBuffer b = new StringBuffer();
                StringBuffer c = new StringBuffer();

                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    a.append(n);
                }
                for (int i = 16; i <= 20; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    b.append(n);
                }
                for (int i = 6; i <= 15; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    c.append(n);
                }

                String[] answers = new String[4];
                answers[0] = a.toString() + c.toString() + b.toString();
                answers[1] = complement(a).toString() + c.toString() + complement(b).toString();
                answers[2] = reverse(b).toString() + c.toString() + reverse(a).toString();
                answers[3] = reverse(complement(b)).toString() + c.toString() + reverse(complement(a)).toString();

                int i = 0;
                char response;
                do {
                    System.out.println(answers[i]);
                    System.out.flush();
                    i++;
                    response = br.readLine().charAt(0);
                } while (response == 'N' && i <= 3);
            }
        }
    }
}