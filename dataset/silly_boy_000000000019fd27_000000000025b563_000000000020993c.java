import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int tr = 0,dr = 0,dc = 0;
            boolean vis[] = new boolean[n];
            ArrayList<HashMap<Integer,Integer>> mat = new ArrayList<HashMap<Integer,Integer>>();
            for(int i=0;i<n;i++){
                mat.add(new HashMap<Integer,Integer>());
            }
            for(short i=0;i<n;i++){
                HashMap<Integer,Integer> hp = new HashMap<Integer,Integer>();
                boolean visRow =false;
                for(int j=0;j<n;j++){
                    int x = sc.nextInt();
                    // trace
                    if(i==j) tr +=x;
                    
                    // dupli row
                    if(!visRow){
                        if(hp.containsKey(x)){
                            dr++;
                            visRow = true;
                        }
                        else hp.put(x,1);
                    }

                    // dupli col
                    if(!vis[j]){
                        if(mat.get(j).containsKey(x)){
                            vis[j] = true;
                            dc++;
                        }
                        else mat.get(j).put(x,1);
                    }
                }
            }
            System.out.println(tr+" "+dr+" "+dc);
        }
    }
}