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
            String input=sc.next();
            String text="";
            for(int i=0;i<input.length();i++){
                int no= Character.getNumericValue(input.charAt(i));
                int min=Math.min(no,prev);
                text=text.substring(0,text.length()-min);
                if(prev<no){
                    int diff=no-prev;
                    for(int j=0;j<diff;j++)
                        text=text+"(";
                }
                text=text+no;
                for(int j=0;j<no;j++)
                    text=text+")";
            
                prev=no;
            }
            System.out.println("Case #"+(q+1)+": "+text);
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