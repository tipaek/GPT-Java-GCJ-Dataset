import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int z=1; z<=t; z++){
            int x=s.nextInt(), y=s.nextInt();
            String a=s.next();
            int count=0;
            boolean flag=false;
            while(count<a.length()){
                if(a.charAt(count)=='S')
                    y--;
                else if(a.charAt(count)=='E')
                    x++;
                else if(a.charAt(count)=='W')
                    x--;
                else
                    y++;
                count++;
                if((x+Math.abs(y))<=count) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                System.out.println("Case #"+z+": "+count);
            else
                System.out.println("Case #"+z+": Impossible");
        }
    }
}