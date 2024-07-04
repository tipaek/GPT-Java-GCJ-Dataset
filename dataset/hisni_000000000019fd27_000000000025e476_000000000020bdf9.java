import java.util.*;
import java.io.*;

public class Solution {

    public static void sortbyColumn(int arr[][], int col){ 
        Arrays.sort(arr, new Comparator<int[]>() { 
        
            @Override              
            public int compare(final int[] entry1,final int[] entry2) { 
                if (entry1[col] > entry2[col]) 
                    return 1; 
                else
                    return -1; 
            } 
        });
    } 
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            String temp = in.nextLine();

            int trace = 0;
            int st1 = 0;
            int st2 = 0;
            int en1 = 0;
            int en2 = 0;

            String str = "";
            int[][] arr = new int[N][3];

            for( int j=0;j<N;j++ ){
                String[] line = in.nextLine().split(" ");
                arr[j][0] = Integer.parseInt(line[0]);
                arr[j][1] = Integer.parseInt(line[1]);
                arr[j][2] = j;
            }   
            
            sortbyColumn(arr, 0);
            HashMap<Integer, String> map = new HashMap<>();

            // map.put(arr[0][2],"C");
            String result = "IMPOSSIBLE";
            Boolean flag = false;
            
            for(int k=0;k<N;k++){
                if( arr[k][0] >= en1 ){
                    map.put(arr[k][2],"C");
                    st1 = arr[k][0];
                    en1 = arr[k][1];
                    // System.out.print("C");
                }else if( arr[k][0] >= en2 ){
                    map.put(arr[k][2],"J");
                    st2 = arr[k][0];
                    en2 = arr[k][1];
                    // System.out.print("J");
                }else{
                    flag = true;
                    break;
                }
            }

            if( !flag){
                result = "";

                for(int q=0;q<N;q++) result+=map.get(q);

            }
            
            System.out.println("Case #" + i + ": " + result );
        }
    }
}
