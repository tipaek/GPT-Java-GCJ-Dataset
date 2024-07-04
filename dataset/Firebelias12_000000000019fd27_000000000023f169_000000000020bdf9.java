import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        int cases = myObj.nextInt();


        for(int i = 0; i < cases; i++){
            String result = "CJ";
            int n = myObj.nextInt();
            int[][] act = new int[n][3];

            for(int j = 0; j < n; j++){
                act[j][0] = myObj.nextInt();
                act[j][1] = myObj.nextInt();
                act[j][2] = j;
            }

            for(int j = 0; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(act[j][0] > act[k][0] ){
                        int temp1 = act[j][0];
                        int temp2 = act[j][1];
                        int temp3 = act[j][2];
                        act[j][0] = act[k][0];
                        act[j][1] = act[k][1];
                        act[j][2] = act[k][2];
                        act[k][0] = temp1;
                        act[k][1] = temp2;
                        act[k][2] = temp3;
                    }
                }
            }

            int endC = act[0][1];
            int endJ = act[1][1];

            if(n != 2){
                for(int j = 2; j < n; j++){
                    if(endJ > act[j][0] && endC > act[j][0]) {
                        result = "IMPOSSIBLE";
                        break;
                    }else{
                        if(endJ > act[j][0]){
                            endC = act[j][1];
                            result += "C";
                        }else{
                            endJ = act[j][1];
                            result += "J";
                        }
                    }
                }
            }

            if(!result.equals("IMPOSSIBLE")){

                char[] res = new char[n];
                for(int j = 0; j < n; j++){
                    res[act[j][2]] = result.charAt(j);
                }

                result = String.valueOf(res);

            }


            System.out.println("Case #" + (i+1) +": " + result);

        }

    }


}
