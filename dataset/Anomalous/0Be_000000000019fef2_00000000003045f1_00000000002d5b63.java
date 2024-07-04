import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] initialInput = reader.readLine().split("\\s+");
        int testCases = Integer.parseInt(initialInput[0]);
        int A = Integer.parseInt(initialInput[1]);
        int B = Integer.parseInt(initialInput[2]);

        for (int currentTest = 0; currentTest < testCases; currentTest++) {
            boolean isCenterFound = false;

            for (int x = -5; x <= 5 && !isCenterFound; x++) {
                for (int y = -5; y <= 5 && !isCenterFound; y++) {
                    writer.println(x + " " + y);
                    writer.flush();
                    if ("CENTER".equals(reader.readLine())) {
                        isCenterFound = true;
                    }
                }
            }
        }

        reader.close();
        writer.close();
    }
}