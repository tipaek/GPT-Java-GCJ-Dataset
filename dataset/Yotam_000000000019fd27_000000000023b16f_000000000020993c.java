import java.util.Scanner;

class Assignment1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for(int i=0;i<tests;i++){
            int size = scanner.nextInt();
            int trace =0;
            int r =0;
            int c =0;
            int[] N=new int[size];

            int[][] matrix = new int[size][size];
            for(int j=0;j<size*size;j++) {
                matrix[j / size][j % size] = scanner.nextInt();
            }
            for(int j=0;j<size;j++) {
                trace += matrix[j][j];
            }

            for(int j=0;j<size;j++) {
                for (int k=0; k<size;k++) {
                    N[k] = k+1;
                }
                for(int k=0;k<size;k++){
                    if(N[matrix[j][k]-1]==0){
                        r++;
                        break;
                    }
                    N[matrix[j][k]-1]=0;
                }
            }

            for(int k=0;k<size;k++) {
                for (int j=0; j<size;j++) {
                    N[j] = j+1;
                }
                for(int j=0;j<size;j++){
                    if(N[matrix[j][k]-1]==0){
                        c++;
                        break;
                    }
                    N[matrix[j][k]-1]=0;
                }
            }

        System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);

        }


    }
}
