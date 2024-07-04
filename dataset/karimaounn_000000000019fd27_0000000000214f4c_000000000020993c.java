import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; ++i){
            System.out.print("Case #" + i + 1 + ": ");
            displayMatrixInfo(getMatrix(scan, scan.nextInt()));
        }
        
    }
    
    private static List<List<Integer>> getMatrix(Scanner scan, int size){
        int trace = 0;
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        for(int i = 0; i<size; ++i){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j<size; ++j){
                int numb = scan.nextInt();
                tmp.add(numb);
                if(i == j) trace += numb;
            }
            matrix.add(tmp);
        }
        System.out.print(trace +" ");
        return matrix;
    }
    
    private static void displayMatrixInfo(List<List<Integer>> matrix){
        int countCol = 0;
        Set<Integer> set;
        for(int i = 0; i<matrix.size(); ++i){
            set = new HashSet<Integer>(matrix.get(i));
            if(set.size() != matrix.size()) ++countCol;
        }
        int countRow = 0;
        List<Integer> tmp;
        for(int i = 0; i<matrix.size(); ++i){
            tmp = new ArrayList<Integer>();
            for(int j = 0; j<matrix.size();++j){
                tmp.add(matrix.get(j).get(i));
            }
            set = new HashSet<Integer>(tmp);
            if(set.size() != matrix.size()) ++countRow;
        }
        System.out.println(countCol + " " + countRow);
    }
}