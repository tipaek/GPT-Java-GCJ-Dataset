import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < caseCount; i++) {
            System.out.println(solve(scanner.nextLine(), i + 1));
        }
    }

    public static String solve(String str, int index) {
        String result = "";
        int pCount = 0;
        for(char c: str.toCharArray()) {
            if(c >= '0' && c <= '9') {
                int count = c - '0';
                if(pCount < count) {
                    while(pCount < count) {
                        pCount++;
                        result += "(";
                    }
                }

                if (pCount > count) {
                    while(pCount > count) {
                        pCount--;
                        result += ")";
                    }
                }
                result += String.valueOf(c);
            }
        }

        while(pCount > 0) {
            result += ")";
            pCount--;
        }

        return String.format("Case #%d: %s", index, result);
    }
}