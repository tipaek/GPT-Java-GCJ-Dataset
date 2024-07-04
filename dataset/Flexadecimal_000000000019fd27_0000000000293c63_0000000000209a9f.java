import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        scan.nextLine();
        for(int caseNum = 0; caseNum < k;caseNum++){
            String nums = scan.nextLine();
            String[] par = new String[nums.length() + 1];
            String firstPar = "";
            for(int i = 0;i<Integer.parseInt(nums.substring(0,1));i++){
                firstPar+="(";
            }
            par[0] = firstPar;
            for(int i = 0;i < nums.length() - 1;i++){
                String add = "";
                int diff = Integer.parseInt(nums.substring(i, i+1)) - Integer.parseInt(nums.substring(i + 1, i + 2));
                while(diff > 0){
                    add += ")";
                    diff--;
                }
                while(diff < 0){
                    add += "(";
                    diff++;
                }
                par[i + 1] = add;
            }
            String lastPar = "";
            for(int i = 0;i<Integer.parseInt(nums.substring(nums.length()-1));i++){
                lastPar+=")";
            }
            par[nums.length()] = lastPar;

            String solution = "";
            for(int i = 0;i<nums.length();i++){
                solution += par[i];
                solution += nums.substring(i, i+1);
            }
            solution += par[nums.length()];

            System.out.printf("Case #%d: %s\n", caseNum+1, solution);
        }
    }
}
