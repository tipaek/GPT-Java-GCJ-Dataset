import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {

            int prev=0;
            String in=sc.next();
            String ans="";
            for(int i=0;i<in.length();i++){
                int num= Character.getNumericValue(in.charAt(i));
                int min=Math.min(num,prev);
                ans=ans.substring(0,ans.length()-min);
                if(prev<num){
                    int dif=num-prev;
                    for(int j=0;j<dif;j++)
                        ans=ans+"(";
                }
                ans=ans+num;
                for(int j=0;j<num;j++)
                    ans=ans+")";
                //System.out.println(ans);
                prev=num;
            }
            System.out.println("Case #"+(q+1)+": "+ans);
        }
    }
    static class StartComparator implements Comparator<int[]>
    {
        public int compare(int[] c1, int[] c2)
        {
            return c1[0]-c2[0];
        }
    }

}
