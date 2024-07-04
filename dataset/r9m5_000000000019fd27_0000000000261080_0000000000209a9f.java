import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static Scanner src = new Scanner(System.in);

    public static void main(String args[]) {


        int t = src.nextInt();
        src.nextLine();
        int caseNum = 1;
        while (t-- > 0) {
            String str = src.nextLine();
            String ans = solve(str);
            print(caseNum,ans);
            caseNum++;
        }
    }

    private static String solve(String str) {
        int count = 0;
        StringBuilder ans = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            int ele = Integer.parseInt(str.charAt(i)+"");

            if(count==ele){
                ans.append(ele);
            }else if(count>ele){

                while(count!=ele){
                    ans.append(")");
                    count--;
                }
                ans.append(ele);
            }else{
                while(count!=ele){
                    ans.append("(");
                    count++;
                }
                ans.append(ele);
            }
        }

        while(count>0){
            ans.append(")");
            count--;
        }
        return ans.toString();
    }

    public static void print(int caseNum, String output){

        System.out.println("Case #"+caseNum+": "+output);
    }

}
