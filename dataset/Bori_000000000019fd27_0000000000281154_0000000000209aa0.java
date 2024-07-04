import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static class squareTwo{
        static int[][] m;

        static void init(){
            m = new int[3][3];
        }

        static void applyConfig1(int a, int b){
            m[1][1]=a;m[1][2]=b;
            m[2][1]=b;m[2][2]=a;
        }

        static void printMatrix(){
            for(int i=1; i<=2; i++){
                for(int j=1; j<=2; j++){
                    System.out.print(m[i][j]+" ");
                }
                System.out.print('\n');
            }
        }

        static void printSquareTwo(int caseNr, int trace){
            if(trace==2 || trace==4) {
                System.out.println("Case #" + caseNr + ": POSSIBLE");
                if(trace==2) applyConfig1(1, 2);
                else if(trace==4) applyConfig1(2, 1);
                printMatrix();
            }
            else{
                System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
            }
        }
    }

    private static class squareThree{
        static int[][] m;
        static int size = 3;

        static void init(){
            m = new int[size+1][size+1];
        }

        static void applyConfig1(int a, int b, int c){
            m[1][1]=a;m[1][2]=b;m[1][3]=c;
            m[2][1]=c;m[2][2]=a;m[2][3]=b;
            m[3][1]=b;m[3][2]=c;m[3][3]=a;
        }

        static void printMatrix(){
            for(int i=1; i<=size; i++){
                for(int j=1; j<=size; j++){
                    System.out.print(m[i][j]+" ");
                }
                System.out.print('\n');
            }
        }

        static void printSquareThree(int caseNr, int trace){
            if(trace==3 || trace==6 || trace==9) {
                System.out.println("Case #" + caseNr + ": POSSIBLE");
                if(trace==3) applyConfig1(1, 2, 3);
                else if(trace==6) applyConfig1(2, 1, 3);
                else if(trace==9) applyConfig1(3, 1, 2);
                printMatrix();
            }
            else{
                System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
            }
        }
    }

    private static class squareFour{
        static int[][] m;
        static int size = 4;

        static void init(){
            m = new int[size+1][size+1];
        }

        static void applyConfig1(int a, int b, int c, int d, int caseNr){
            m[1][1]=a;m[1][2]=b;m[1][3]=c;m[1][4]=d;
            m[2][1]=d;m[2][2]=a;m[2][3]=b;m[2][4]=c;
            m[3][1]=c;m[3][2]=d;m[3][3]=a;m[3][4]=b;
            m[4][1]=b;m[4][2]=c;m[4][3]=d;m[4][4]=a;
            printMatrix(caseNr);
        }

        static void applyConfig2(int a, int b, int c, int d, int caseNr){
            m[1][1]=a;m[1][2]=b;m[1][3]=c;m[1][4]=d;
            m[2][1]=b;m[2][2]=a;m[2][3]=d;m[2][4]=c;
            m[3][1]=c;m[3][2]=d;m[3][3]=b;m[3][4]=a;
            m[4][1]=d;m[4][2]=c;m[4][3]=a;m[4][4]=b;
            printMatrix(caseNr);
        }

        static void applyConfig3(int a, int b, int c, int d, int caseNr){
            m[1][1]=a;m[1][2]=b;m[1][3]=c;m[1][4]=d;
            m[2][1]=c;m[2][2]=a;m[2][3]=d;m[2][4]=b;
            m[3][1]=d;m[3][2]=c;m[3][3]=b;m[3][4]=a;
            m[4][1]=b;m[4][2]=d;m[4][3]=a;m[4][4]=c;
            printMatrix(caseNr);
        }

        static void printMatrix(int caseNr){
            System.out.println("Case #" + caseNr + ": POSSIBLE");
            for(int i=1; i<=size; i++){
                for(int j=1; j<=size; j++){
                    System.out.print(m[i][j]+" ");
                }
                System.out.print('\n');
            }
        }

        static void printSquareFour(int caseNr, int trace){
           switch(trace){
               case 4: applyConfig1(1, 2, 3, 4, caseNr);
               break;
               case 6: applyConfig2(1, 2, 3, 4, caseNr);
               break;
               case 7: applyConfig3(1,2, 3, 4, caseNr);
               break;
               case 8: applyConfig1(2, 3, 4, 1, caseNr);
               break;
               case 9: applyConfig3(3, 1, 2, 4, caseNr);
               break;
               case 10: applyConfig2(2, 3, 1, 4, caseNr);
               break;
               case 11: applyConfig3(4, 1, 2, 3, caseNr);
               break;
               case 12: applyConfig1(3, 4, 1, 2, caseNr);
               break;
               case 13: applyConfig3(4, 2, 3, 1, caseNr);
               break;
               case 14: applyConfig2(3, 4, 1, 2, caseNr);
               break;
               case 16: applyConfig1(4, 3, 2, 1, caseNr);
               break;
               default: System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
               break;
           }
        }
    }

    private static class squareFive{
        static int[][] m;
        static int size = 5;

        static void init(){
            m = new int[size+1][size+1];
        }

        static void applyConfig1(int a, int b, int c, int d, int e,  int caseNr){
            m[1][1]=a;m[1][2]=b;m[1][3]=c;m[1][4]=d;m[1][5]=e;
            m[2][1]=e;m[2][2]=a;m[2][3]=b;m[2][4]=c;m[2][5]=d;
            m[3][1]=d;m[3][2]=e;m[3][3]=a;m[3][4]=b;m[3][5]=c;
            m[4][1]=c;m[4][2]=d;m[4][3]=e;m[4][4]=a;m[4][5]=b;
            m[5][1]=b;m[5][2]=c;m[5][3]=d;m[5][4]=e;m[5][5]=a;
            printMatrix(caseNr);
        }

        static void applyConfig2(int a, int b, int c, int d, int e, int caseNr){
            m[1][1]=a;m[1][2]=b;m[1][3]=c;m[1][4]=d;m[1][5]=e;
            m[2][1]=b;m[2][2]=a;m[2][3]=e;m[2][4]=c;m[2][5]=d;
            m[3][1]=c;m[3][2]=d;m[3][3]=b;m[3][4]=e;m[3][5]=a;
            m[4][1]=d;m[4][2]=e;m[4][3]=a;m[4][4]=b;m[4][5]=c;
            m[5][1]=e;m[5][2]=c;m[5][3]=d;m[5][4]=a;m[5][5]=b;
            printMatrix(caseNr);
        }

        static void printMatrix(int caseNr){
            System.out.println("Case #" + caseNr + ": POSSIBLE");
            for(int i=1; i<=size; i++){
                for(int j=1; j<=size; j++){
                    System.out.print(m[i][j]+" ");
                }
                System.out.print('\n');
            }
        }

        static void printSquareFive(int caseNr, int trace){
            switch(trace){
                case 5: applyConfig1(1, 2, 3, 4, 5, caseNr);
                break;
                case 7: applyConfig2(2, 1, 3, 4, 5, caseNr);
                    break;
                case 8: applyConfig2(1, 2, 3, 4, 5, caseNr);
                    break;
                case 9: applyConfig2(3, 1, 2, 4, 5, caseNr);
                    break;
                case 10: applyConfig1(2, 3, 4, 5, 1, caseNr);
                    break;
                case 11: applyConfig2(1, 3, 2, 4, 5, caseNr);
                    break;
                case 12: applyConfig2(3, 2, 1, 4, 5, caseNr);
                    break;
                case 13: applyConfig2(2, 3, 1, 4, 5, caseNr);
                    break;
                case 14: applyConfig2(4, 2, 1, 3, 5, caseNr);
                    break;
                case 15: applyConfig1(3, 4, 5, 1, 2, caseNr);
                    break;
                case 16: applyConfig2(2, 4, 1, 3, 5, caseNr);
                    break;
                case 17: applyConfig2(1, 5, 2, 3, 4, caseNr);
                    break;
                case 18: applyConfig2(3, 4, 1, 2, 5, caseNr);
                    break;
                case 19: applyConfig2(2, 5, 1, 3, 4, caseNr);
                    break;
                case 20: applyConfig1(4, 5, 1, 2, 3, caseNr);
                    break;
                case 21: applyConfig2(3, 5, 1, 2, 4, caseNr);
                    break;
                case 22: applyConfig2(5, 4, 1, 2, 3, caseNr);
                    break;
                case 23: applyConfig2(4, 5, 1, 2, 3, caseNr);
                    break;
                case 25: applyConfig1(5, 1, 2, 3, 4, caseNr);
                    break;
                default: System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
                    break;
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int noTests = scanner.nextInt();

        squareFive.init();
        squareFour.init();
        squareThree.init();
        squareTwo.init();

        int size, trace;
        for(int t=1; t<=noTests; t++){
            size = scanner.nextInt();
            trace = scanner.nextInt();
            switch (size){
                case 2: squareTwo.printSquareTwo(t, trace);
                break;
                case 3: squareThree.printSquareThree(t, trace);
                break;
                case 4: squareFour.printSquareFour(t, trace);
                break;
                case 5: squareFive.printSquareFive(t, trace);
            }
        }
    }
}
