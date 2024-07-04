import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=1; i<=t; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            String s2 = s.next();       
            int j=0;
            boolean flag = true;
            for(; j<s2.length(); j++){
                if(s2.charAt(j) == 'N')
                    y++;
                else if(s2.charAt(j) == 'E')
                    x++;
                else if(s2.charAt(j) == 'W')
                    x--;
                else if(s2.charAt(j) == 'S')
                    y--;
                if((Math.abs(x)+Math.abs(y)) <= j+1){
                    int c = j+1;
                    System.out.println("Case #"+i+": "+c);
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
}
