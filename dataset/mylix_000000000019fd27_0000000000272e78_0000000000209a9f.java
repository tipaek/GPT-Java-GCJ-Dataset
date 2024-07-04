/**
 * Created by cmueh on 04.04.2020.
 */
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        for(int t = 0; t < N; t++){
            String str = sc.next();

            String res = "";
            boolean para =false;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '0' && para){
                    res += ")";

                    para = false;
                }else if(str.charAt(i) == '1' &&!para){
                    res+= "(";
                    para = true;
                }

                res+= str.charAt(i);

            }
            if(para){
                res+= ")";
            }



            System.out.println("Case #"+(t+1) + ": " + res );
        }




    }

}
