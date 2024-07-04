import java.io.*;
import java.util.*;

public class ParteningParentingReturns {
    public static void main(String[] args){
        Scanner sca= new Scanner(System.in);
        int casos=sca.nextInt();
        for(int i=1; i<=casos; i++){
            int actividades=sca.nextInt();
            int actividades2[][] = new int [actividades][actividades]  ;
            for(int j=0; j<actividades; j++){
                for(int k=0; k<actividades; k++){
                    actividades2[j][k]=sca.nextInt();
                }
            }
            String salida="";
            int actaltiempo[]=new int[actividades];
            for(int j=0; j<actividades-1; j++){
                boolean flag=false;
                for(int k=0; k<actividades-1; k++){
                    if(actividades2[j][k]>actividades2[j+1][k+1]){
                        flag=true;
                        actaltiempo[j]++;
                    }
                    if(flag)
                     salida+="J";
                    else
                        salida+="C";
                }
            }
            boolean flag=false;
            for(int j=0;j<actividades;j++){
                if(actaltiempo[j]>2)
                    flag=true;
            }
            
            if(flag)
               System.out.println("Case #"+casos+": "+"IMPOSIBLE");
            else
                {
                System.out.println("Case #"+casos+": "+salida);
                }
        }
    }
}