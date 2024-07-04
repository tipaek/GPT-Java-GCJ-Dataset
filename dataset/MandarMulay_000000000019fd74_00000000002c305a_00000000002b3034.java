import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        int testCasesCount = scanner.nextInt();
        while(i <= testCasesCount){
            int patternCount = scanner.nextInt();
            String[] patterns = new String[patternCount];
            int j = 0;
            while(patternCount > j){
                patterns[j] = scanner.next();
                j++;
            }
            String result = solution.createStringFromPatterns(patterns);

            System.out.print("Case #" + i + ": " + result);
            System.out.println();
            i++;
        }
    }

    public String createStringFromPatterns(String[] patterns){
        if(patterns.length == 1) return patterns[0].substring(1);

        String prev = patterns[0].substring(1);
        for(int i = 1; i < patterns.length; i++){
            String current = patterns[i].substring(1);
            if(current.endsWith(prev)){
                prev = current;
            } else if(prev.endsWith(current)){
                prev = prev;
            } else {
                return "*";
            }
        }
        return prev;
    }
}