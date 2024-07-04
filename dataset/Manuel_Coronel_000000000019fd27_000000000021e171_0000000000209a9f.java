import java.util.ArrayList;
import java.util.Scanner;

class dato {

    int num;
    char numchar;
    int Repeticion;

    public dato(char numchar, int cantidad) {
        this.numchar = numchar;
        this.Repeticion = cantidad;
        num = numchar - '0';
    }

}

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();
        for (int z = 1; z <=casos; z++) {
            ArrayList<dato> numeros = new ArrayList<dato>();
            String cadena = sc.next();

            char actual = 'a';
            for (int i = 0; i < cadena.length(); i++) {
                if (actual == cadena.charAt(i)) {
                    numeros.get(numeros.size() - 1).Repeticion++;
                } else {
                    numeros.add(new dato(cadena.charAt(i), 1));
                    actual = cadena.charAt(i);
                }
            }
            String rta = "";
            boolean incial = true;
            boolean izquierda = false;
            boolean derecha = false;
  

            for (int i = 0; i < numeros.get(0).num; i++) {

                rta += "(";

            }
            for (int i = 0; i < numeros.get(0).Repeticion; i++) {
                rta += numeros.get(0).numchar;
            }
         
            //////////////////////////////////////////////7
            for (int i = 0; i <numeros.size()-1; i++) {

                if (numeros.get(i).num > numeros.get(i + 1).num) {
                    izquierda = true;
                    derecha=false;
                } else {
                    derecha = true;
                    izquierda=false;
                }

                for (int j = 0; j < Math.abs(numeros.get(i).num-numeros.get(i+1).num); j++) {
                    if (izquierda) {
                        rta += ")";
                    } else {
                        rta += "(";
                    }

                }
                for (int k = 0; k < numeros.get(i+1).Repeticion; k++) {
                    rta += numeros.get(i+1).numchar;
                }

            }
            ///////////////////
            
            
               for (int i = 0; i < numeros.get(numeros.size()-1).num; i++) {

                rta += ")";

            }
         
            System.out.println("Case #"+z+": "+rta);
            
        }

    }
}



