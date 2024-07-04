import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
       for(int p = 1 ; p <= t ; p++){
            int n = s.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            
            int r = 0, c = 0, k = 0;

            for(int i = 0 ; i < n ; i++){
                ArrayList<Integer> aa = new ArrayList<>();
                for(int j = 0 ; j < n ; j++){
                    int a = s.nextInt();
                    aa.add(a);
                    if(i == j)
                    k += a;
                }
                arr.add(aa);
            }
            
            //find r
            for(int i = 0 ; i < n ; i++){
                int count[] = new int[n+1];
                for(int j = 0 ; j < n ; j++){
                    count[arr.get(i).get(j)]++;
                    if(count[arr.get(i).get(j)] > 1){
                    r++;
                    break;
                    }
                }
            }
            //find c
            for(int i = 0 ; i < n ; i++){
                int count[] = new int[n+1];
                for(int j = 0 ; j < n ; j++){
                    count[arr.get(j).get(i)]++;
                    if(count[arr.get(j).get(i)] > 1){
                    c++;
                    break;
                    }
                }
            }
            arr.clear();

            System.out.println("Case #"+p+": "+k+" "+r+" "+c);

        }
    }
}