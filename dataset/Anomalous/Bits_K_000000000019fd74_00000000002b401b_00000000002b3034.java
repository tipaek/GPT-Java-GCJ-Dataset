import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            List<String> strings = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                strings.add(sc.next());
            }

            strings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

            boolean isValid = true;
            for (int i = 1; i < n && isValid; i++) {
                String shorter = strings.get(i - 1);
                String longer = strings.get(i);

                int shorterLength = shorter.length();
                int longerLength = longer.length();

                for (int j = 0; j < shorterLength; j++) {
                    if (shorter.charAt(shorterLength - 1 - j) != longer.charAt(longerLength - 1 - j)) {
                        System.out.println("Case #" + caseNumber + ": *");
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + strings.get(n - 1).substring(1));
            }
            caseNumber++;
        }
    }
}