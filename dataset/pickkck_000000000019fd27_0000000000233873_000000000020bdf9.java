import java.util.Scanner;

public class Solution {
     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        for(int i=0; i<casos; i++){
            
            String cadena = "";
            int actividades = sc.nextInt();
            int cI[] = new int [actividades];
            int jI[] = new int [actividades];
            int cF[] = new int [actividades];
            int jF[] = new int [actividades];

            int contadorC=0;
            int contadorJ=0;
            int inicio; int fin; 
            boolean bandera = false;
            for(int k=0; k<actividades; k++){
                inicio = sc.nextInt();
                fin = sc.nextInt();
                if(contadorC==0){
                    cI[contadorC]=inicio;
                    cF[contadorC]=fin;
                    contadorC++;
                    cadena = cadena+"C";
                }else if(contadorJ==0){
                    jI[contadorJ]=inicio;
                    jF[contadorJ]=fin;
                    contadorJ++;
                    cadena = cadena+"J";
                }else{
                    boolean revisa = false;
                    for(int r=0; r<contadorC; r++){
                        if(inicio<=cI[r]&&fin<=cI[r]){
                            cI[contadorC]=inicio;
                            cF[contadorC]=fin;
                            contadorC++;
                            cadena = cadena+"C";
                            revisa = true;
                        }else if(inicio>=cF[r]&&fin>=cF[r]){
                            cI[contadorC]=inicio;
                            cF[contadorC]=fin;
                            contadorC++;
                            cadena = cadena+"C";
                            revisa = true;
                        }
                    }
                    if(!revisa){
                        for(int r=0; r<contadorJ; r++){
                            if(inicio<=jI[r]&&fin<jI[r]){
                                jI[contadorJ]=inicio;
                                jF[contadorJ]=fin;
                                contadorJ++;
                                cadena = cadena+"J";
                                revisa = true;
                            }else if(inicio>=jF[r]&&fin>=jF[r]){
                                jI[contadorJ]=inicio;
                                jF[contadorJ]=fin;
                                contadorJ++;
                                cadena = cadena+"J";
                                revisa = true;
                            }
                        }
                    }
                    if(!revisa){
                        bandera = true;
                    }
                }
            }
            if(bandera){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+(i+1)+": "+cadena);
            }
        }
        
        
     }
}
