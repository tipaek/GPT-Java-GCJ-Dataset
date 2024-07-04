import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int len= scanner.nextInt();
        scanner.nextLine();

        StringBuilder report = new StringBuilder();
        for(int i = 0; i < len ; i++)
        {
            String[] piece = scanner.nextLine().split(" ");
            int size = Integer.parseInt(piece[0]);
            int target = Integer.parseInt(piece[1]);

            if(target % size == 0 )
            {
                int start = target / size;
                report.append("Case #").append(i + 1).append(": POSSIBLE\n");

                for(int k = 0; k< size ; k++)
                {
                    for(int l = 0; l < size ; l++)
                    {
                        report.append(start).append(" ");
                        if(l < size - 1)
                        {
                            if(start + 1 > size) start = 1;
                            else  start++;
                        }
                    }
                    report.append("\n");
                }

            }
            else
            {
                int count = 0;
                while (true){

                    if(generateRandomLatinSquare(report ,i+1,size ,target))
                        break;
                    count++;
                    if(count == 100.000)
                    {
                        report.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
                        break;
                    }

                }

            }

        }
        System.out.println(report.toString());



    }

    public  static boolean generateRandomLatinSquare(StringBuilder report ,int cas ,int size , int target)
    {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        //fill
        for(int i = 0; i < size ; i++)
        {
            matrix.add(new ArrayList<>());
            for(int j = 1; j<= size ; j++)
                matrix.get(i).add(j);
        }

        //first row
        Collections.shuffle(matrix.get(0));

        //middle rows
        for(int i = 1 ; i < size -1 ; i++ )
        {
            boolean shuffled = false;
            outer :
            while (!shuffled) {
                Collections.shuffle(matrix.get(i));
                for (int k = 0 ; k < i ; k++ ) {
                    for (int j = 0; j < size; j++) {
                        if (matrix.get(k).get(j).equals(matrix.get(i).get(j))) {
                            continue outer;
                        }
                    }
                }
                shuffled = true;
            }

        }

        // last row
    for (int j = 0; j < size ; j++) {
        boolean[] used =  new boolean[size+1];
        for (int i = 0; i < size - 1 ; i++) {
            used[matrix.get(i).get(j)] = true;
        }
        for (int k = 1; k<= size ; k++) {
            if (!used[k]) {
                matrix.get(size -1).set(j,k);
                break;
            }
        }
     }

        int trace = 0;
        for(int i = 0; i < size ; i++)
            trace += matrix.get(i).get(i);

        if(trace == target)
        {
            report.append("Case #").append(cas).append(": POSSIBLE\n");
            for(int i = 0; i < size ; i++)
            {
                for(int j = 0; j< size ; j++)
                    report.append(matrix.get(i).get(j)).append(" ");
               report.append("\n");
            }
            return  true;
        }
        else return  false;


    }


}