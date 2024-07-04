import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String [] args){
        int i,y,z,T,N,count;
        Scanner m =new Scanner (new BufferedReader(new InputStreamReader(System.in)));

        T = m.nextInt();
        int [][]M = new int [50][50];
        for(i=0;i<T;i++) {
            N = m.nextInt();

            int r=0,c=0,k=0,x=i+1;

            for (y = 0; y < N; y++) {
                for (z = 0; z < N; z++) {
                    M[y][z] = m.nextInt();
                    if(y==z)
                        k=k+M[y][z];
                }
            }

            for (y = 0; y <N; y++) {
                int count_column=0;
                for (z = 0; z < N; z++) {
                    int num = M[z][y];
                    for (count = z+1; count < N; count++) {

                        if (num == M[count][y]&& count_column==0) {
                            count_column = 1;
                            c += 1;
                        }
                        else
                            if(count_column==1)
                                break;
                    }
                    if(count_column==1)
                        break;
                }
            }

            for (y = 0; y <N; y++) {
                int count_row=0;
                for (z = 0; z < N; z++) {
                    int num = M[y][z];
                    for (count = z+1; count < N; count++) {
                        if (num == M[y][count]&& count_row==0) {
                            count_row = 1;
                            r += 1;
                        }
                        else
                        if(count_row==1)
                            break;
                    }
                    if(count_row==1)
                        break;
                }
            }

            System.out.println("Case #"+x+": "+k+" "+r+" "+c);

        }
        return 0;
    }
}