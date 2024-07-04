import java.io.*;
import java.util.StringTokenizer;

public class Solution{
    /*
    public static class Node{

        String value;
        Node parent;
        Node next;

        public Node(String value, Node parent){
            if(value.contains("*")){

            }
        }

        public Node add(String[] input, Node parent){

        }

    }
    */
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
            String end = "";

            boolean valid = true;

            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split("\\*");
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
                if(input.length > 1) {
                    if (end.length() >= input[1].length()) {
                        if (!end.endsWith(input[1])) {
                            valid = false;
                        }
                    } else {
                        if (!input[1].endsWith(end)) {
                            valid = false;
                        } else {
                            end = input[1];
                        }
                    }
                }
            }
            if (valid) {
                sb.append(start);
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
