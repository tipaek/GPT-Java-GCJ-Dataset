import java.util.Scanner;

/**
 *
 * @author mwpripanggalih
 */
public class Matrik3x3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        int i;
        int j;
        int matrikA[][] = new int[4][4];
        int matrikB[][] = new int[4][4];
        int jumlah[][] = new int[4][4];

        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                System.out.print("Matrik A " + i + "." + j + "= ");
                matrikA[i][j] = input.nextInt();
            }
        }
        System.out.println();

        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                System.out.print("Matrik B " + i + "." + j + "= ");
                matrikB[i][j] = input.nextInt();
            }
        }

        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                jumlah[i][j] = matrikA[i][j] + matrikB[i][j];
            }
        }
        System.out.println("\n Matrik A \n");
        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                System.out.print("  " + matrikA[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nMatrik B\n");
        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                System.out.print("  " + matrikB[i][j]);
            }
            System.out.println();
        }
        System.out.println("\nMatrik A + Matrik B\n");
        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                System.out.print("  " + jumlah[i][j]);
            }
            System.out.println();
        }
    }
}

