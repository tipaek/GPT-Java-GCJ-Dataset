import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int i = 0; i < tests; i++){
            int size = scan.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

            for (int j = 0; j< size; j++){
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int p = 0; p < size; p++){
                    int next = scan.nextInt();
                    tmp.add(next);
                }
                arr.add(tmp);
            }
            int rowdupes = 0;
            int columndupes = 0;
            int sum = 0;
            for (int o = 0; o < size; o++){
                for(int x = 0; x < size; x++){
                    for (int g = x+1; g < size; g++){
                        if (arr.get(o).get(x) == arr.get(o).get(g)){
                            rowdupes++;
                            x = size;
                            break;
                        }
                    }
                }
            }
            for (int o = 0; o < size; o++){
                for(int x = 0; x < size; x++){
                    for (int g = x+1; g < size; g++){
                        if (arr.get(x).get(o) == arr.get(g).get(o)){
                            columndupes++;
                            x = size;
                            break;
                        }
                    }
                }
            }
            for (int o = 0; o < size; o++) {
                for (int x = 0; x < size; x++) {
                    sum += arr.get(o).get(x);
                    o++;

                }
            }

            System.out.println("Case #"+(i+1)+": "+sum
                    +" "+ rowdupes+" "+ columndupes);
        }
    }
}