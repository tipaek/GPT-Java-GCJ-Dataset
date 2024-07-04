import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner in  = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 1; i <= cases; i++){
            int patterns = in.nextInt();
            String[] ps = new String[patterns];
            in.nextLine();
            for(int j = 0; j < patterns ; j++){
                ps[j]=in.nextLine();
                //System.out.println(ps[j]);
            }
            int[] pos = new int[patterns];
            int finish = 0;
            String resp = "";
            char propose;
            int size = 0;
            
            findSol:
            while(true){
                propose = 0;
                for(int w = 0; w < patterns;w++){
                    if(pos[w]<ps[w].length()){
                        char pivot = ps[w].charAt(pos[w]);
                        while(pivot == '*'){
                            pos[w]++;
                            pivot = pos[w] < ps[w].length()? ps[w].charAt(pos[w]): 0;
                        }
                        if(propose == 0){
                            propose = pivot;
                            pos[w]++;
                        }
                        //System.out.println(Arrays.toString(pos));
                        if(pivot ==0&&everyMaxPos(ps,pos)){
                            System.out.println("Case #"+i+": "+resp);
                            //System.out.println(Arrays.toString(pos));
                            break findSol;
                        }
                        if(pivot!=propose&&pivot!=0){
                            int newpos = findPrevAsterisc(ps[w],pos[w]);
                            if(newpos==-1){
                                System.out.println("Case #"+i+": *");    
                                break findSol;
                            } else{
                                pos[w] = newpos;
                            }
                        }
                        //if(propose != ps[w].charAt(pos[w])&&ps[w].charAt(pos[w])=='*'){
                        //    break findSol:
                        //}
                    }    
                }
            
            if(propose == 0){
                System.out.println("Case #"+i+": "+resp);
                break findSol;
            }
            resp += Character.toString(propose);    
            size++;
            
            if(size > 100000){
                System.out.println("Case #"+i+": *");    
                break findSol;
            }
            
                
            }
            
            
        }
    }
    public static int findPrevAsterisc(String s, int pos){
        for(int i = pos; i >= 0 ; i--){
            if(s.charAt(i)=='*')
                return i;
        }
        return -1;
    }
    public static boolean everyMaxPos(String[] ps, int[] pos){
        for(int i = 0; i < pos.length ; i++){
            if(pos[i]<ps[i].length())
                return false; 
        }
        return true;
    }
}