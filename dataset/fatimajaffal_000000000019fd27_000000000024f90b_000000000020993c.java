import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t =in.nextInt();
        for(int i=1;i<=t;i++){
            int n = in.nextInt();
            int row = 0,col =0,k =0;
            ArrayList<ArrayList<Integer>> data = new ArrayList();
            boolean [] count = new boolean[n];
            for(int a = 0;a<n;a++){
                boolean rows = false;
                ArrayList<Integer> values = new ArrayList();
                for(int b =0;b<n;b++){
                    int v = in.nextInt();
                    if(values.indexOf(v) != -1 && rows == false){
                        rows = true;
                        row++;
                    }
                    for(int j =0;j<a;j++){
                        ArrayList<Integer> temp = data.get(j);
                        if(temp.get(b) == v && count[b] == false) {
                            col++;
                            count[b] = true;
                        }
                    }
                    
                    values.add(v);
                    if(a == b) k+=v;
                }
                data.add(values);
            }
            System.out.println("Case #"+i+": "+k+" "+row+" "+col);
        }
      
    }     
}