    import java.util.*;
    import java.io.*;
public class Solution{

     public static void main(String []args){
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = input.nextInt();
        for(int t = 1; t <= testCase; t++ ){
            String y = "";
            int[] J = {0, 0};
            int[] C = {0, 0};
            int N = input.nextInt();
            int[] timeSlot = new int[2];
            for(int n = 0; n < N; n++){
                timeSlot[0] = input.nextInt();
                timeSlot[1] = input.nextInt();
                if (J[1] <= timeSlot[0] || J[0] >= timeSlot[1]){
                    J[0] = timeSlot[0];
                    J[1] = timeSlot[1];
                    y = y.concat("J");
                }  else if (C[1] <= timeSlot[0] || C[0] >= timeSlot[1]){
                    C[0] = timeSlot[0];
                    C[1] = timeSlot[1];
                    y = y.concat("C");
                } else {
                    y = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + t + ": " + y);
        }
     }
}