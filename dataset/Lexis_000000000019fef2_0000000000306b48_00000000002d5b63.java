import java.io.*;

public class Solution {


    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String readLn() {
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }


    private static void writeLine(Object line) {

        System.out.println(line);
        System.out.flush();
    }

    public void processRawInput() throws NumberFormatException, IOException {
        String input = readLn();
        String[] parts = input.split(" ");
        int t = Integer.parseInt(parts[0]);
        int a = Integer.parseInt(parts[1]);
        int b = Integer.parseInt(parts[2]);

        caseL : for (int i = 1; i <= t; i++) {
            for (long x = -5; x <= 5; x++) {
                for (long y = -5; y <=  5; y++) {
                    writeLine(x +" "+y);
                    String reply = readLn();
                    if (reply.equals("CENTER")) {
                        continue caseL;
                    } else if (reply.equals("WRONG")) {
                        System.exit(0);
                    }
                }
            }

        }

    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput();
    }

}
