import java.util.Scanner;

public class Solution{

    public static void main(String []args){
        int amount;

        Scanner in = new Scanner(System.in);
        amount = Integer.parseInt(in.nextLine());

        for (int i = 0; i<amount; i++){

            String input = in.nextLine();

            int R = Integer.parseInt(input.split(" ")[0]);
            int S = Integer.parseInt(input.split(" ")[1]);

            double v = 0.5 * R;
            int n = (S-1) * (int)Math.ceil(v);

            System.out.println("Case #" + (i + 1) + ": " + n);

            for (int j = 1; j < S; j++ ){
                for (int c = 1; c < R+1; c+=2){
                    int implm;
                    if (c!=R) {implm = 2;} else {implm=1;}
                    int A = j*implm; //j=1, c=2
                    int B = j*(R-c-1);
                    if (c==R) B =0;
                    B += (c-1) * (j+1);
                    B+= 1;
                    System.out.println(A + " "+ B);
                }
            }
        }
    }
}