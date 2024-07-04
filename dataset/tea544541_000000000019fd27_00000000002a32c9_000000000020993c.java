import java.util.Scanner;

/**
 *
 * @author owen
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #"+i+":");
            int wrongc=0;
            int wrongr=0;
            int trace=0;
           int n= in.nextInt();
           int [] arrS= new int[n*n];
            for (int j = 0; j < (n*n); j++) {
                arrS[j]=Integer.parseInt(in.next());
                 
            }
            for (int p = 0; p < n; p++) {
                boolean errorR=false;
                boolean errorC=false;
                
                for (int b = 0; b < n; b++) {
                    
                
                
                for (int q = 0; q < n; q++) {
                  if (arrS[(p*n)+q]<=n && arrS[(p*n)+q]>=1  ) {  
                   if(arrS[b+(p*n)]==arrS[(p*n)+q] && (b+(p*n))!=(q+(n*p)) ){
                       if(errorR==false){
                       wrongr++;
                       errorR=true;
                       }
                   } 
                }else{
                      if(errorR==false){
                      wrongr++;
                      errorR=true;
                      }
                  }
                  
                }
            }
                
                  for (int m = 0; m < n; m++) {
                    
                
                   for (int o = 0; o < n; o++) {
                       if (arrS[(o*n)+p]<=n && arrS[(o*n)+p]>=1) {
                           
                          if (arrS[(m*n)+p]==arrS[(o*n)+p] && ((m*n)+p)!=((o*n)+p) ) {
                          if(errorC==false){ 
                           wrongc++;
                           errorC=true;
                          }
                       }     
                           }else{
                           if(errorC==false){
                           wrongc++;
                           errorC=true;
                           }
                       }
                       
                }
            } 
                      trace= trace+ arrS[(n*p)+p];
                    
                
 
                
                
            }
            System.out.print(" "+trace);
            System.out.print(" "+wrongr);
            System.out.print(" "+wrongc+"\n");
            
        }
        
            }
    
}