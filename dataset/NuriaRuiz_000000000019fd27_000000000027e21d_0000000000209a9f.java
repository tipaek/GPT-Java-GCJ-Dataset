import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            String data = myReader.nextLine();
            Integer numRows = Integer.parseInt(data);
            for (int mat = 0; mat < numRows; mat++) {
                data = myReader.nextLine();
                String[] numerosFila = data.split("");
                List<String> stringFinal = new ArrayList<>();
                for (int i = 0; i < numerosFila.length; i++){
                    Integer val = Integer.parseInt(numerosFila[i]);
                    int countp = 0;
                    for (String ch: stringFinal){
                        if (ch.equals("(")){
                            countp++;
                        }
                        // si hay un cero anterior dejamos de contar parentesis
                        if (ch.equals("0")){
                            countp = 0;
                            break;
                        }
                    }

                    int parToOpen = val-countp;
                    if (countp < val && parToOpen > 0){
                        for (int j = 0; j<parToOpen; j++){
                            // Creamos parentesis
                            stringFinal.add("(");
                        }

                    }
                    stringFinal.add(String.valueOf(val));
                }

                for (int i = numerosFila.length - 1; i >= 0 ; i--) {
                    int contParClose = 0;
                    Integer val = Integer.parseInt(numerosFila[i]);
                    // Nos posicionamos en el numero
                    int posBuena = 0;
                    int numNums = 0;
                    for (int rs = 0; rs<stringFinal.size(); rs++){
                        if (stringFinal.get(rs).equals("(")||stringFinal.get(rs).equals(")")){
                            // tenemos que pasar mas
                            posBuena++;
                        }else{
                            // hemos encontrado otro numero
                            numNums++;
                        }
                        if (numNums==(i+1)) {
                            // salimos del bucle si ya estamos en la posicion correcta
                            break;
                        }
                    }
                    posBuena = posBuena + i + 1;

                    // Recorremos list para buscar cuantos parentesis cerrados hay
                    for (int k = posBuena; k<stringFinal.size(); k++){
                        if (stringFinal.get(k).equals(")")){
                            contParClose++;
                        }else if (stringFinal.get(k).equals("(")){
                            contParClose--;
                        } // habria que descontar los parentesis cerrados
                    }
                    int parCloseToAdd = val-contParClose;
                    if (contParClose < val){
                        // Anyadimos los parentesis cerrados a partir de su posicion
                        for (int j = posBuena; j<posBuena+parCloseToAdd; j++){
                            stringFinal.add(j, ")");
                        }
                    }else if (parCloseToAdd < 0 && val > 0){
                        parCloseToAdd = contParClose-val;
                        for (int n = (posBuena-1); n<(posBuena-1)+parCloseToAdd;n++){
                            stringFinal.add(n, ")");
                            stringFinal.add(n+2, "(");
                        }
                        // Tenemos que eliminar alguno del final
                    }
                    // sino es menor hay que quitar del final alguno
                }
                String finals = "";
                for (int j = 0; j<stringFinal.size(); j++){
                    finals = finals.concat(stringFinal.get(j));
                }
                System.out.println("Case #" + (mat + 1) + ": "+finals);

            }


            myReader.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
