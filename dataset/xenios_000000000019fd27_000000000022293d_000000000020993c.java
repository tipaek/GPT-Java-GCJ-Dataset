public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner();
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int x = i+1;
            int r = 0;
            int c = 0;
            int rows = in.nextInt();
            String oneRow = in.nextLine();
            String[] temp = oneRow.split("");
            int columns = temp.length;
            int[][] matrix = new int[rows][columns];
            int trace = 0;
            ArrayList<HashSet<Integer>> rowss = new ArrayList<Integer>(n);
            for(int ri = 0; ri < n; ri++){
                rowss.add(new HashSet<Integer>());
            }
            ArrayList<Integer> columnss = new ArrayList<Integer>(columns);
            for(int ci = 0; ci < columns; ci++){
                columnss.add(new HashSet<Integer>());
            }
            for(int j =0; j < rows; j++){
                for(int k =0; k < columns; k++){
                    matrix[j][k] = Integer.parseInt(temp[j]);
                    
                    if(k==j){
                        trace += matrix[j][k];
                    }
                    rowss.get(j).add(Integer.valueOf(matrix[j][k]));
                    columnss.get(k).add(Integer.valueOf(matrix[j][k]));
                }
                oneRow = in.nextLine();
                temp = oneRow.split("");
            }
            for(int ri = 0; ri < n; ri++){
                if(rowss.get(ri).size() < columns){
                    r++;
                }
            }
            for(int ci = 0; ci < columns; ci++){
                if(columnss.get(ci).size() < rows){
                    c++;
                }
            }
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
    }
}