/**
 * Created by cmueh on 04.04.2020.
 */
import java.util.Scanner;

public class Solution {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        for(int t = 0; t < N; t++){
            int v =sc.nextInt();
            int[] start = new int[v];
            int[] end = new int[v];


            for(int i = 0 ; i< v; i++){
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            boolean impossible = true;
            String sol = "";

            for(int i =0; i <= (1<<v); i++){
                String curr = "";
                int mul = 1;
                for(int j = 0; j < v; j++){

                    if( (i & mul) == 0){
                        curr+="J";
                    }else{
                        curr+="C";
                    }
                    mul*= 2;

                }


                //simulate
                boolean nope =false;

                for(int a = 0; a  < v; a++)
                    for(int b = 0; b < v; b++){
                        if(a != b)
                            if(curr.charAt(a)== curr.charAt(b))
                                if(start[a] >= start[b] && start[a] < end[b]){
                                    nope = true;
                                }
                    }

                if(!nope){
                        sol = curr;
                        impossible = false;
                        break;
                }





            }
            if(!impossible)
            System.out.println("Case #"+ (t + 1) + ": " + sol);
            else{
                System.out.println("Case #"+ (t + 1) + ": " + "IMPOSSIBLE");
            }
        }
    }


}
