                                                                                                                                                                                        

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int casos = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i<=casos; i++){
            String s = sc.nextLine();
            String sRes = "";
            for(int j = 0; j<s.length(); j++){
                boolean bool = true;
                int pos = j;
                int cont = 1;
                while(bool && pos < s.length()-1){
                    if(s.charAt(pos) == s.charAt(pos+1)){
                        cont++;
                        pos++;
                    }
                    else{
                        bool = false;
                    }
                }
                String sAux = "";
                if(cont < s.length()){
                    sAux = s.substring(j, pos+1);
                    
                }
                else{
                    sAux = s;
                }
                String a = sAux.substring(0, 1);
                int aux = Integer.parseInt(a);
                for(int k = 1; k<=aux; k++){
                    sAux = "(" + sAux + ")";
                }
                sRes = sRes + sAux;
                j = pos;
            }
            String sAux = "Case #"+i+": ";
            System.out.println(sAux + sRes);
        }
     }
}