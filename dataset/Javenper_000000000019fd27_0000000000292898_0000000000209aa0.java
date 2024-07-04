import java.util.*;

public class Solution {

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
                
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int s = k / n;
            int s2 = k - s * n;
            
            Integer[] set = new Integer[n];
            //Stack<Integer> stack = new Stack<>();
            
            //set[0] = tmp;
            for(int z = 0; z < n; z++){
                //if(tmp != (z+1))
                    set[z] = z + 1;
            }
            List<Integer> lista = Arrays.asList(set);
            Set<Integer> already;// = new HashSet<>();
            
            int[][] m = new int[n][n];
            int last = n, tmp;
            boolean impossible = false;
            
            for(int j = 0; j < n; j++){
                if(impossible)
                    break;
                if(s2 > 0){
                    tmp = s+1;
                    s2--;
                }
                else
                    tmp = s;
                already = new HashSet<>();
                Collections.rotate(lista, 1);
                
                for(int x = 0; x < n; x++){
                    if(x == j){
                        if(already.contains(tmp)){
                            impossible = true;
                            break;
                        }
                        m[j][x] = tmp;
                        already.add(tmp);
                    } else{
                        if(already.contains(last))
                            for(int item : lista){
                                if(!already.contains(item) && item != tmp){
                                    m[j][x] = item;
                                    already.add(item);
                                    last = item;
                                    break;
                                }
                            }
                        else{
                            m[j][x] = last;
                            already.add(last);
                        }
                    }
                    //System.out.print(m[j][x]+" ");
                }
                
                //System.out.println();
            }
            if(impossible){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            } else{
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                for(int f = 0; f < n; f++){
                    for(int g = 0; g < n; g++){
                        System.out.print(m[f][g]+" ");
                    }
                    System.out.println();
                }
            }
            
        }
    }
}