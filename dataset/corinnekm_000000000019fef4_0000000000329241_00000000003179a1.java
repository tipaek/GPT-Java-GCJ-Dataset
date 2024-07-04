import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution {



    public static void main(String[] args) throws FileNotFoundException {
        Solution sol = new Solution();
        //Scanner sc = new Scanner(new File("resources/input1.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line;
        /****************************************************************************/
        int T = Integer.parseInt(sc.nextLine());
        int U = Integer.parseInt(sc.nextLine());
        ArrayList<String> listInput = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            Set[] arrayMap = new Set[11];
            for (int i = 0; i <11 ; i++) {
                arrayMap[i]= new HashSet<Character>();
            }
            //remplissage
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                listInput.add(input);
                int N = Integer.parseInt(input.split(" ")[0]);
                String str = input.split(" ")[1];

                if (N <10){
                    arrayMap[N].add(str.toCharArray()[0]);
                }
                if (N>10 && str.toCharArray().length==2){
                    arrayMap[0]
                            .add(str.toCharArray()[1]);
                }
            }
            // suppression PFOXLUSHBP Case #1: TPFOXLUSHB

            for(String input:listInput) {

                int N = Integer.parseInt(input.split(" ")[0]);
                String str = input.split(" ")[1];
                if (N <10){
                    for (int i = N + 1; i < 10 ; i++) {
                        arrayMap[i].remove(str.toCharArray()[0]);
                    }
                }
                if (N==10 && str.length()==1){
                    arrayMap[0].remove(str.toCharArray()[0]);
                }
            }

            StringBuffer result = new StringBuffer();
            for (Set set : arrayMap) {
                if (set.iterator().hasNext()) {
                    result.append(set.iterator().next());
                }
            }
            System.out.println("Case #" + (t+1)+ ": " + result.toString());


        }
    }
}

