import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;

public class Solution {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        //int numOfCases = in.nextInt();
        String numOfCases = in.nextLine();
        int current_c = 1;

        while(in.hasNextLine()) {
            String inputNandD = in.nextLine();
            String sliceDetail = in.nextLine();

            String[] NandD_array;
            NandD_array = inputNandD.split(" ");

            String[] sliceInfo_array = sliceDetail.split(" ");

            int slices_N_int = Integer.parseInt(NandD_array[0]);
            int diners_D_int = Integer.parseInt(NandD_array[1]);
            int cutCount = 0;

            HashMap<Long , Integer> slice_map = new HashMap<Long, Integer>();
            for (int i = 0; i < sliceInfo_array.length ; i++){
                int x=1;
                if ( slice_map.containsKey(Long.parseLong(sliceInfo_array[i])) ) {
                    x = slice_map.get(Long.parseLong(sliceInfo_array[i])) + 1;
                }
                slice_map.put(Long.parseLong(sliceInfo_array[i]), x);
            }

            //case : we already have enough slices
            List<Long> slicesEnough = slice_map.entrySet().stream()
                    .filter(entry -> entry.getValue() >= diners_D_int )
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            if ( slicesEnough.size() > 0 ) {
                System.out.println("Case #" + current_c + ": " + 0);
            }

            //case : if we need to slice
            else {
                System.out.println("Case #" + current_c + ": " + (diners_D_int-1) );
            }
            current_c++;
        }
    }
}

