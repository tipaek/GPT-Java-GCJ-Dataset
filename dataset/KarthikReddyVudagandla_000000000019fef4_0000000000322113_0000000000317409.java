import java.util.*;
import java.lang.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++)
        {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            sc.nextLine();
            String s= sc.nextLine();
            int len = s.length();
            Boolean f=false;
            //System.out.println("len: "+len);
            for(int j=0;j<len;j++){
                if(s.charAt(j) == 'N')Y++;
                if(s.charAt(j) == 'E')X++;
                if(s.charAt(j) == 'W')X--;
                if(s.charAt(j) == 'S')Y--;
                //System.out.println("X: "+X+", Y: "+ Y+", dst: "+(j+1) );
                if( (Math.abs(X)+Math.abs(Y)) <= (j+1) ){
                    f=true;
                    System.out.println("Case #"+i+": "+(j+1));
                    break;
                }



            }
            if(f == false)
            System.out.println("Case #"+i+": IMPOSSIBLE");
            sc.nextLine();


        }
    }
}