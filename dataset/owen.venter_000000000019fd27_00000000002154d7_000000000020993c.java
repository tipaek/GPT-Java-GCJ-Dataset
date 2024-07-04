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
                for (int q = p; q < n; q++) {
                    
                   if(arrS[p*n]==arrS[(p*n)+q] && (p*n)!=(q+(n*p)) && errorR==false){
                       wrongr++;
                       errorR=true;
                   } 
                }
                
                   for (int o = 0; o < n; o++) {
                       
                       if (arrS[(p*n)]==arrS[(o*n)] && p!=o && errorC==false) {
                           wrongc++;
                           errorC=true;
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