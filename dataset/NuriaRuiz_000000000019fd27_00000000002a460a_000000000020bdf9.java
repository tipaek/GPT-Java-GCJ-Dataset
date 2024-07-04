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
                Map<Integer, List<Integer>> mapActividades = new HashMap<>();
                Map<Integer, List<Integer>> mapSolapamientos = new HashMap<>();
                List<List<Integer>> listaActividadesAgrupadas = new ArrayList<>();
                for (int iAct = 0; iAct<numActividades; iAct++){
                    data = myReader.nextLine();
                    String[] numerosFila = data.split("\\s");
                    Integer horaInicial = Integer.parseInt(numerosFila[0]);
                    Integer horaFinal = Integer.parseInt(numerosFila[1]);
                    List<Integer> solapamientos = new ArrayList<>();
                    for (Map.Entry<Integer, List<Integer>> actividad : mapActividades.entrySet()) {
                         if (horaInicial < actividad.getValue().get(1) && 
                            horaFinal > actividad.getValue().get(0)){
                            solapamientos.add(actividad.getKey());

                        }
                    }
                    mapSolapamientos.put(iAct, solapamientos);
                    List<Integer> horasActividad = new ArrayList<>();
                    horasActividad.add(horaInicial);
                    horasActividad.add(horaFinal);
                    mapActividades.put(iAct, horasActividad);
                }

                for (Map.Entry<Integer, List<Integer>> actividad : mapActividades.entrySet()) {
                    if (listaActividadesAgrupadas.size() > 0) {
                        Boolean listaOK = true;
                        for (List<Integer> listaActualAgrupada : listaActividadesAgrupadas) {

                            if (mapSolapamientos.get(actividad.getKey()).size() > 0) {
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
                        if (!listaOK) {
                            List<Integer> listaNueva = new ArrayList<>();
                            listaNueva.add(actividad.getKey());
                            listaActividadesAgrupadas.add(listaNueva);

                        }
                    }else{
                        List<Integer> listaNuevaAgrupada = new ArrayList<>();
                        listaNuevaAgrupada.add(actividad.getKey());
                        listaActividadesAgrupadas.add(listaNuevaAgrupada);
                    }
                }
                int caseAct = mat+1;
                String res = new String();
                if (listaActividadesAgrupadas.size() > 2){
                    res = res.concat("IMPOSSIBLE");

                }else{
                    for (Integer act = 0; act<numActividades; act++) {
                        if (listaActividadesAgrupadas.get(0).contains(act)) {
                            res = res.concat("J");
                        } else {
                            res = res.concat("C");
                        }
                    }
                }
                 System.out.println("Case #"+String.valueOf(caseAct)+": "+res);
            }
            myReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
