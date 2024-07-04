import java.util.Scanner;

/**
 *
 * @author Yadav's
 */
public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int t1 = 1;t1<=t;t1++){
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            int i = 0;
            for( i = 0; i<m.length();i++){
                if(Math.abs(x)+Math.abs(y)<=i)break;
                if(m.charAt(i)=='S')y--;
                else if(m.charAt(i)=='N')y++; 
                else if(m.charAt(i)=='E')x++;
                else x--; 
            }
            if(i==m.length()&&Math.abs(x)+Math.abs(y)>i)
                System.out.println("Case #"+t1+": IMPOSSIBLE");
            else
                System.out.println("Case #"+t1+": "+i);
        }
    }
}