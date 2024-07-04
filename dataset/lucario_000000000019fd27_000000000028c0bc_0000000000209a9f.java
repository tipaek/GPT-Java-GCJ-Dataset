import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {

            int prev=0;
            String in=sc.next();
            String text="";
            for(int i=0;i<in.length();i++){
                int no= Character.getNumericValue(in.charAt(i));
                int min=Math.min(n0,prev);
                text=text.substring(0,ans.length()-min);
                if(prev<no){
                    int dif=no-prev;
                    for(int j=0;j<dif;j++)
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
        public int compare(int[] m1, int[] m2)
        {
            return m1[0]-m2[0];
        }
    }

}