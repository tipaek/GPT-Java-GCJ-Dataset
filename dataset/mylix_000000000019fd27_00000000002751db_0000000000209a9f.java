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
            //System.out.println(str);
            String res = "";
            int currentLevel = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i)-'0' > currentLevel){
                    for(int h = 0; h < (str.charAt(i)-'0') - currentLevel; h++) {
                        res += "(";

                    }
                    currentLevel+=  (str.charAt(i)-'0') - currentLevel;


                }else if(str.charAt(i)-'0' < currentLevel){
                    for(int h = 0; h < currentLevel - (str.charAt(i)-'0'); h++) {
                        res += ")";

                    }
                    currentLevel -= currentLevel - (str.charAt(i)-'0');
                }

                res += str.charAt(i);

            }
            if(currentLevel > 0){
               for(int j = 0; j < currentLevel; j++){
                   res += ")";

               }
            }



            System.out.println("Case #"+(t+1) + ": " + res );
        }




    }

}
