import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            int count=0;
            ArrayList<Integer> ans=new ArrayList<>();
            for(int j=1;j<r;j++)
            {
                for(int k=1;k<s;k++)
                {
                    ans.add(r-j+1);
                    int value=(s-1-k)*(r-j+1);
                    value+=(k)*(r-j);
                    ans.add(value);
                    count++;
                }

            }
            System.out.println("Case #" + i + ": " +count);
            for(int j=0;j<count*2;j+=2)
                System.out.println(ans.get(j)+" "+ans.get(j+1));
        }
    }
}
