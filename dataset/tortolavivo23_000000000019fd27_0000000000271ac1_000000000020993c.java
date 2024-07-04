import java.util.Scanner;

public class Vestigium {
    public static void main(String[]Args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=1; i<=t; i++){
            int n = in.nextInt();
            int[][]m = new int[n][n];
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    m[j][k]=in.nextInt();
                }
            }
            int traza=0;
            for(int j=0; j<n; j++){
                traza+=m[j][j];
            }
            int r=0;
            for(int j=0; j<n; j++){
                boolean[]visitados= new boolean[n];
                for(int k=0; k<n; k++){
                    if(visitados[m[j][k]-1]){
                        r++;
                        break;
                    }
                    else{
                        visitados[m[j][k]-1]=true;
                    }
                }
            }
            int c=0;
            for(int j=0; j<n; j++){
                boolean[]visitados= new boolean[n];
                for(int k=0; k<n; k++){
                    if(visitados[m[k][j]-1]){
                        c++;
                        break;
                    }
                    else{
                        visitados[m[k][j]-1]=true;
                    }
                }
            }
            System.out.println("Case #"+i+": "+traza+" "+r+" "+c);
        }
    }
}