import java.util.*;
class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while(t-- > 0){
            int n = sc.nextInt();

            int trace = 0;
            int row = 0;
            int colval = 0;
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<Integer, HashSet<Integer>>();
            HashMap<Integer, Boolean> colbool = new HashMap<Integer, Boolean>();
            for(int i = 0 ;i < n ;i++){
                colMap.put(i , new HashSet<Integer>());
                colbool.put(i, false);
            }
            for(int i = 0 ;i < n ;i++){
                HashSet<Integer> rowMap = new HashSet<Integer>();
                boolean isdup = false;
                for(int j = 0 ;j < n ;j++){
                    int x = sc.nextInt();
                     if(rowMap.contains(x)){
                         isdup =  true;
                     }
                    rowMap.add(x);
                    if(colMap.get(j).contains(x) && !colbool.get(j)){
                        colbool.put(j, true);
                        colval++;
                    }
                    colMap.get(j).add(x);

                    if(i == j){
                        trace += x;
                    }
                }
                if(isdup)
                    row++;
            }
            System.out.println("Case #"+ c + ":" + " " + trace + " " + row + " " + colval);
            c++;
        }
    }
}