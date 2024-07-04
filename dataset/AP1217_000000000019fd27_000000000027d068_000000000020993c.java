import java.util.*;
public class Solution{
    public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in); 
    int testCase = s.nextInt();
    int number=0;
    ArrayList<Integer[][]> aa= new ArrayList<Integer[][]>();
    s.nextLine();
    while(number<=testCase-1){
    int al= Integer.parseInt(s.nextLine());
    if (al!=0){

    Integer[][] array = new Integer[al][al];
    
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

    for (int i = 0; i < aa.size(); i++) {

        array = aa.get(i);

        int k = 0;

        int rep1 = 0;
        int rep2 = 0;

        for (int j = 0; j < array.length; j++) {

            k += array[j][j];
        }

        for (int row = 0; row < array.length; row++) {

            for (int col = 0; col < array[0].length; col++) {

                final int num = array[row][col];

                for (int otherCol = col + 1; otherCol < array.length; otherCol++) {
                    if (num == array[row][otherCol]) {
                        rep1++;
                    }
                }

            }
        }

        for (int col = 0; col < array[0].length; col++) {

            for (int row = 0; row < array.length; row++) {

                final int num = array[row][col];

for (int row1 = row + 1; row1 < array.length; row1++)
{
    if (num == array[row1][col])
    {
        rep2++;
    }
}

}   
}

System.out.println("Case #" + (i + 1) + ": " + k + " " + rep1 + " " + rep2);

}

}
}




   