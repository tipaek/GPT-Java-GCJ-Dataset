import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = 0;
        int numActivities=0; 

        numTestCases = scanner.nextInt();

        
        for (int eachtestcase=0; eachtestcase<numTestCases;eachtestcase++){
           numActivities = scanner.nextInt();
           
            int timespan[][] = new int[numActivities][2];
            scanner.nextLine();
            for (int eachinput=0; eachinput<numActivities;eachinput++){
                String str = null;
                str = scanner.nextLine();
                String[] splitted = str.split(" ");
                timespan[eachinput][0]= (int) convertToInt(splitted[0]);;
                timespan[eachinput][1]= (int) convertToInt(splitted[1]);
                  
           }
           process(timespan, numActivities, (eachtestcase+1));
          
        }
        scanner.close();
    
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static double convertToInt(String strNum) {
        if (strNum == null) {
            return -1;
        }
        try {
           return Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return -1;
        }

    }
    public static void sortbyColumn(int arr[][], int col) 
    { 
         
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    } 

    public static void process(int[][] array, int num, int eachtestcase){

        //int num = 5;

        int[] nums = new int[num];
        String[] result = new String[num];

        for(int i = 0; i < nums.length;i++){

            nums[i] = array[i][0];
        }

        sortbyColumn(array, 0);
        String[] code = new String [num];

        code[0] = "C";

        int compare = array[0][1];

        int row = 1;
        
        for(row = 1; row < array.length; row++){

            int value = row - 1;

            if (array[row][0] >= compare){
               code[row] = "C";
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

                code[row] = "J";

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
        StringBuffer string = new StringBuffer();

        if(value == 1){

            string.append("IMPOSSIBLE");
        }
        else{
            for(int i = 0; i < code.length; i++){

                string.append(result[i]);
            }
        }
        System.out.println("Case #" + eachtestcase + ": "+ string.toString());
     }
}
