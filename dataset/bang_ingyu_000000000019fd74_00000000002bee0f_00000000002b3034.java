import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = stoi(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = stoi(br.readLine());

            sb.append(String.format("Case #%d: ", i));

            String start = "";
            ArrayList<String> middle = new ArrayList<>();
            String end = "";

            boolean valid = true;

            for (int j = 0; j < N; j++) {
                String read = br.readLine();
                String[] input = read.split("\\*");
                if (!input[0].equals("")) {
                    if (start.length() >= input[0].length()) {
                        if (!start.startsWith(input[0])) {
                            valid = false;
                        }
                    } else {
                        if (!input[0].startsWith(start)) {
                            valid = false;
                        } else {
                            start = input[0];
                        }
                    }
                }
                if (input.length > 1) {

                    for (int k = 1; k < input.length - 1; k++) {
                        if (!input[k].equals("")) {
                            middle.add(input[k]);
                        }
                    }
                    if (!read.endsWith("*")) {
                        if (end.length() >= input[input.length - 1].length()) {
                            if (!end.endsWith(input[input.length - 1])) {
                                valid = false;
                            }
                        } else {
                            if (!input[input.length - 1].endsWith(end)) {
                                valid = false;
                            } else {
                                end = input[input.length - 1];
                            }
                        }
                    } else {
                        middle.add(input[input.length -1]);
                    }
                }
            }
            if (valid) {
                sb.append(start);
                for (int j = 0; j < middle.size(); j++) {
                    sb.append(middle.get(j));
                }
                sb.append(end);
                sb.append("\n");
            } else {
                sb.append("*\n");
            }


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
