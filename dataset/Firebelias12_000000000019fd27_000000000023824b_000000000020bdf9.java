import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        int cases = myObj.nextInt();

        for(int i = 0; i < cases; i++){
            String result = "CJ";

            int n = myObj.nextInt();
            int[][] act = new int[n][2];
            for(int j = 0; j < n; j++){
                act[j][0] = myObj.nextInt();
                act[j][1] = myObj.nextInt();
            }

            for(int j = 0; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(act[j][0] > act[k][0] ){
                        int temp1 = act[j][0];
                        int temp2 = act[j][1];
                        act[j][0] = act[k][0];
                        act[j][1] = act[k][1];
                        act[k][0] = temp1;
                        act[k][1] = temp2;
                    }
                }
            }

            if(n != 2){
                for(int j = 2; j < n; j++){
                    if(act[j][0]-act[j-2][1] < 0 && act[j][0]-act[j-1][1] < 0) {
                        result = "IMPOSSIBLE";
                        break;
                    }else if(act[j][0]-act[j-2][1] < 0){
                        result += "J";
                    }else{
                        result += "C";
                    }
                }
            }

            System.out.println("Case #" + (i+1) +": " + result);

        }

    }


}
