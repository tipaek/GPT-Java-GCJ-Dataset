import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String print;

        int linesCounter = 0;
        int maxLines = Integer.parseInt(scanner.nextLine());
        int activities;
        String output;
        List<int[]> c_tasks;
        List<int[]> j_tasks;
        int start;
        int end;
        int[] aux = new int[2];
        int[] auxToCopy;
        boolean flag = true;

        while(linesCounter < maxLines){
            linesCounter +=1;
            activities = scanner.nextInt();
            output = "";
            c_tasks = new ArrayList<>();
            j_tasks = new ArrayList<>();

            for(int i = 0; i<activities ;i++ ){
                start = scanner.nextInt();
                end = scanner.nextInt();
                aux[0] = start;
                aux[1] = end;
                auxToCopy = new int[2];
                auxToCopy[0] = start;
                auxToCopy[1] = end;

                // C CHECK
                if (c_tasks.isEmpty()){
                    output = output + "C";
                    c_tasks.add(auxToCopy);
                    continue;
                }
                flag = true;
                for (int j=0; j< c_tasks.size();j++ ){
                    if((start > c_tasks.get(j)[0] && start < c_tasks.get(j)[1]) ||
                            (end > c_tasks.get(j)[0] && end < c_tasks.get(j)[1])){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    output = output + "C";
                    c_tasks.add(auxToCopy);
                    continue;
                }

                // J CHECK
                if (j_tasks.isEmpty()){
                    output = output + "J";
                    j_tasks.add(auxToCopy);
                    System.out.println("Adding the first J");
                    continue;
                }
                flag = true;
                for (int j=0; j< j_tasks.size();j++ ){
                    System.out.println(start + "-" + end);
                    System.out.println(j_tasks.get(j)[0] + "-" + j_tasks.get(j)[1]);
                    if((start > j_tasks.get(j)[0] && start < j_tasks.get(j)[1]) ||
                            (end > j_tasks.get(j)[0] && end < j_tasks.get(j)[1])){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    output = output + "J";
                    j_tasks.add(aux);
                    continue;
                }

                //IMPOSSIBLE CHECK
                output = "IMPOSSIBLE";
                break;
            }
            print = "Case #" + linesCounter + ": " + output;
            System.out.println(print);
        }
    }
}
