import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<int[]> intervalos = new ArrayList<>();
            for(int j=0; j<n; j++){
                int[] intervalo = {in.nextInt(),in.nextInt()};
                intervalos.add(intervalo);
            }
            String out = profundidad(new ArrayList<>(), new ArrayList<>(), intervalos, "");
            System.out.println("Case #" + i + ": " + out);
        }
    }

    private static String profundidad(List<int[]> lista_c, List<int[]> lista_d, List<int[]> intervalos, String resultado){
        if(intervalos.isEmpty()){
            return resultado;
        }
        else {
            for (int[] intervalo : intervalos) {
                List<int[]> newIntervalos = new ArrayList<>(intervalos);
                newIntervalos.remove(intervalo);
                if (posible(lista_c, intervalo)) {
                    lista_c.add(intervalo);
                    return profundidad(lista_c, lista_d, newIntervalos, resultado + "C");
                } else if (posible(lista_d, intervalo)) {
                    lista_d.add(intervalo);
                    return profundidad(lista_c, lista_d, newIntervalos, resultado + "J");
                }
            }
            return "IMPOSSIBLE";
        }
    }

    private static boolean posible(List<int[]> lista, int[] intervalo){
        for(int[] actual : lista){
            if( (actual[0] <= intervalo[0] && actual[1] > intervalo[0])  ||
                (actual[0] < intervalo[1] && actual[1] >= intervalo[1]))
                return false;
        }
        return true;
    }
}