import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numCases = Integer.parseInt(buffReader.readLine());

            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                String content = buffReader.readLine();
                StringBuilder result = new StringBuilder();

                int previousValue = 0;

                for (int i = 0; i < content.length(); i++) {
                    int currentValue = Character.getNumericValue(content.charAt(i));

                    if (currentValue > previousValue) {
                        for (int j = 0; j < currentValue - previousValue; j++) {
                            result.append('(');
                        }
                    } else if (currentValue < previousValue) {
                        for (int j = 0; j < previousValue - currentValue; j++) {
                            result.append(')');
                        }
                    }

                    result.append(currentValue);
                    previousValue = currentValue;
                }

                for (int j = 0; j < previousValue; j++) {
                    result.append(')');
                }

                System.out.println("Case #" + caseNum + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}