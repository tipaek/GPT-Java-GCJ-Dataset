import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            Integer numMatrix = myReader.nextInt();
            List<Integer> traces = new ArrayList<>();

            for (int mat = 0; mat < numMatrix; mat++) {
                Integer contRowsEquals = 0;
                List<List<Integer>> listOLists = new ArrayList<List<Integer>>();
                Integer numrows = myReader.nextInt();
                Integer trace = 0;
                for (int i = 0; i < numrows; i++) {
                    ArrayList<Integer> lista = new ArrayList<Integer>();
                    listOLists.add(lista);
                }
                for (int i = 0; i < numrows; i++) {
                    String data = myReader.nextLine();;
                    String[] numerosFila = data.split("\\s+");
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

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
