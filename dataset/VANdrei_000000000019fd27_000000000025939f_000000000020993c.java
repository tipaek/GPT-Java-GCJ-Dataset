import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Integer noOfCases,i,j,n,caz;
        int[][] matrix = new int[100][100];
        String line;
        Scanner scanner = new Scanner(System.in);
        noOfCases= scanner.nextInt();
        for(caz=0;caz<noOfCases;caz++){
            
            n = scanner.nextInt();
            for( i=0;i<n;i++){

                for(j=0;j<n;j++){
                    matrix[i][j]=scanner.nextInt();
                }
            }

            for( i=0;i<n;i++){


                for(j=0;j<n;j++){
                    System.out.println(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
