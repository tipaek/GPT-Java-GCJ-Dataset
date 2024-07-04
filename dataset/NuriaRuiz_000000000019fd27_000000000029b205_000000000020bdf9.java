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
                Integer numActividades = Integer.parseInt(data);
                // Tendremos asociadas los horarios de las actividades
                Map<Integer, List<Integer>> mapActividades = new HashMap<>();
                // Tendremos asociados si tiene solapamientos
                Map<Integer, String> mapTieneSolapamientos = new HashMap<>();
                // Tendremos los solapamientos
                Map<Integer, List<Integer>> mapSolapamientos = new HashMap<>();
                // Finalmente agruparemos las activiades que se pueden hacer juntas
                List<List<Integer>> listaActividadesAgrupadas = new ArrayList<List<Integer>>();
                // Recorremos las actividades
                for (int iAct = 0; iAct<numActividades; iAct++){
                    data = myReader.nextLine();
                    String[] numerosFila = data.split("\\s");
                    // Hora inicial
                    Integer horaInicial = Integer.parseInt(numerosFila[0]);
                    // Hora final
                    Integer horaFinal = Integer.parseInt(numerosFila[1]);
                    // Lista de solapamientos
                    List<Integer> solapamientos = new ArrayList<>();
                    for (Map.Entry<Integer, List<Integer>> actividad : mapActividades.entrySet()) {
                        if ((horaInicial > actividad.getValue().get(0) && horaInicial < actividad.getValue().get(1)) ||
                                (horaFinal < actividad.getValue().get(1) && horaFinal > actividad.getValue().get(0))){
                            solapamientos.add(actividad.getKey());
                        }
                    }
                    // Guardamos listado de solapamientos
                    mapSolapamientos.put(iAct, solapamientos);
                    // Insertamos la actividad
                    List<Integer> horasActividad = new ArrayList<>();
                    horasActividad.add(horaInicial);
                    horasActividad.add(horaFinal);
                    mapActividades.put(iAct, horasActividad);
                }

                // Recorremos los solapamientos
                for (Map.Entry<Integer, List<Integer>> actividad : mapActividades.entrySet()) {
                    if (listaActividadesAgrupadas.size() > 0) {
                        Boolean listaOK = true;
                        for (List<Integer> listaActualAgrupada : listaActividadesAgrupadas) {

                            if (mapSolapamientos.get(actividad.getKey()).size() > 0) {
                                // Actividad con solapamientos
                                listaOK = true;
                                for (Integer actividadSolapa : mapSolapamientos.get(actividad.getKey())) {
                                    if (listaActualAgrupada.contains(actividadSolapa)) {
                                        listaOK = false;
                                    }
                                }
                            }
                            if (listaOK){
                                listaActualAgrupada.add(actividad.getKey());
                                listaOK = true;
                                break;
                            }

                        }
                        // Si no se han encontrado solapamientos se puede anyadir
                        if (!listaOK) {
                            // Creamos nueva lista
                            List<Integer> listaNueva = new ArrayList<>();
                            listaNueva.add(actividad.getKey());
                            listaActividadesAgrupadas.add(listaNueva);
                
                        }
                        listaOK = true;
                    }else{
                        List<Integer> listaNuevaAgrupada = new ArrayList<>();
                        listaNuevaAgrupada.add(actividad.getKey());
                        listaActividadesAgrupadas.add(listaNuevaAgrupada);
                    }
                }
                String result = "Case #"+(mat+1)+": ";
                if (listaActividadesAgrupadas.size() > 2){
                    result = result.concat("IMPOSSIBLE");

                }else{
                    for (int act = 0; act<numActividades; act++) {
                        // Lista 0 sera de J
                        if (listaActividadesAgrupadas.get(0).contains(act)) {
                            result = result.concat("J");
                        } else {
                            result = result.concat("C");
                        }
                    }
                }
                System.out.println(result);
            }


            myReader.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
