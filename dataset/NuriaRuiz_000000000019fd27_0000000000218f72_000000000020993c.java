import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FileWriter myWriter = null;

        try {
            File myObj = new File("a.txt");
            Scanner myReader = new Scanner(myObj);
            myWriter = new FileWriter("filewrited.txt");

            String data = myReader.nextLine();
            Integer numMatrix = Integer.parseInt(data);
            List<Integer> traces = new ArrayList<>();

            for (int mat = 0; mat < numMatrix; mat++) {
                Integer contRowsEquals = 0;
                List<List<Integer>> listOLists = new ArrayList<List<Integer>>();
                data = myReader.nextLine();
                Integer numrows = Integer.parseInt(data);
                Integer trace = 0;
                for (int i = 0; i < numrows; i++) {
                    ArrayList<Integer> lista = new ArrayList<Integer>();
                    listOLists.add(lista);
                }
                for (int i = 0; i < numrows; i++) {
                    data = myReader.nextLine();
                    String[] numerosFila = data.split("\\s+");
                    for(int iv=0;iv<numerosFila.length;iv++){
                        System.out.println(numerosFila[iv]);
                    }
                    trace += Integer.parseInt(numerosFila[i]);
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
                    if (numNumbers.size() < numrows){
                        contRowsEquals++;
                    }

                }
                traces.add(trace);
                Integer columRepe = 0;
                for (List<Integer> columnai : listOLists) {
                    if (columnai.size() < numrows) {
                        columRepe++;
                    }
                }
                    System.out.println("Case #" + (mat + 1) + ": "+String.valueOf(trace) + " "+String.valueOf(contRowsEquals)+" "+String.valueOf(columRepe));
                }

            myReader.close();
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
