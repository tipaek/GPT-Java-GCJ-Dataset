import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = sc.nextInt();
        for(int i =1;i<=T;i++){
            String result = "";
            int N = sc.nextInt();
            // System.out.println(T+" " +N);
            int[][] C = new int[N][2];
            int[][] J = new int[N][2];
            int Cp = 0;
            int Jp = 0;
            for(int j=0;j<N;j++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                //System.out.println("Current Values "+s+"  "+e);
                if(Cp == 0){
                    C[Cp][0] = s;
                    C[Cp][1] = e;
                    Cp++;
                    result += "C";
                   // System.out.println("Values added to C "+s+"  "+e);
                } 
                else{
                    // System.out.println(Cp);
                    Boolean conflict = false;
                    for(int k=0;k<Cp;k++){
                        //System.out.println("Checking with "+ s + "  "+e+ "    " +C[k][0]+" "+ C[k][1]); 
                        if(s < C[k][1] && s >= C[k][0]){
                            conflict = true;
                        }
                        else if(e < C[k][1] && e >= C[k][0]){
                            conflict = true;
                        }
                    }
                    if(!conflict){
                        C[Cp][0] = s;
                        C[Cp][1] = e;
                        Cp++;
                        result += "C";    
                        //System.out.println("Values added to C "+s+"  "+e);
                    }
                    if(conflict){
                        conflict = false;
                        if(Jp == 0){
                            J[Jp][0] = s;
                            J[Jp][1] = e;
                            Jp++;
                            result += "J";
                            //System.out.println("Values added to J "+s+"  "+e);                      
                        }
                        else{
                            for(int l=0;l<Jp;l++){
                                if(s < J[l][1] && s >= J[l][0]){
                                    conflict = true;
                                }
                                else if(e < J[l][1] && e >= J[l][0]){
                                    conflict = true;
                                } 
                            }   
                            
                            if(!conflict){
                                J[Jp][0] = s;
                                J[Jp][1] = e;
                                Jp++;
                                
                                result += "J";
                               
                                //System.out.println("Values added to J "+s+"  "+e);
                            }
                            if(conflict){
                                result = "IMPOSSIBLE";
                                break;
                            }
                        }
                       
                    }
                }              
            }
            System.out.println("Case #"+i+": "+result);
        }
    }
}