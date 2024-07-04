import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {

    public static int getSum(List<List<Integer>> matrix) {
        int sum = 0;
        for(int i=0; i<matrix.size(); i++) {
            sum += matrix.get(i).get(i);
        }
        return sum;
    }
    
    public static int getRepeatedRows(List<List<Integer>> matrix) {
        int total = 0;
        int n = matrix.size();
        for(int i=0; i<n; i++) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            List<Integer> row = matrix.get(i);
            for(int j=0; j<n; j++){
                int num = row.get(j);
                if(map.containsKey(num)) {
                    total++;
                    break;
                } else {
                    map.put(num, true);
                }
            }
        }
        return total;
    }
    
    public static int getRepeatedColumns(List<List<Integer>> matrix) {
        int total = 0;
        int n = matrix.size();
        for(int i=0; i<n; i++) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            for(int j=0; j<n; j++){
                int num = matrix.get(j).get(i);
                if(map.containsKey(num)) {
                    total++;
                    break;
                } else {
                    map.put(num, true);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
	    // write your code here
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.valueOf(bufferedReader.readLine());
        for(int i=0; i<tc; i++) {
            int size = Integer.valueOf(bufferedReader.readLine());
            List<List<Integer>> data = new ArrayList<>();
            for(int j=0; j<size; j++) {
                String[] strs = bufferedReader.readLine().split(" ");
                List<Integer> d = new ArrayList<>();
                for(int x = 0; x<size; x++)  {
                    d.add(Integer.valueOf(strs[x]));
                }
                data.add(d);
            }
            System.out.println("Case #"+(i+1)+": "+getSum(data)+" "+getRepeatedRows(data)+" "+getRepeatedColumns(data));
        }
    }
}