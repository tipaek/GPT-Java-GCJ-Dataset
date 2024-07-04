
import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++){
            int activities = sc.nextInt();
            boolean[] C = new boolean[2460];
            boolean[] J = new boolean[2460];
            String whoDoesWhat = "";

            for (int j = 0; j < activities; j++){
                boolean cIsFree = true;
                boolean jIsFree = true;
                int start = sc.nextInt();
                int end = sc.nextInt();


                for (int k = start; k < end; k++){
                    if (C[k]){
                        cIsFree = false;
                        break;
                    }
                }
                if (cIsFree){
                    whoDoesWhat += "C";
                    for (int k = start; k < end; k++){
                        C[k] = true;
                    }

                }else{
                    for (int k = start; k < end; k++){
                        if (J[k]){
                            jIsFree = false;
                            break;
                        }
                    }

                    if (jIsFree){
                        whoDoesWhat += "J";
                        for (int k = start; k < end; k++){
                            J[k] = true;
                        }

                    }
                    else{
                        whoDoesWhat = "IMPOSSIBLE";
                        break;
                    }

                }



            }
            System.out.println("Case #" + (i+1) + ": " + whoDoesWhat);


        }


    }
}
