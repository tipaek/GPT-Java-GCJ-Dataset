
import java.util.Scanner;
import java.util.StringTokenizer;

public class Vestigium{
    public static void main(){
        System.out.println("Please enter input:");
        Scanner input = new Scanner(System.in);
        int t=input.nextLine().parseInt();
        for(int k=0;k<t;k++){
            int n=input.nextLine().parseInt();
            int array[][]=new int[n][n];
            int trace=0;
            int repeatedColumns=0;
            int repeatedRows=0;
            
            int checkRow=10;
            for(int i=0;i<n;i++){
                String eachLine=input.nextLine();
                StringTokenizer str=new StringTokenizer(eachLine," ");
                int j=0;
                int checkCol=10;
                while(str.hasMoreTokens())
                {
                    eachChar=str.nextToken().parseInt();
                     if(i=0){
                        if(checkCol==eachChar){
                            repeatedColumns++;
                        }
                    }
               
                    checkCol=eachChar;
                    if(i==j)
                    {
                        trace+=eachChar;
                    }
                    array[i][j]=eachChar;
                   if(j=0){
                       if(checkRow==eachChar)
                       {
                           repeatedRows++;
                       }
                       checkRow=eachChar;
                   }
                    j++;
                    
                }
                

            }
            System.out.println("#Case "+k+":"+trace+" "+repeatedColumns+" "+repeatedRows+"\n");
        }
    }
}
