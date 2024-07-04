
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int casos = sc.nextInt();
        int aux = 0;
        int aux1=0;
        int aux2=0;
        for (int i = 0; i < casos; i++) {

            int x = sc.nextInt();
            int[][] vec = new int[x][x];
            //llenado de vector
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < x; k++) {
                    vec[j][k] = sc.nextInt();
                }
            }
            for (int j = 0; j < x; j++) {
                if (duplicates(vec[j])) {
                    aux1++;
                }
                int[] columna = new int[vec[j].length];
                for (int k = 0; k < x; k++) {
                    columna[k]=vec[k][j];
                }
                if (duplicates_Columna(columna)) {
                    aux2++;
                }
                
            }

            //suma diagonal
            for (int j = 0; j < x; j++) {
                aux += vec[j][j];
            }
            //impresion
            System.out.println("Case #" + (i + 1) + ": " + aux+" "+aux1+" "+aux2);
            aux = 0;
            aux1 = 0;
            aux2 = 0;

        }

    }

    public static boolean duplicates(int[] array)
    {
        for (int i = 0; i<array.length; i++) 
        {
            for(int j = 0; j<array.length; j++)
            {
                if (i != j && array[i] == array[j])
                {
                    return true;
                }
            }    
        }
        return false;
    }
    
    public static boolean duplicates_Columna(int[] array)
    {
        for (int i = 0; i<array.length; i++) 
        {
            for(int j = 0; j<array.length; j++)
            {
                if (i != j && array[i] == array[j])
                {
                    return true;
                }
            }    
        }
        return false;
    }

}
