import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            String s = sc.next();
            List<String> segments = new ArrayList<>();
            List<Integer> differences = new ArrayList<>();

            String currentChar = s.substring(0, 1);
            segments.add("");
            differences.add(Integer.parseInt(currentChar));

            int index = 0, totalSum = 0;
            totalSum += differences.get(index);

            for (int i = 0; i < s.length(); i++) {
                String charAtI = s.substring(i, i + 1);
                if (!charAtI.equals(currentChar)) {
                    currentChar = charAtI;
                    segments.add(currentChar);

                    String firstCharOfSegment = segments.get(index).substring(0, 1);
                    differences.add(Integer.parseInt(currentChar) - Integer.parseInt(firstCharOfSegment));
                    index++;
                    totalSum += differences.get(index);
                } else {
                    segments.set(index, segments.get(index) + charAtI);
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            for (int i = 0; i < differences.size(); i++) {
                int difference = differences.get(i);
                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        System.out.print("(");
                    }
                } else {
                    for (int j = 0; j < -difference; j++) {
                        System.out.print(")");
                    }
                }
                System.out.print(segments.get(i));
            }

            for (int i = 0; i < totalSum; i++) {
                System.out.print(")");
            }

            System.out.println();
            caseNumber++;
        }
    }
}