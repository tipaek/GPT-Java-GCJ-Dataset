import java.util.Scanner;


class Vestigium {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numOfCases = input.nextInt();
        int k = 0,r = 0,c = 0;

        int countI = 0;
        while (countI < numOfCases) {
            int sizeOfMatrix = input.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

            int countII = 0, a = 0;
            while (countII < sizeOfMatrix) {
                if (countII == 0) {
                    input.nextLine();
                    String line = input.nextLine();
                    String[] strDigit = line.split(" ");
                    for (int i = a; i < sizeOfMatrix; i++) {
                        for (int j = 0; j < sizeOfMatrix; j++) {
                            matrix[a][j] = Integer.parseInt(strDigit[j]);
                        } //end for-loop
                    } //end for-loop
                } else {
                    String line = input.nextLine();
                    String[] strDigit = line.split(" ");
                    for (int i = a; i < sizeOfMatrix; i++) {
                        for (int j = 0; j < sizeOfMatrix; j++) {
                            matrix[a][j] = Integer.parseInt(strDigit[j]);
                        } //end for-loop
                    } //end for-loop
                }
                a++;
                countII++;
            } //end while-loop

            //trace
            for (int i = 0, j = 0; i < sizeOfMatrix; i++, j++) {
                if (i == j) {
                    k += matrix[i][j];
                }
            } //end for-loop

            //row
            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix - 1; j++) {
                    for (int j2 = j + 1; j2 < sizeOfMatrix; j2++) {
                        if (matrix[i][j] == matrix[i][j2]) {
                            r++;
                            break;
                        }
                    } //end for-loop
                    break;
                } //end for-loop
            } //end for-loop

            //column
            if (sizeOfMatrix == 3) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    for (int i = 0; i < sizeOfMatrix - 1; i++) {
                        for (int i2 = i + 1; i2 < sizeOfMatrix; i2++) {
                            if (matrix[i][j] == matrix[i2][j]) {
                                c++;
                                break;
                            }
                        } //end for-loop
                    } //end for-loop
                } //end for-loop
            }
            if (sizeOfMatrix == 4) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    for (int i = 0; i < sizeOfMatrix - 1; i++) {
                        for (int i2 = i + 1; i2 < sizeOfMatrix; i2++) {
                            if (matrix[i][j] == matrix[i2][j]) {
                                c++;
                                break;
                            }
                        } //end for-loop
                        break;
                    } //end for-loop
                } //end for-loop
            }


            countI++;
            System.out.printf("Case #%d: %d %d %d\n", countI, k, r, c);
            k = 0;
            r = 0;
            c = 0;
        } //end while-loop

    } //end main

} //end class