import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    
    static String Next(ArrayList<String> ar2, Scanner scan){
        int A = 0;
        int A1 = ar2.size();
        int B = 0;
        int C = 0;
        int D = 0;

        int[] ar = new int[ar2.size()];
        String[] temp = ar2.toArray(new String[0]);

        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(temp[i]);
        }


        while (A < A1){
            B = ar[A];
            if (C < B){
                for (int i = D; i < D + B - C; i++) {
                    ar2.add(i, "(" );
                }

                D += (B - C) + 1;
                C = B;
                A++;
            } else if (C > B){
                for (int i = D ; i < D + C - B; i++) {
                    ar2.add(i, ")" );
                }
                D += (C - B) + 1;
                C = B;
                A++;
            } else {
                A++;
                D++;
            }

        }

        for (int i = 0; i < C; i++) {
            ar2.add(")" );
        }
        StringBuffer sb = new StringBuffer();
        String[] temp2 = ar2.toArray(new String[0]);

        for (int i = 0; i < temp2.length; i++) {
            sb.append(temp2[i]);    
        }
        String last = sb.toString();
        

        return last;
    }

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        
        String Y = scan.nextLine();
        

        int X = 1;
        ArrayList<String> ar2 = new ArrayList<String>();
        for (int i = 0; i < N; i++) {

            String K = scan.nextLine();


            for (int j = 0; j < K.length(); j++) {
                ar2.add(Character.toString(K.charAt(j)));
            }


            System.out.println("Case #" + X + ": " + Next(ar2, scan));
            X++;
            ar2.clear();
        }



        scan.close();

        }

}
