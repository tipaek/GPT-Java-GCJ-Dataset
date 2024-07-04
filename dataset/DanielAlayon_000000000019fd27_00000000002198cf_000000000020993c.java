import java.util.Scanner;

class Main {

    static Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args) {
        long casos = sc.nextLong();
        long aux = 0;
        long aux1=0;
        long aux2=0;
        for (int i = 0; i < casos; i++) {

            int x = sc.nextInt();
            long[][]vec= new long[x][x];
            //llenado de vector
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < x; k++) {
                    vec[j][k] = sc.nextLong();
                }
            }
            for (int j = 0; j < x; j++) {
                if (duplicates(vec[j])) {
                    aux1++;
                }
                long[] columna = new long[vec[j].length];
                for (int k = 0; k < columna.length; k++) {
                    columna[k]=vec[k][j];
                }
                if (duplicates(columna)) {
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

    public static boolean duplicates(long[] array)
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

