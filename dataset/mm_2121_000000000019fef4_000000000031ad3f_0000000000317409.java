import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int z=1; z<=t; z++){
            int x=s.nextInt(), y=s.nextInt();
            String a=s.next();
            int m=0, n=0, count=0;
            while(count<a.length() && !(m==x && y==n)){
                if(a.charAt(count)=='S')
                    y--;
                else
                    y++;
                if(m<x)
                    m++;
                else if(n<y)
                    n++;
                else if(n>y)
                    n--;
                else {
                    count++;
                    break;
                }
                count++;
            }
            if(m==x && y==n)
                System.out.println("Case #"+z+": "+count);
            else
                System.out.println("Case #"+z+": Impossible");
        }
    }
}