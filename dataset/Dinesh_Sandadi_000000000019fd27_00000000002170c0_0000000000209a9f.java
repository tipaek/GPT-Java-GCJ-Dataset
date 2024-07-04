import java.util.Scanner;

public class Solution {

    private void printAnswer(int T,String ans){
        System.out.println("Case #" + T + ": " +ans);
    }

    private String findAnswer(String input){

        int st = 0;
        StringBuilder ans = new StringBuilder();

        int open = 0;
    int count = 0;
        while(st <= input.length()){

            char curr = (st < input.length() ? input.charAt(st):'0');

            count = curr - '0';

            while(open > count){
                ans.append(")");
                open--;
            }

            while(open < count){
                ans.append("(");
                open++;
            }
            if(st == input.length())
                break;
            while(st < input.length() && input.charAt(st) == curr){
                ans.append(input.charAt(st));
                st++;
            }

        }

        return ans.toString();
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        Solution s1 = new Solution();
        int count = 1;
        while(count <= T) {
            String s = sc.nextLine();
            s1.printAnswer(count, s1.findAnswer(s));
            count++;
        }
    }
}
