import java.util.Scanner;
public class Penjumlahan_Matriks {
    public static void main(String[] args) {
        Scanner masuk = new Scanner (System.in);
        int nilai1 [][] = new int [2][2];
        int nilai2 [][] = new int [2][2];
        int hasil [][] = new int [2][2];
        System.out.println("Masukkan data matriks A : ");
        for (int i=0;i<2;i++){
        for (int j=0;j<2;j++){
            System.out.print("("+ (i+1)+" , "+ (j+1)+") : ");
            nilai1[i][j]=masuk.nextInt();
        }
        }
        System.out.println("Masukkan data matriks B : ");
        for (int k=0;k<2;k++){
        for (int l=0;l<2;l++){
            System.out.print("("+ (k+1)+" , "+ (l+1)+") : ");
            nilai2[k][l]=masuk.nextInt();
        }
        }
        System.out.println("Matriks A");
        for (int i=0;i<2;i++){
        for (int j=0;j<2;j++)
                System.out.print(nilai1[i][j]+" ");
                System.out.println();}
        System.out.println("Matriks B");
        for (int k=0;k<2;k++){
        for (int l=0;l<2;l++)
                System.out.print(nilai2[k][l]+" ");
                System.out.println();}
        for(int x=0;x<2;x++){
        for(int y=0;y<2;y++){
        hasil[x][y]=nilai1[x][y]+ nilai2[x][y];
        }
        }
        System.out.println("Proses Penjumlahan Matriks A Dan B = ");
        for(int x=0;x<2;x++){
        for(int y=0;y<2;y++){
        System.out.print(nilai1[x][y]+ " + "+ nilai2[x][y]+" = "+hasil[x][y]+"   " );
        }
        System.out.println();
        }
        System.out.println("Hasil Penjumlahan Matriks A Dan B = ");
        for(int x=0;x<2;x++){
        for(int y=0;y<2;y++){
        System.out.print(hasil[x][y]+" " );
        }
        System.out.println();
}
    }
}