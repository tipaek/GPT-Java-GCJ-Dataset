import java.util.*;

public class vest{


    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
       
        for(int i = 0 ; i < n ; i ++ ){
            int rowRepeat = 0;
            int colRepeat = 0;
            int diagonal = 0; 
            int cubeSize = stdin.nextInt();

            int[][] cube = new int[cubeSize][cubeSize];

            ArrayList<HashSet<Integer>> rows = new ArrayList<>();
            ArrayList<HashSet<Integer>> cols = new ArrayList<>();

            int[] rowRepeatFlag = new int[cubeSize];
            int[] colRepeatFlag = new int[cubeSize];

            for(int j = 0 ; j < cubeSize ; j ++ ){
                
                HashSet<Integer> row = new HashSet<>();
                HashSet<Integer> col = new HashSet<>();

                rows.add(row);
                cols.add(col);

            }

            for(int j = 0 ; j < cubeSize ; j++){
                for(int k = 0 ; k < cubeSize ; k++){
                    int value = stdin.nextInt();
                    cube[j][k] = value; 

                    if(j == k)
                        diagonal+= value;
                    

                    if(rows.get(j).contains(value) ){

                        if(rowRepeatFlag[j] == 0){
                            rowRepeat++;
                            rowRepeatFlag[j] = 1;
                        }
                           
                    }

                    else 
                        rows.get(j).add(value);

                    if(cols.get(k).contains(value)){

                        if(colRepeatFlag[k] == 0){
                            colRepeat++;
                            colRepeatFlag[k] = 1;
                        }
                    }

                    else 
                        cols.get(k).add(value);
                    

                }
            }

            System.out.println("Case: #" + (i+1) + " " + diagonal + " " + rowRepeat  + " " + colRepeat);

        }

        stdin.close();


    }

}