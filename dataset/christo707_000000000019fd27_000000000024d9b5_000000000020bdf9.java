import java.io.*; 
import java.util.*; 
  
public class Solution {

    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 1; i <= t; i++){
           int n = scanner.nextInt();
           int sC = 0, eC = 0, sJ = 0, eJ = 0;
           boolean possible = true;
           StringBuilder str = new StringBuilder("");
           int arrC[] = new int[1441];
           int arrJ[] = new int[1441];
           Arrays.fill(arrC, 0);
           Arrays.fill(arrJ, 0);
           for(int k = 0; k < n; k++){
               boolean avC = true, avJ = true;
               int start = scanner.nextInt();
               int end = scanner.nextInt();
               for(int chC = start + 1; chC <= end; chC++){
                   if(arrC[chC] == 1){
                       avC = false;
                       break;
                   }
               }
               if(avC == true){
                   for(int chC = start; chC <= end; chC++){
                       arrC[chC] = 1;
                   }
                   str.append("C");
               } else {
                   for(int chJ = start + 1; chJ <= end; chJ++){
                        if(arrJ[chJ] == 1){
                            avJ = false;
                            break;
                            }
                        }
                        if(avJ == true){
                            for(int chJ = start; chJ <= end; chJ++){
                                arrJ[chJ] = 1;
                            }
                        str.append("J");
                        } else {
                            possible = false;
                        }
               }
            
               if(possible == false){
                   break;
               }
           }
           if(possible == false){
               System.out.println("Case #" + i + ": IMPOSSIBLE");
           } else {
               System.out.println("Case #" + i + ": " + str.toString());
           }
        }
        
    }

} 