import java.util.*;
public class Solution{

    public static void sortbyColumn(Integer arr[][], int col) 
    { 
         
        Arrays.sort(arr, new Comparator<Integer[]>() { 
            
          @Override              
          public int compare(final Integer[] entry1,  
                             final Integer[] entry2) { 
  
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    } 
    public static void main(String[] args) {
    
        Scanner s = new Scanner(System.in); 
        int testCase = s.nextInt();
        int number=0;
        ArrayList<Integer[][]> aa= new ArrayList<Integer[][]>();
        s.nextLine();
        while(number<=testCase-1){
        int al= Integer.parseInt(s.nextLine());
        if (al!=0){
    
        Integer[][] array = new Integer[al][2];
        
         for(int row = 0; row< array.length; row++){
             String row1 = s.hasNextLine() ? s.nextLine() : "";
             String[] values = row1.split(" ");
                for(int col = 0 ;col< array[row].length; col++){
                    array[row][col] = values[col] != null && values[0] != "" ?  Integer.parseInt(values[col]): 0;
    
    
                }
            }
            aa.add(array);
        }
    
        
        number++;
        }

    s.close();

    Integer[][] array;

    for (int val = 0; val < aa.size(); val++) {

        array = aa.get(val);
    

    int num = array.length;

    int[] nums = new int[num];


    String[] result = new String[num];

    for(int i = 0; i < nums.length;i++){

        nums[i] = array[i][0];
    }

    sortbyColumn(array, 0);


        String[] code = new String [num];

        code[0] = "J";

        int compare = array[0][1];

        int row = 1;

        for(row = 1; row < array.length; row++){

            int value = row - 1;

            if (array[row][0] >= compare){

                code[row] = "J";
                
                compare = array[row][1];
                row = value;

            }
        }

        int start = 0;

        for(int i = 0; i < code.length; i++){

            if (code[i] == null){

                start = i;
                break;
        }
        }

        compare = array[start][0];

        for(row = start; row < array.length; row++){

            int value = row - 1;

            if(array[row][0] >= compare && code[row] == null){

                code[row] = "C";

                compare = array[row][1];

                row = value;

            }
        }

        for(int i = 0; i < array.length; i++){

            int index = 0; 

            for(int j = 0; j < nums.length; j++){

                if(array[i][0] == nums[j]){

                    index = j;
                }
            }

            result[i] = code[index];
        }

        int value = 0;

        for(int i = 0; i < result.length; i++){

            if (result[i] == null){

                value = 1;
                break;
            }
        }

        if(value == 1){

            System.out.println("IMPOSSIBLE");
        }

        else{
            for(int i = 0; i < code.length; i++){

                System.out.print(result[i]);
            }
            System.out.println();
        }
    }

            }

        }


