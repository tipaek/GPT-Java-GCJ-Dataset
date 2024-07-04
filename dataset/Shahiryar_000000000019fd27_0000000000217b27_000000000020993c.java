package trial_code_jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Trial_Code_Jam {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();  //the number of cases
        int[][] square;
        System.out.println("");
        for (int case_ = 1; case_ <= cases; ++case_) {
            int n = in.nextInt();
            int k = 0, r = 0, c = 0;
            square = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    square[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; ++i) {
                k += square[i][i];

            }
            Boolean flag;
            for (int i = 0; i < n; ++i) {
                flag = false;
                for (int j = 0; j < n; ++j) {
                    int current = square[i][j];
                    for(int cm = j+1; cm < n; ++cm) {if (current == square[i][cm]) {r++;flag = true;break;}}
                if(flag){break;}
                }
            }
            for (int j = 0; j < n; ++j)
            {
                flag = false;
                for(int i = 0; i < n; ++i)
                {
                    int current = square[i][j];
                    for(int cm = i+1; cm < n; ++cm) {if (current == square[cm][j]) {c++;flag = true;break;}}
                    if(flag){break;}

                }
            }
            System.out.println("Case #" + case_ + ": " + k + " " + r + " " + c);
        }

    }
}
