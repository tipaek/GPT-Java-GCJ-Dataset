
import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            HashMap<Integer,HashSet<Integer>> row = new HashMap<>();
            HashMap<Integer,HashSet<Integer>> column = new HashMap<>();
            int k = 0;
            int r = 0;
            int c = 0;
            boolean[] rows = new boolean[n];
            boolean[] columns= new boolean[n];
            for(int b = 0;b<n;b++){
                rows[b] = false;
                columns[b] = false;
            }
            for(int j = 0;j<n;j++){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int z = 0;z<n;z++){
                    temp.add(sc.nextInt());
                    if(j == z){
                        k += temp.get(z);
                    }
                    if (!rows[z]){
                        if(row.containsKey(z)){
                            if(row.get(z).contains(temp.get(z))){
                                c++;
                                rows[z] = true;
                            }else {
                                row.get(z).add(temp.get(z));
                            }
                        }else{
                            row.put(z,new HashSet<>());
                            row.get(z).add(temp.get(z));
                        }
                    }
                    if(!columns[j]){
                        if(column.containsKey(j)){
                            if(column.get(j).contains(temp.get(z))){
                                r++;
                                columns[j] = true;
                            }else {
                                column.get(j).add(temp.get(z));
                            }
                        }else{
                            column.put(j,new HashSet<>());
                            column.get(j).add(temp.get(z));
                        }
                    }
                }
                arr.add(temp);
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c );
        }

    }
    
    
}
