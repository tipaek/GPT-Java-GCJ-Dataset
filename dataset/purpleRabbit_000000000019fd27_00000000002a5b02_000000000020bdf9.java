import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String numOfLines = in.nextLine();
        int numOfLinesint = Integer.parseInt(numOfLines);


        for (int i = 0; i < numOfLinesint; i++) {

            int numOfText = in.nextInt();

            int [][] termins = new int [numOfText][2];


            for (int j = 0; j < numOfText; j++) {

                termins[j][0] = in.nextInt();
                termins[j][1] = in.nextInt();

            }

           sortbyColumn(termins,0);

            int [][] terminsC = new int [numOfText][2];
            int [][] terminsJ = new int [numOfText][2];

            StringBuilder s = new StringBuilder();

            terminsC [0][0] = termins [0][0];
            terminsC [0][1] = termins [0][1];

            s.append("C");
            int indexC = 1;
            int indexJ = 0;
            boolean possible = true;

            for(int t = 1; t<numOfText; t++){

                int newBeggining = termins[t][0];

                if(terminsC[indexC-1][1]<=newBeggining){
                    terminsC[indexC][0] = termins[t][0];
                    terminsC[indexC][1] = termins[t][1];
                    indexC++;
                    s.append("C");
                }else if(indexJ == 0 || terminsJ[indexJ-1][1] <= newBeggining){
                    terminsJ[indexJ][0] = termins[t][0];
                    terminsJ[indexJ][1] = termins[t][1];
                    s.append("J");
                    indexJ++;
                }
                else{
                    possible = false;
                    break;
                }


            }

            if(!possible){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+(i+1)+": "+s.toString());

            }


        }










        in.close();

    }


    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}
