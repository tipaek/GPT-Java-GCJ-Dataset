

import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int it = 1;
        while(it<=t){
            String input = s.next();
            String ans = solve(input.split(""));
            System.out.println("Case #"+it+": "+ans);
            it++;
        }
    }

    public static String solve(String[] array){
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(int i=0;i<array.length;i++){
            int temp = Integer.parseInt(array[i]);
            //count is equal
            if(count == temp){
                ans.append(array[i]);
            }
            //count is less
            else if(count < temp){
                int t = temp-count;
                while(t>0){
                    ans.append("(");
                    t--;
                }
                count = temp;
                ans.append(array[i]);
            }
            //count is more
            else{
                int t = count-temp;
                while(t>0){
                    ans.append(")");
                    t--;
                }
                count=temp;
                ans.append(array[i]);
            }
        }
        while(count>0){
            ans.append(")");
            count--;
        }
        return ans.toString();
    }
}