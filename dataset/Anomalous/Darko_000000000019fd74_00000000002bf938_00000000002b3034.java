import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private void processCases() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfStrings = scanner.nextInt();
            List<String> stringsList = new ArrayList<>();
            for (int i = 0; i < numberOfStrings; i++) {
                stringsList.add(scanner.next().substring(1));
            }

            stringsList.sort(Comparator.comparingInt(String::length));

            boolean isValid = true;
            for (int i = 1; i < stringsList.size(); i++) {
                isValid &= stringsList.get(i).endsWith(stringsList.get(i - 1));
            }
            String result = isValid ? stringsList.get(stringsList.size() - 1) : "*";
            System.out.printf("Case #%d: %s\n", caseIndex, result);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().processCases();
    }
}