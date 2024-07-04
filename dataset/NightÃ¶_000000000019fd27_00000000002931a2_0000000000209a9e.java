import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Solution{
    public boolean evaluate(int P, Scanner stdin) {
        int[] res = new int[P];
        
        int tries = 0;
        int index = 0;
        Integer[] lastOneToZero = null;
        
        Integer identicals = null;
        Integer[] lastIdenticals = null;
        
        while (tries < 150 && index<= P/2){
            //check  
            if (tries !=0){
                tries +=2;
                boolean inversed = false;
                boolean compl = false;
                if (lastOneToZero != null){
                    int lastOneIndex = lastOneToZero[0];
                    System.out.print(lastOneIndex);
                    int became = stdin.nextInt();
                    if (became == 1){ // either both transformations or none
                        int lastIdenIndex = lastIdenticals[0];
                        System.out.print(lastIdenIndex);
                        int iden2 = stdin.nextInt();
                        if (iden2 != res[lastIdenIndex]){ // both
                            inversed = true;
                            compl = true;
                            identicals = iden2;
                        } else {
                            // Nothing happened
                        }
                        
                    } else { //either inversed or comple
                        lastOneToZero[0] = 1;
                        lastOneToZero[1] = 0;
                        
                        int lastIdenIndex = lastIdenticals[0];
                        System.out.print(lastIdenIndex);
                        int iden2 = stdin.nextInt();
                        if (iden2 != res[lastIdenIndex]){ // comp
                            compl = true;
                            identicals = iden2;
                        } else {
                            // inversed
                            inversed = true;
                        }
                    }
                } else { // check if compl
                    int lastIdenIndex = lastIdenticals[0];
                    System.out.print(lastIdenIndex);
                    int iden2 = stdin.nextInt();
                    if (iden2 != res[lastIdenIndex]){ // comp
                        compl = true;
                        identicals = iden2;
                    }
                }
                if (inversed) { //
                    for(int i=0; i<=index; i++){
                        int tmp = res[index];
                        res[index] = res[P - index - 1];
                        res[P - index - 1] = tmp;
                    }
                }
                if (compl) {
                    for(int i=0; i<=index; i++){
                        res[index] = res[index]== 1 ? 0 : 1;
                        res[P - index - 1] = res[P - index - 1] == 1 ? 0 : 1;
                    }
                }
            }
            //getting the remaing to 10 elements
            while(tries % 10 != 0){
                tries += 2;
                System.out.print(index);
                int first = stdin.nextInt();
                res[index] = first;
                System.out.print(P-index-1);
                int second = stdin.nextInt();
                if (first == second){
                    lastIdenticals = new Integer[]{index, P-index-1};
                    identicals = first;
                } else {
                    lastOneToZero = ( first == 1 ) ? new Integer[]{index,P-index-1} : new Integer[]{P-index-1, index};
                }
                index ++;
            }
        }
        for(int i =0; i<P; i++){
            System.out.print(res[i]);
        }
        System.out.println();
        String answer = stdin.nextLine();
        if (answer.equals("Y")) return true;
        return false;
    }

     public static void main(String []args){
        Solution sol = new Solution();
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        int P = stdin.nextInt();
        
        for(int t=0; t<T; t++){
            if (!sol.evaluate(P, stdin)) return;
        }
     }
}