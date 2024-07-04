import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for( int i = 0; i < testCases; i++){
            int activities = sc.nextInt();
            String whoDoesWhat = "";
            boolean[] C = new boolean[1441];
            boolean[] J = new boolean[1441];

            for (int j = 0; j < activities; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();

                boolean cIsAvailable = true;
                boolean jIsAvailable = true;

                for (int k = start; k < end; k++){
                    if (C[k]){
                        cIsAvailable = false;
                        break;
                    }
                }

                if (cIsAvailable){
                    whoDoesWhat += "J";
                    for (int k = start; k < end; k++){
                        C[k] = true;
                    }
                }
                else{
                    for (int k = start; k < end; k++){
                        if (J[k]){
                            jIsAvailable = false;
                            break;
                        }
                    }
                    if (jIsAvailable){
                        whoDoesWhat += "C";
                        for (int k = start; k < end; k++){
                            J[k] = true;
                        }
                    } else{
                        whoDoesWhat = "IMPOSSIBLE";
                    }
                }
            }
            System.out.println("Case #" + (i+1) +": " + whoDoesWhat);

        }



    }
}