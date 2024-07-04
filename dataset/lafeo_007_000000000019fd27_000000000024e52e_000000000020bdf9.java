import java.util.*;

public class Solution {
    public static void main(String argsp[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); //no. of test cases.

        for (int t = 0; t < T; t++) {
//            int N = 5;
//            int[][] NN = {{99, 150}, {1, 100}, {100, 301}, {2, 5}, {150, 250}};
            int N = sc.nextInt();//number of activities to assign.
            int[][] NN = new int[N][2];
            for(int i = 0; i < N; i++){
                NN[i][0] = sc.nextInt();
                NN[i][1] = sc.nextInt();//we have taken the inputs now.
            }
            //we need to compute then now.
            String CJ = "";
            //sorting the array
            //here we make an array which is in order
            int[][] ORDER = new int[N][1];
            for (int a = 0; a < N; a++) {
                ORDER[a][0] = a;
            }
            for (int i = 0; i < N - 1; i++) {
                for (int k = 0; k < N - i - 1; k++) {
                    if (NN[k][0] > NN[k + 1][0]) {
                        int temp = NN[k][0];
                        int temp2 = NN[k][1];
                        int temp3 = ORDER[k][0];

                        NN[k][0] = NN[k + 1][0];
                        NN[k][1] = NN[k + 1][1];
                        ORDER[k][0] = ORDER[k + 1][0];

                        NN[k + 1][0] = temp;
                        NN[k + 1][1] = temp2;
                        ORDER[k + 1][0] = temp3;
                    }
                }
            }
            int maxForC, currentJ;
            maxForC = NN[0][1];
            currentJ = NN[1][0];; //since the timing can only be assigned if NN[i][1] > the new timing.
            CJ = "C";
            boolean check = true;
            for (int i = 1; i < N; i++) {
                if (NN[i][0] >= maxForC) {
                    CJ += "C";
                    maxForC = NN[i][1];
                } else if(NN[i][0] >= currentJ){
                    CJ += "J";
                    currentJ = NN[i][1];
                }

            }
            String FCJ = "";
            try {
                for (int a = 0; a < N; a++) {
                    FCJ += CJ.charAt(ORDER[a][0]);
                }
            }catch (Exception e){
                check = false;

            }
            if(check)
                System.out.println("Case #"+(t+1)+":"+FCJ);
            else
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
        }
    }
}



