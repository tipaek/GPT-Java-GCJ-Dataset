import java.io.*;
import java.util.*;

public class ParteningParentingReturns {
    public static void main(String[] args){
        Scanner sca= new Scanner(System.in);
        int casos=sca.nextInt();
        for(int i=1; i<=casos; i++){
            int actividades=sca.nextInt();
            int actividades2[][] = new int [actividades][2]  ;
            for(int j=0; j<actividades; j++){
                for(int k=0; k<2; k++){
                    actividades2[j][k]=sca.nextInt();
                }
            }
            String salida="";
            int actaltiempo[]=new int[actividades];
            int concatenados[]=new int[actividades];
            for(int p=0;p<actividades;p++)
                concatenados[p]=0;
            for(int j=0; j<actividades; j++){
               int flag=0;
                    for(int l=j;l<actividades;l++){
                            if((actividades2[j][0]>actividades2[l][0] 
                               && actividades2[j][0]<actividades2[l][1]) ||((actividades2[j][1]>actividades2[l][0] 
                               && actividades2[j][1]<actividades2[l][1]) && l!=j )){
                                flag=1;
                                actaltiempo[j]++;
                                concatenados[l]=j;
                            }    
                
                 }
                  
                  if(concatenados[j]!=0)
                     salida+="J";
                  else
                        salida+="C";   
                
            }
            boolean flag2=false;
            for(int j=0;j<actividades;j++){
                if(actaltiempo[j]>1)
                    flag2=true;
            }
            
            if(flag2)
               System.out.println("Case #"+i+": "+"IMPOSIBLE");
            else
                {
                System.out.println("Case #"+i+": "+salida);
                }
        }
    }
}
