import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int m =0;m<n;m++){
            int dim =in.nextInt();
            int traza = 0;
            int[][] matriz = new int[dim][dim];

            for(int i=0;i<dim;i++){
                for(int j=0;j<dim;j++){
                    int s=in.nextInt();
                    matriz[i][j]=s;
                    if(i==j){
                        traza +=s;
                    }
                }
            }

            int filasrep=0;
            int columrep=0;

            for(int i=0;i<dim;i++){
                HashSet<Integer> rep = new HashSet<>();
                for(int j=0;j<dim;j++){
                    if(rep.contains(matriz[i][j])){
                        filasrep++;
                        break;
                    }else{
                        rep.add(matriz[i][j]);
                    }

                }
            }

            for(int i=0;i<dim;i++){
                HashSet<Integer> rep = new HashSet<>();
                for(int j=0;j<dim;j++){
                    if(rep.contains(matriz[j][i])){
                        columrep++;
                        break;
                    }else{
                        rep.add(matriz[j][i]);
                    }

                }
            }

            System.out.println("Case #"+m+": "+traza+" "+filasrep+" "+columrep);

        }

    }
}

