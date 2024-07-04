
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases=0;
        try {
            testCases = sc.nextInt();
        } catch (InputMismatchException e){
            sc.nextLine();
        }

        for (int i = 0; i < testCases; i++){
            int activities = 0;
            try {
                activities = sc.nextInt();
            } catch (InputMismatchException e){
                sc.nextLine();
            }
            boolean[] C = new boolean[1441];
            boolean[] J = new boolean[1441];
            String whoDoesWhat = "";

            for (int j = 0; j < activities; j++){
                boolean cIsFree = true;
                boolean jIsFree = true;
                int start = 0;
                int end = 0;
                try {
                    start = sc.nextInt();
                } catch (InputMismatchException e){
                    sc.nextLine();
                }
                try {
                    end = sc.nextInt();
                } catch (InputMismatchException e){
                    sc.nextLine();
                }


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
