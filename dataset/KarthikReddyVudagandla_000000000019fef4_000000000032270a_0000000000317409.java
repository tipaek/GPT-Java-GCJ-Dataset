import java.util.*;
import java.lang.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= T; i++)
        {
            String temp= sc.nextLine();
            String[] temp1=temp.split(" ");
            int X = Integer.parseInt(temp1[0]);
            int Y = Integer.parseInt(temp1[1]);

            String s= temp1[2];
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



        }
    }
}