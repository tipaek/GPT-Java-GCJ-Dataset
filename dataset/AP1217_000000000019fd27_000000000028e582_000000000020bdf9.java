import java.util.*;

public class Solution{


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int numTestCases = 0;
        int numActivities=0; 

       
        
        while (true)
        {
            numTestCases = scanner.nextInt();
            if (numTestCases >=1 && numTestCases <=100)
                break;
            else {
                System.out.println("Value must be between 1 and 100");
            }
        }

        
       //Scanner scanner1 = new Scanner(System.in);
        
        for (int eachtestcase=0; eachtestcase<numTestCases;eachtestcase++){

            while (true)
            {
                numActivities = scanner.nextInt();
                if (numActivities >=2 && numActivities <=1000)
                    break;
                else {
                    System.out.println("Value must be between 2 and 1000");
                }
            }
            int timespan[][] = new int[numActivities][2];
            scanner.nextLine();

            for (int eachinput=0; eachinput<numActivities;eachinput++){
                String str = null;
                double minutesAfter12end=0;
                double minutesAfter12start=0;
                boolean bRun=true;
                do {
                    str = scanner.nextLine();
                   
                    String[] splitted = str.split(" ");

                   

                    if (splitted == null) {
                        System.out.println("enter value");
                        bRun=true;
                        continue;
                    }
                       
                    if (!isNumeric(splitted[0]) || !isNumeric(splitted[1])){
                        System.out.println("enter numberic value");
                        bRun=true;
                        continue;
                    }
                    else
                    {
                        minutesAfter12start = convertToInt(splitted[0]);
                        minutesAfter12end = convertToInt(splitted[1]);
                        // System.out.println(minutesAfter12start);
                        // System.out.println(minutesAfter12end);
                        timespan[eachinput][0]= (int) minutesAfter12start;
                        timespan[eachinput][1]= (int)minutesAfter12end;

                    }


                    if (minutesAfter12start < 0 || minutesAfter12end > 1441)
                    {
                        System.out.println("Input should betweeen 0 and 1440");
                        bRun=true;
                        continue;
                    }
                    else{
                        bRun=false;
                    }
                } while (bRun);
           }
           //System.out.println("processing " + (eachtestcase+1));
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
        
       // int[][] array = {{99,150},{1,100},{100,301},{2,5},{150,250}};

       //System.out.println("Number of activities " + num);

    //    for(int row = 0; row < array.length; row++){

    //         System.out.print(array[row][0] + " ");
    //         System.out.println(array[row][1]);
    //    }

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

       // System.out.println();

        String string = "";

        if(value == 1){

            string += "IMPOSSIBLE";

           // System.out.println("Case #" + eachtestcase + ": "+ "IMPOSSIBLE");
        }
        else{
            for(int i = 0; i < code.length; i++){

                string += result[i];
            }

            //System.out.println();
        }

        System.out.println("Case #" + eachtestcase + ": "+ string);
     }


}
