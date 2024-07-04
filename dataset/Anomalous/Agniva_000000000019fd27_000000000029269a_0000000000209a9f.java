import java.io.*;

class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int k = 1; k <= T; k++) {
            String s = br.readLine();
            StringBuilder str = new StringBuilder();
            int open = 0;

            for (int j = 0; j < s.length(); j++) {
                int x = Character.getNumericValue(s.charAt(j));

                while (open < x) {
                    str.append("(");
                    open++;
                }
                while (open > x) {
                    str.append(")");
                    open--;
                }
                str.append(x);
            }

            while (open > 0) {
                str.append(")");
                open--;
            }

            System.out.println("Case #" + k + ": " + str.toString());
        }
    }
}