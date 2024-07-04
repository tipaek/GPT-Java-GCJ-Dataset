import java.util.Scanner;

public class Solution {
        public static int hasDuplicatesInRows(int[][] inArray)
    {
        int max=0;int number = 0;
        for (int row = 0; row < inArray.length; row++)
        {
            max = 0;
            for (int col = 0; col < inArray[row].length; col++)
            {
                int current=0;
                int num = inArray[row][col];
                for (int otherCol = col + 1; otherCol < inArray.length; otherCol++)
                {
                    if (num == inArray[row][otherCol])
                    {
                        current+=1;
                        if(current==1){
                            current+=1;
                        }
                    }
                    
                }
                if(current>max){
                    max = current;
                }
            }
        if (max>0){
                number++;
            }
        }
        return number;
    }
        
        public static int hasDuplicatesInColumns(int[][] inArray)
    {
        int max=0; int number=0;
        for (int row = 0; row < inArray.length; row++)
        {
            max = 0;
            for (int col = 0; col < inArray[row].length; col++)
            {
                int current=0;
                int num = inArray[col][row];
                for (int otherCol = col + 1; otherCol < inArray.length; otherCol++)
                {
                    if (num == inArray[otherCol][row])
                    {
                        current+=1;
                        if(current==1){
                            current+=1;
                        }
                    }
                    
                }
                if(current>max){
                    max = current;
                }
            }
            if (max>0){
                number++;
            }
        }
        return number;
    }
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        int maxc = 0;
        int maxr = 0;
        
        for(int i=0;i<input;i++){
            int size = s.nextInt();
            maxc = 0;
            maxr = 0;
            int trace = 0; //trace
            
            int[][] array = new int[size][size];
            int[][] arrayR = new int[size][size];
            int[][] arrayC = new int[size][size];
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    array[j][k]=s.nextInt();
                }
            }
            
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    if(j==k){
                        trace+=array[j][k];
                    }
                }
            }
            maxc = hasDuplicatesInRows(array);
            maxr = hasDuplicatesInColumns(array);
            
            System.out.println("Case #"+(i+1)+": "+trace+" "+maxc+" "+maxr);
        }
    }
    
}