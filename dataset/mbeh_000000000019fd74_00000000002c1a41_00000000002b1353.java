
import java.util.*;
import java.io.*;
public class Solution {
    static long[][] pascalTower;
    static int pascalTowerSize = 50;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<String> resultList;
        pascalTower =generatePascalTower(pascalTowerSize);

        for (int i = 1; i <= testSetSize; ++i) {

            int pascalSum = in.nextInt();
            resultList = solve(pascalSum);
            System.out.println("Case #" + i + ": ");
            for(int t=0; t<resultList.size(); t++){
                System.out.println(resultList.get(t));
            }
        }


    }

    public static List<String> solve(int pascalSum){
        List<String> resultList = new ArrayList<>();
        int sum = 0;
        int r= 0,k=0;
        int counter = 0;

        boolean derechaAIzquiera = true;
        //resultList.add("1 1");
        while(calculateRRowSum(r) + sum <= pascalSum){

            if(derechaAIzquiera){
                k=0;
                while(pascalTower[r][k] != 0){
                    resultList.add(Integer.valueOf(r+1) + " " + Integer.valueOf(k+1));
                    sum += pascalTower[r][k];
                    counter++;
                    //System.out.println(Integer.valueOf(r+1) + " " + Integer.valueOf(k+1));
                    k++;
                }
            }else{// recorro de izquierda a derecha
                k=r;
                while(k>=0 && pascalTower[r][k] != 0  ){
                    resultList.add(Integer.valueOf(r+1) + " " + Integer.valueOf(k+1));
                    sum += pascalTower[r][k];
                    counter++;
                    //System.out.println(Integer.valueOf(r+1) + " " + Integer.valueOf(k+1));
                    k--;
                }
            }

            derechaAIzquiera = !derechaAIzquiera;
            r++;
        }
        while(sum < pascalSum){
            if (pascalTower[r][1] + sum <pascalSum){
                if (k==0) {
                    resultList.add(Integer.valueOf(r + 1) + " " + Integer.valueOf(k + 2));
                }
                else {
                    resultList.add(Integer.valueOf(r+1) + " " + Integer.valueOf(k));
                }
            }
            sum += pascalTower[r][1];
            resultList.add(Integer.valueOf(r+1) + " " + Integer.valueOf(k+1));
            sum += 1;
            if(k !=0){
                k++;
            }
            r++;
        }
        //System.out.println("SUM = " + sum);
        //System.out.println("Number of Steps = " + counter);
        return resultList;
    }

    static int calculateRRowSum(int r){
        int sum = 0;
        for(int k = 0;k<pascalTowerSize;k++){
            sum += pascalTower[r][k];
        }
        return sum;
    }

    public static long[][] generatePascalTower(int pascalTowerSize){
        long[][] pascalTower = new long[pascalTowerSize][pascalTowerSize];
        pascalTower[0][0] = 1;
        pascalTower[1][0]= 1;
        pascalTower[1][1] = 1;

        for(int r = 2;r< pascalTowerSize;r++){
            for(int k=0;k<pascalTowerSize;k++){
                if(k == 0 || k == r){
                    pascalTower[r][k] = 1;
                }else{
                    pascalTower[r][k] = pascalTower[r-1][k-1] + pascalTower[r-1][k];
                }
            }

        }
        return pascalTower;
    }





}