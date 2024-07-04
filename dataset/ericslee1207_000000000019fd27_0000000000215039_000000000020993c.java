import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class square {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int di=scanner.nextInt();
        
            int diagonal=0;
            int numrow=0;
            int numcolumn=0;
            HashMap<Integer, HashSet<Integer>> vertical=new HashMap<>();
            for (int j = 0; j < di; j++) {
                HashSet<Integer> visited=new HashSet<>();
                int duplicaterow=0;
        
                for (int k = 0; k < di; k++) {
                    int num=scanner.nextInt();
                    if (!vertical.containsKey(k)){
                        vertical.put(k,new HashSet<>());
                    }
                    HashSet<Integer> value=vertical.get(k);
                    value.add(num);
                    vertical.put(k,value);


                    if (duplicaterow==0){
                        if (visited.contains(num)){
                            duplicaterow=1;
                        }
                        else{
                            visited.add(num);
                        }
                    }
                    if (j==k){
                        diagonal+=num;
                    }
                }
                if (duplicaterow==1){
                    numrow++;
                }
            }
            for (int j = 0; j < di; j++) {
                HashSet<Integer> value=vertical.get(j);
                if (value.size()!=di){
                    numcolumn++;
                }
            }
            int testcase=i+1;
            System.out.println("Case #"+testcase+": "+diagonal+" "+numrow+" "+numcolumn);

        }
    }
}
