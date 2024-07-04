import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Harry on 4/10/20.
 */
public class Solution {
    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int t=1; t<=T; t++){
            int N = scanner.nextInt();
            String[] p = new String[N];
            int[] pos = new int[N];
            int maxPos = 0;
            int maxPosIndex = 0;
            for(int i=0; i<N; i++){
                p[i] = scanner.next();
                pos[i] = p[i].length()-1;
                if(pos[i]>maxPos){
                    maxPos = pos[i];
                    maxPosIndex = i;
                }
            }
            char[] res = new char[maxPos];
            boolean isFeasible = true;
            for(int i=maxPos-1; i>=0; i--){
                char c = p[maxPosIndex].charAt(i+1);
                boolean isValid = true;
                for(int j=0; j<N; j++){
                    char cur = p[j].charAt(pos[j]);
                    if(cur=='*'){
                        continue;
                    }
                    else if(cur==c){
                        pos[j]--;
                        continue;
                    }
                    else{
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    res[i] = c;
                }
                else{
                    isFeasible = false;
                    break;
                }
            }
            if(!isFeasible){
                System.out.println("Case #"+t+": *");
            }
            else{
                System.out.println("Case #"+t+": "+new String(res));
            }
        }
    }

//    public static String find(String[] p, int[] pos, int maxPos, String s){
//        if(maxPos==-1){
//            return s;
//        }
//
//    }
}
