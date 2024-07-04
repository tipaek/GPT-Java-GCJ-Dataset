import java.util.Scanner;
public class Solution{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int numTimes = scan.nextInt();
        
        for(int i = 0; i < numTimes; i++){
            int matrixSize = scan.nextInt();
            int trace = scan.nextInt();
            int sameSum=0;
            int difSum=0;
            
            if((trace%matrixSize)==0){
                    sameSum=trace/matrixSize;
                }
            if(matrixSize>2){
            for(int a=1;a<(matrixSize+1);a++){
                difSum += a;
            }}
            int num=sameSum;
            if((sameSum==trace)||(difSum==trace))
                System.out.println("Case #"+(numTimes)+": POSSIBLE");
                
            if(sameSum==trace){
                for(int b=0;b<matrixSize;b++){
                for(int a=0;a<matrixSize;a++){
                    int answer = num-a+b;
                    if(answer<=0)
                        answer=answer+matrixSize;
                    if(answer>matrixSize)
                        answer=answer-matrixSize;
                    System.out.print(answer+" ");
                }
                System.out.println("");
            }}
            else if(difSum==trace){
                for(int b=0;b<matrixSize;b++){
                for(int a=0;a<matrixSize;a++){
                    int answer = a+num+b;
                    if(answer>matrixSize)
                        answer=answer-matrixSize;
                    if(answer<0)
                        answer=answer+matrixSize;
                    System.out.print(answer+" ");
                }
                System.out.println("");
            }}
            else
                System.out.println("Case #"+(numTimes)+": IMPOSSIBLE");
        }
    }
}