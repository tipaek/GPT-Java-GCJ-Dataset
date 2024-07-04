import java.util.Scanner;

public class Solution {
    
    final static String OPENS  = "(((((((((((";
    final static String CLOSED = ")))))))))))";
    final static String EMPTY = "";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        input.nextLine();
        for(int t = 1; t <= numCases; t++) {
            System.out.print("Case #" + t + ": ");
            System.out.println(solve(input.nextLine()));
        }
        
        input.close();
    }

    static String solve(String digits){
        StringBuilder sb = new StringBuilder();
        int length = digits.length();
        
        int currLevel = 0;
        for(int i = 0; i < length; i++) {
            int d = (int)(digits.charAt(i) - 48);
            if(d > currLevel) {
                sb.append(appendOpen(d - currLevel));
            }
            if(d < currLevel) {
                sb.append(appendClose(currLevel - d));
            }
            sb.append(d);
            currLevel = d;
        }
        sb.append(appendClose(currLevel));

        return sb.toString();
    }
    
    static String appendOpen(int num) {
        return 0 == num ? EMPTY : OPENS.substring(0, num);
    }

    static String appendClose(int num) {
        return 0 == num ? EMPTY : CLOSED.substring(0, num);
    }
}

