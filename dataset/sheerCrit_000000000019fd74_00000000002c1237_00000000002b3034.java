import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution{
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                patterns.add(input.next());
            }
           
            List<String> starts = new ArrayList<>();
            List<String> ends = new ArrayList<>();
            String longestFirst = "";
            String longestEnd = "";
                   
            for (int k = 0; k < patterns.size(); k++) {
                String word = patterns.get(k);
                
                if (word.startsWith("*")) {
                    String end = word.substring(1);
                    if (end.length() > longestEnd.length()) {longestEnd = end;}
                    starts.add("");
                    ends.add(end);
                }
                else if (word.endsWith("*")) {
                    String beginning = word.substring(0, word.length()-1);
                    if (beginning.length() > longestFirst.length()) {longestFirst = beginning;}
                    starts.add(beginning);
                    ends.add("");
                }
                else {
                    String[] s = word.split("\\*");
                    if (s[0].length() > longestFirst.length()) {longestFirst = s[0];}
                    if (s[1].length() > longestEnd.length()) {longestEnd = s[1];}
                    starts.add(s[0]);
                    ends.add(s[1]);
                }
            }
            
            boolean didFail = false;
            for (int m = 0; m < patterns.size(); m++) {
                if (!longestFirst.contains(starts.get(m))) {
                    System.out.println("Case #" + i + ": *");
                    didFail = true;
                    break;
                }
                else if (!longestEnd.contains(ends.get(m))) {
                    System.out.println("Case #" + i + ": *");
                    didFail = true;
                    break;
                }
            }
            if (!didFail) {
                System.out.println("Case #" + i + ": " + longestFirst + longestEnd);
            }
        }
        input.close();
    }
}