    import java.lang.reflect.Array;
    import java.util.*;
    import java.io.*;
    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> invMatrix = new ArrayList<ArrayList<Integer>>();  // used to store and check array
            int mPosition = 0; //used to determine first element in the new matrix
            int elements;   //number of elements per row/column
            int trace =0;
            int rowCount = 0;
            int colCount = 0;
            int intVal;
            String rowIn;
            for (int i = 1; i <= t; ++i) {
                //get number of elements
                elements = in.nextInt();

                //create empty nodes in the inverse
                for(int a=0; a<elements; a++){
                    invMatrix.add(new ArrayList<Integer>());
                }
                //convert the input into array/lists
                for(int a=0; a< elements; a++){
                    rowIn = in.nextLine();
                    trace = trace + Integer.parseInt(String.valueOf(rowIn.charAt(a)));
                    matrix.add(new ArrayList<Integer>());
                    for(int e=0; e<elements; e++){
                        intVal = Integer.parseInt(String.valueOf(rowIn.charAt(e)));
                        matrix.get(mPosition+a).add(intVal);
                        invMatrix.get(mPosition+e).add(intVal);
                    }

                }
                for (int a = 0; a<elements; a++){
                    Set<Integer> row = new HashSet<>(matrix.get(a));
                    Set<Integer> col = new HashSet<>(invMatrix.get(a));
                    if(matrix.get(a).size() != row.size()) rowCount++;
                    if(invMatrix.get(a).size() != col.size()) colCount++;
                }
                System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
                trace = 0;
                rowCount =0;
                colCount = 0;
            }
        }
    }