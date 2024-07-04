
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;
@FunctionalInterface
interface Parser<T> {
    public T parse(String s);
}
public class Solution{
    public static void print(String[] str,long... longs){
        out.print(Arrays.toString(str));
        for(long l : longs)
            out.print(l + " ");
        out.println();
    }
    public static void print(String str,long... longs){
        out.print(str + " ");
        for(long l : longs)
            out.print(l + " ");
        out.println();
    }
    public static void print(long... longs){
        for(long l : longs)
            out.print(l + " ");
        out.println();
    }
    public static int[] inpIntArr(){
        Scanner sc = new Scanner(in);
        String[] strArr = sc.nextLine().split(" ");
        int[] arr = new int[strArr.length];
        int i = 0;
        for(String s : strArr)
            arr[i++] = Integer.parseInt(s);
        return arr;
    }
    public static long[] inpLongArr(){
        Scanner sc = new Scanner(in);
        String[] strArr = sc.nextLine().split("[ ]+");
        long[] arr = new long[strArr.length];
        int i = 0;
        for(String s : strArr)
            arr[i++] = Long.parseLong(s);
        return arr;
    }
    public  static <N extends Number> List<N> inpLst(Parser<N> parser){
        Scanner sc = new Scanner(in);
        String[] strArr = sc.nextLine().split("[ ]+");
        return Arrays.stream(strArr).map(s -> parser.parse(s)).collect(Collectors.toList());
    }
    public static void main(String... args){
        try(Scanner sc  = new Scanner(in)){
            int t = Integer.parseInt(sc.nextLine());
            while(t-- > 0){
                int n = Integer.parseInt(sc.nextLine());
                int[][] arr = new int[n][n];
                int sum = (n*(n+1))/2;
                for(int i = 0 ; i < n ; i++)
                    arr[i] = inpIntArr();
                int trace = 0, row = 0, col = 0;
                for(int i = 0 ; i < n ; i++)
                    trace+=arr[i][i];
                for(int i = 0 ; i < n ; i++){
                    int rowSum = 0, colSum = 0;
                    Set<Integer> tempRow = new HashSet<>(), tempCol = new HashSet<>();
                    for(int j = 0 ; j < n ; j++){
                        rowSum+=arr[i][j];
                        tempRow.add(arr[i][j]);
                        colSum+=arr[j][i];
                        tempCol.add(arr[j][i]);
                    }
                    if(rowSum != sum || tempRow.size() != n) row++;
                    if(colSum != sum || tempCol.size() != n) col++;
                }
                print(String.format("Case #%d:",t+1),trace,row,col);
            }
        }catch (Exception ex){
            err.println("Runtime Error");
            ex.printStackTrace();
        }
    }
}
