import java.util.*;
import java.io.*;

public class Solution{

static void printResult(int input,String result){
    System.out.println("Case #" + (input + 1) + ": " + result);
}

static void BubbleSort(int[][] mat, int f){
    boolean cambiato = false;
    do{
        cambiato = false;
    for(int i = 0; i < f - 1; i++){
        if(mat[i][0] > mat[i+1][0]){
            int tempIni = mat[i][0];
            int tempFin = mat[i][1];
            int tempJ = mat[i][2];
            mat[i][0] = mat[i+1][0];
            mat[i][1] = mat[i+1][1];
            mat[i][2] = mat[i+1][2];
            mat[i+1][0] = tempIni;
            mat[i+1][1] = tempFin;
            mat[i+1][2] = tempJ;
            cambiato = true;
        }
    }
    } while(cambiato);
}


public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tot = in.nextInt(); // Total cases
    String[] output = new String[tot]; // Array of results
    
    for(int i = 0; i < tot; i++){ // Cycle on all the cases
        int numberOfTasks = in.nextInt(); // number of tasks of this case
        int[][] tasks = new int[numberOfTasks][3]; // Matrix with the tasks, 2 coloumns, one for start time, 1 for end time
        for(int j = 0; j < numberOfTasks; j++){ // Populate the matrix of tasks
            tasks[j][0] = in.nextInt();
            tasks[j][1] = in.nextInt();
            tasks[j][2] = j;
        }
        
        // Sort the matrix with increasing start times with BubbleSort
        Solution.BubbleSort(tasks, numberOfTasks);
        
        char[] temp = new char[numberOfTasks]; // temporary array of the result
        int finC = -1; // When is Cameron's previous task finishing
        int finJ = -1; // When is Jamies previous task finishing
  /* 
   for(int c = 0; c < numberOfTasks; c++){
       System.out.println(tasks[c][0] + " , " + tasks[c][1]);
   }*/
   
      
        for(int p = 0; p < numberOfTasks; p++){ // Cycle on the tasks an produce the output
            if(tasks[p][0] >= finC) { // I always start with Cameron
                temp[tasks[p][2]] = 'C';
                finC = tasks[p][1]; // Update finC
            } else if(tasks[p][0] >= finJ){
                    temp[tasks[p][2]] = 'J';
                    finJ = tasks[p][1]; // Update finJ
                } else {
                    temp[0] = 'N';
                    break;
                }
            
        }
        
        if(temp[0] == 'N'){
            output[i] = "IMPOSSIBLE";
        } else {
            output[i] = "";
        for(int s = 0; s < numberOfTasks; s++){
            output[i] += temp[s];
        }
        }
    }
   
   
    for(int v = 0; v < tot; v++){
        Solution.printResult(v, output[v]);
    }
}
}