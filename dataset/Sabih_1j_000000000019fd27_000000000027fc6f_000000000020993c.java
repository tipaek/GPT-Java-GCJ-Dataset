import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
public class duplicate {
    public static void inp(int arr[][]){
        int k=arr.length;
            int r=0;
            int trace=0;
            while(r<k){
                trace=trace+arr[r][r];
                r++;
            }
            int rcount=0,ccount=0;
            HashSet<Integer> hs=new HashSet<Integer>();
            for (int j = 0; j < k; j++) {
                for(int t=0;t<k;t++){
                    if(!hs.add(arr[j][t])){
                        rcount++;
                        break;
                    }
                }
                hs.clear();
            }
            hs.clear();
            for (int j = 0; j < k; j++) {
                for(int t=0;t<k;t++){
                    if(!hs.add(arr[t][j])){
                        ccount++;
                        break;
                    }
                }
                hs.clear();
            }
            System.out.println(trace +" " + rcount + " "+ ccount);
        }

    public static void main(String[] args) throws IOException {
        int [][] arr1={{2,2,2,2},{
                2,3,2,3},{
                2,2,2,3},{
                2,2,2,2}};
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int n = Integer.parseInt(br.readLine());
            int p = 0;
            while (p < n) {
                int k = Integer.parseInt(br.readLine());
                int arr[][]=new int[k][k];
                for (int i = 0; i < k; i++) {
                    String[] numbers = br.readLine().split(" ");
                    for (int j = 0; j < k; j++) {
                        arr[i][j] = Integer.parseInt(numbers[j]);
                    }
                }
                inp(arr);
                p++;
            }
            }
    }
}
