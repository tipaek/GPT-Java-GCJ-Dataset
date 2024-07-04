import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt ();
        for(int x=1;x<=t;x++){
            int n = in.nextInt ();
            int[][] arr = new int[n][n];
            int row =0,col =0,k=0;
            ArrayList<Integer> list = new ArrayList<>();

            for(int r=0;r<n;r++){
                int count =0;
                for(int c = 0;c<n;c++){
                    arr[r][c] = in.nextInt ();

                    if(c>0 && list.contains (arr[r][c])){
                        count++;
                    }

                    list.add (arr[r][c]);

                    if(r==c){
                        k += arr[r][c];
                    }

                }

                if(count >0){
                    row++;
                }

                list.clear ();
            }

            for(int c = 0;c<n;c++){
                for(int r=0;r<n;r++){
                    if(r>0 && list.contains (arr[r][c])){
                        col++;
                        break;
                    }
                    list.add (arr[r][c]);
                }

                list.clear ();
            }

            System.out.println ("Case #"+x+": "+k+" "+row+" "+col);

        }





    }


}