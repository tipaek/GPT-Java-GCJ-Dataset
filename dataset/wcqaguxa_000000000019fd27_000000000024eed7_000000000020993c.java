import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            Matrix matrix = new Matrix(scanner.nextInt());
            matrix.addElements(scanner);
            System.out.println("Case #"+i+": "+matrix.computeTrace()+" "+matrix.repeatInRows()
                +" "+matrix.repeatInCols());
        }
    }
}

class Matrix {
    private int[][] elements;
    private int size;

    Matrix(int size) {
        this.size = size;
        elements = new int[size][size];
    }

    void addElements(Scanner scanner) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                elements[i][j] = scanner.nextInt();
            }
        }
    }

    int computeTrace() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result+= elements[i][i];
        }
        return result;
    }

    int repeatInRows() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> elems = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (elems.contains(elements[i][j])) {
                    result++;
                    break;
                } else {
                    elems.add(elements[i][j]);
                }
            }
        }
        return result;
    }

    int repeatInCols() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> elems = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (elems.contains(elements[j][i])) {
                    result++;
                    break;
                } else {
                    elems.add(elements[j][i]);
                }
            }
        }
        return result;
    }
}