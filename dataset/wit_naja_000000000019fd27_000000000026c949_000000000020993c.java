
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1V2 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> res = new ArrayList<String>();
    static String resT ;
    static int[][] arr  ;

    static void inp (){
        int tCase = sc.nextInt();
        for (int i = 1; i <= tCase; i++) {
            resT = "Case #" + i +":";
            int sizeM = sc.nextInt();
            arr = new int[sizeM][sizeM];
            inpMatrix(sizeM);
            res.add(resT);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
    static void inpMatrix(int s){
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        diagonal(s);
    }
    static void diagonal(int s){
        int first = 0;
        for (int i = 0; i < s; i++) {
            first += arr[i][i];
        }
        resT += " " + first;
        checkRowCol(s);
    }
    static void checkRowCol(int s){

        int cR = 0 , cC = 0;
        for (int rc = 0; rc < s; rc++) {
            for (int h = 0; h < s; h++) {
                for (int c = h+1; c < s; c++) {
                    if (arr[rc][h] == arr[rc][c]) {
                        cR++;
                        break;
                    }
                }
                for (int r = h+1; r < s; r++) {
                    if(arr[h][rc] == arr[r][rc]){
                        cC++;
                        h = s;
                        break;
                    }
                }
            }

        }
        resT += " " + cR + " " + cC;

    }

    public static void main(String[] args) {
        inp();
    }

}

