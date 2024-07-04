import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Solution{
    
    public boolean evaluate(int P, Scanner stdin) {
        int[] res = new int[P+1];
        
        int tries = 0;
        int index = 1;
        Integer[] lastOneToZero = null;
        Integer[] lastIdenticals = null;
        
        while (tries< 150 && index <= P/2 + 1){
            if (tries != 0){ //check  
                
                boolean inversed = false;
                boolean compl = false;
                if (lastOneToZero != null){
                    tries += 2;
                    int lastOneIndex = lastOneToZero[0];
                    System.out.println(lastOneIndex);
                    int became = stdin.nextInt();
                    if (became == 1){ // either both transformations or none
                        if (lastIdenticals != null){
                            int lastIdenIndex = lastIdenticals[0];
                            System.out.println(lastIdenIndex);
                            int iden2 = stdin.nextInt();
                            if (iden2 != res[lastIdenIndex]){ // both
                                inversed = true;
                                compl = true;
                            } //else Nothing happened
                        }
                    } else { //either inversed or comple
                        lastOneToZero[0] = 1;
                        lastOneToZero[1] = 0;
                        
                        int lastIdenIndex = lastIdenticals[0];
                        System.out.println(lastIdenIndex);
                        int iden2 = stdin.nextInt();
                        if (iden2 != res[lastIdenIndex]){ // comp
                            compl = true;
                        } else {
                            inversed = true;
                        }
                    }
                } else { // check if compl
                    int lastIdenIndex = lastIdenticals[0];
                    System.out.println(lastIdenIndex);
                    int iden2 = stdin.nextInt();
                    if (iden2 != res[lastIdenIndex]){ // comp
                        compl = true;
                    }
                    tries ++;
                }
                if (inversed) { //
                    for(int i=0; i<=index; i++){
                        int tmp = res[i];
                        res[i] = res[P - i - 1];
                        res[P - i - 1] = tmp;
                    }
                }
                if (compl) {
                    for(int i=0; i <= index; i++){
                        res[i] = res[i]== 1 ? 0 : 1;
                        res[P - i - 1] = res[P - i - 1] == 1 ? 0 : 1;
                    }
                }
            }
            
            while ( tries == 0 || (tries+1) % 10 != 0 && index <= P/2 +1 ){ //getting the remaing to 10 elements
                tries += 2;
                System.out.println(index);
                int first = stdin.nextInt();
                res[index] = first;
                System.out.println(P-index-1);
                int second = stdin.nextInt();
                if (first == second){
                    lastIdenticals = new Integer[]{index, P-index-1};
                } else {
                    lastOneToZero = (first == 1)? new Integer[]{index,P-index-1} :new Integer[]{P-index-1, index};
                }
                index ++;
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int i =1; i<=P; i++){
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
        String answer = stdin.nextLine();
        answer = stdin.nextLine();
        if (answer.equals("Y")) {
            return true;
        }
        System.out.println(answer);
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