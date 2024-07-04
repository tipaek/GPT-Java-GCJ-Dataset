import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        in.nextLine();
        for(int i = 1; i <= numberOfCases; i++){
            ArrayList<Integer> listLine = new ArrayList<>();
            String line = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int parentesisAbiertos = 0;
            int parentesisCerrados = 0;
            int numberBefore = -1;
            for(int k = 0; k < line.length(); k++) {
                int number = Character.getNumericValue(line.charAt(k));
                if(numberBefore == -1 && number != numberBefore){
                    for(int j = 0; j < number; j++){
                        sb.append("(");
                        parentesisAbiertos++;
                    }
                }
                int currentNumber = number;
                switch (number){
                    case 0:
                        if(numberBefore != -1 && numberBefore != 0 && parentesisAbiertos != parentesisCerrados){
                            while(number < numberBefore){
                                sb.append(")");
                                parentesisCerrados++;
                                number++;
                            }
                        }
                        sb.append(currentNumber);
                        break;
                    case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                        int curretNumber = number;
                        if(numberBefore > number){
                            while(number < numberBefore){
                                sb.append(")");
                                parentesisCerrados++;
                                number ++;
                            }

                            sb.append(curretNumber);
                            sb.append("(");
                            parentesisAbiertos++;
                        }else if(numberBefore != number){
                            if(numberBefore != -1){
                                sb.append("(");
                                parentesisAbiertos++;
                            }
                            sb.append(number);
                        }else if(numberBefore == number){
                            sb.append(number);
                        }
                        break;
                }
                if(k == line.length()-1){
                    while(parentesisCerrados < parentesisAbiertos){
                        sb.append(")");
                        parentesisCerrados++;
                    }
                }
                numberBefore = currentNumber;
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
