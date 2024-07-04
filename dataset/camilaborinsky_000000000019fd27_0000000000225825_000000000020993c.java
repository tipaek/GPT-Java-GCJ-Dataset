import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TraceProject {
    public static void main(String[] args) {
        Scanner scr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scr.nextInt();
       

        List<int[]> output = new ArrayList<>();

        for(int i = 0; i < t; i++){
            int[][] mat;
            int dimI;

            
            dimI= scr.nextInt();
            mat = new int[dimI][dimI];
            for(int j=0 ; j < dimI ; j++){
                for( int k = 0; k < dimI ; k++){
                    mat[j][k] = scr.nextInt();
                }
            }
            int[] out = new int[t];
            out = getResults(mat, dimI);

            System.out.println("Case #"+(i+1)+": "+out[0]+" "+out[1]+" "+out[2]);
        }



    }

    public static int[] getResults(int[][] mat, int dim){
        boolean foundRep;
        int[] toRet = {0,0,0};
        for(int i=0 ; i < dim ; i++){
            foundRep = false;
            for(int j = 0 ; j < dim && !foundRep; j++){
                for(int k = j+1 ; k < dim && !foundRep ; k++){
                    if(mat[i][j] == mat[i][k]){
                        foundRep=true;
                        toRet[1]++;
                    }

                }
            }
            toRet[0]+=mat[i][i];
        }
        for(int i=0 ; i < dim ; i++){
            foundRep = false;
            for(int j = 0; j < dim && !foundRep ; j++){
                for(int k = j+1 ; k < dim && !foundRep ; k++){
                    if(mat[j][i] == mat[k][i]){
                        foundRep = true;
                        toRet[2]++;
                    }
                }
            }
        }
        return toRet;

    }


}
