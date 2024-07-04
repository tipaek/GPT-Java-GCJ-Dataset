import java.util.Scanner;

public class Solution {

    public static String generateOpenParanthesis(int n)
    {
        String res = "";
        while(n-- > 0){
            res += "(";
        }
        return res;
    }
    public static String generateCloseParanthesis(int n)
    {
        String res = "";
        while(n-- > 0){
            res += ")";
        }
        return res;
    }

    public static String compute(String s, int n){
        int noOfBrackets = 0;
        String res = "";
        for(int i=0;i<n;i++){
            int val = s.charAt(i) - '0';
            if(val==noOfBrackets){
                res += s.charAt(i);
            }
            else if(val > noOfBrackets){
                int newBrackets = val - noOfBrackets;
                res += generateOpenParanthesis(newBrackets) + s.charAt(i);
                noOfBrackets += newBrackets;
            }
            else {
                int newBrackets = noOfBrackets - val;
                res += generateCloseParanthesis(newBrackets) + s.charAt(i);
                noOfBrackets -= newBrackets;
            }
        }
        if(noOfBrackets > 0){
            res += generateCloseParanthesis(noOfBrackets);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 1;
        while(cnt <= t){
            String s = sc.next();
            System.out.println("Case #"+cnt+ ": " + compute(s,s.length()));
            cnt++;
        }
    }
}