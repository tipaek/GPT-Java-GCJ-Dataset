import java.util.*;

public class Solution{
    
    public static class ResultSet{
        int trace;
        int noOfRows;
        int noOfCols;
        ResultSet(int t, int rows, int cols){
            trace=t;
            noOfRows=rows;
            noOfCols=cols;
        }
    }
    
    public static ResultSet solve(ArrayList<ArrayList<Integer>> A){
        int t=0;
        int r=0;
        int c=0;
        for(int i=0;i<A.size();i++){
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for(int j=0;j<A.get(i).size();j++){
                rowSet.add(A.get(i).get(j));
                colSet.add(A.get(j).get(i));
                if(i==j) t+=A.get(i).get(j);
            }
            if(rowSet.size()<A.size()) r++;
            if(colSet.size()<A.size()) c++;
        }
        return new ResultSet(t,r,c);
    }
    
    public static void main(String[] args){
        try{
            Scanner s = new Scanner(System.in);
            int t=s.nextInt();
            int z=1;
            while(t>0){
                int n=s.nextInt();
                ArrayList<ArrayList<Integer>> input = new ArrayList<>();
                for(int i=0;i<n;i++){
                    ArrayList<Integer> a=new ArrayList<>();
                    for(int j=0;j<n;j++){
                        int x=s.nextInt();
                        a.add(x);
                    }
                    input.add(a);
                }
                ResultSet result = solve(input);
                System.out.println("Case #"+z+": "+result.trace+" "+result.noOfRows+" "+result.noOfCols);
                z++;
                t--;
            }
        }catch(Exception e){
            
        }
    }
}