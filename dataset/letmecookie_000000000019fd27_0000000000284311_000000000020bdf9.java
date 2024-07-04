import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Pair{
    int key;
    int value;
}

public class Solution {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 1; i<= t; i++){
            int n = in.nextInt();
            String res = "";
            Pair c = new Pair();
            c.key = 0;
            c.value = 0;
            Pair j = new Pair();
            j.key = 0;
            j.value = 0;


            for(int k = 0; k<n;k++){
                Pair pair = new Pair();
                pair.key = in.nextInt();
                pair.value = in.nextInt();
                if(res != "IMPOSSIBLE"){
                    if(pair.key < c.value){
                        if(pair.key < j.value){
                            res = "IMPOSSIBLE";
                        }
                        else if(pair.key >= j.value){
                            j = pair;
                            res+= "J";
                        }

                    }
                    else if(pair.key >= c.value){
                        c = pair;
                        res += "C";
                    }
                }



            }

            System.out.println("Case #" + i+": " + res);







        }
    }

}
