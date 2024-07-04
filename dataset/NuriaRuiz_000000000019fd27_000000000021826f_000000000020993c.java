import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FileWriter myWriter = null;

        try {
            File myObj = new File("a.txt");
            Scanner myReader = new Scanner(myObj);
            myWriter = new FileWriter("filewrited.txt");

            String data = myReader.nextLine();
            // Numero de matrices
            Integer numMatrix = Integer.parseInt(data);
            List<Integer> traces = new ArrayList<>();

            for (int mat = 0; mat < numMatrix; mat++) {
                Integer contRowsEquals = 0;
                List<List<Integer>> listOLists = new ArrayList<List<Integer>>();
                // Leemos filas matriz
                data = myReader.nextLine();
                Integer numrows = Integer.parseInt(data);
                Integer trace = 0;
                // Lista de columna
                for (int i = 0; i < numrows; i++) {
                    // Creamos nueva lista
                    ArrayList<Integer> lista = new ArrayList<Integer>();
                    listOLists.add(lista);
                }
                //Recorremos matriz
                for (int i = 0; i < numrows; i++) {
                    data = myReader.nextLine();
                    // Cargamos array con la primera fila
                    String[] numerosFila = data.split("\\s+");
                    for(int iv=0;iv<numerosFila.length;iv++){
                        System.out.println(numerosFila[iv]);
                    }
                    // Sumamos trace
                    trace += Integer.parseInt(numerosFila[i]);
                    // Vamos guardando los enteros de la fila y sabremos si ya existen
                    List<Integer> numNumbers = new ArrayList<>();
                    for (int j = 0; j < numerosFila.length; j++) {
                        Integer valActual = Integer.parseInt(numerosFila[j]);
                        if (!listOLists.get(j).contains(valActual)) {
                            listOLists.get(j).add(valActual);
                        }
                        if (!numNumbers.contains(valActual)) {
                            numNumbers.add(valActual);
                        }
                    }
                    // si tiene menos elementos es que hay repes
                    if (numNumbers.size() < numrows){
                        contRowsEquals++;
                    }

                }
                traces.add(trace);
                // Recorremos de nuevo las filas
                myWriter.write("Case #" + (mat + 1) + ": ");
                myWriter.write(String.valueOf(trace) + " ");
                // añadimos elementos repetidos
                myWriter.write(String.valueOf(contRowsEquals));
                // tenemos que averiguar columnas repetidas
                Integer columRepe = 0;
                for (List<Integer> columnai : listOLists) {
                    if (columnai.size() < numrows) {
                        columRepe++;
                    }
                }
                myWriter.write(" "+String.valueOf(columRepe));
                myWriter.write("\n");
                }

            myReader.close();
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
