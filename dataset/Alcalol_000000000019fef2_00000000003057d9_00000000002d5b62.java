import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //Set up input scanner
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        //Receive first line (How many cases?)
        int caseCount = in.nextInt();

        for(int i = 1; i <= caseCount; i++){
            //Pass input to question method
            Q_One(i, in);
        }
    }

    //ROUND 1B
    public static void Q_One(int ident, Scanner in){

        int x = in.nextInt();
        int y = in.nextInt();

        int totalPower = Math.abs(x) + Math.abs(y) - 1;
        boolean impossible = false;

        //One must be odd and one must be even
        if((x % 2 != 0 && y % 2 == 0) || (x % 2 == 0 && y % 2 != 0)){
            //Total of X + Y must be a power of 2 + 1
            impossible = !(totalPower > 0 && (totalPower & (totalPower - 1)) == 0);
        }
        else impossible = true;

        if(!impossible){
            int larger = 0;
            int smaller = 0;
            boolean inverted = false;

            if( Math.abs(x) > Math.abs(y)){
                larger = x;
                smaller = y;
                inverted = true;
            }
            else{
                larger = y;
                smaller = x;
            }

            HashMap<Integer, String> AllValues = new HashMap<Integer, String>();
            int val = totalPower;
            int count = 0;

            int xTotal = 0;
            int yTotal = 0;

            while(val > 1){
                if(count == 0){
                    if(inverted && x > 0){
                        AllValues.put(val, "E");
                        xTotal = val;
                    }
                    else if(inverted && x < 0){
                        AllValues.put(val, "W");
                        xTotal = val * -1;
                    }
                    else if(!inverted && y > 0) {
                        AllValues.put(val, "N");
                        yTotal = val;
                    }
                    else{
                        AllValues.put(val, "S");
                        yTotal = val * -1;
                    }
                }
                else{
                    if(inverted){
                        if(x > 0 && xTotal - val > x){
                            AllValues.put(val, "W");
                            xTotal -= val;
                        }
                        else if(x < 0 && xTotal + val < x){
                            AllValues.put(val, "E");
                            xTotal += val;
                        }
                        else{
                            if(yTotal == 0 && y > 0){
                                AllValues.put(val, "N");
                                yTotal = val;
                            }
                            else if (yTotal == 0 && y < 0){
                                AllValues.put(val, "S");
                                yTotal = val * -1;
                            }
                            else if(y > 0){
                                AllValues.put(val, "S");
                                yTotal -= val;
                            }
                            else{
                                AllValues.put(val, "N");
                                yTotal += val;
                            }
                        }
                    }
                    else{
                        if(y > 0 && yTotal - val > y){
                            AllValues.put(val, "S");
                            yTotal -= val;
                        }
                        else if(y < 0 && yTotal + val < y){
                            AllValues.put(val, "N");
                            yTotal += val;
                        }
                        else{
                            if(x > 0 && xTotal == 0){
                                AllValues.put(val, "E");
                                xTotal = val;
                            }
                            else if(x < 0 && xTotal == 0){
                                AllValues.put(val, "W");
                                xTotal = val * -1;
                            }
                            else if(x > 0){
                                AllValues.put(val, "W");
                                xTotal -= val;
                            }
                            else{
                                AllValues.put(val, "E");
                                xTotal += val;
                            }
                        }
                    }
                }

                val = val>>1;
                count++;
            }

            if(xTotal != x){
                if (x > 0){
                    if(x > xTotal){
                        AllValues.put(1, "E");
                    }
                    else{
                        AllValues.put(1, "W");
                    }

                }
                else{
                    if(x > xTotal){
                        AllValues.put(1, "E");
                    }
                    else{
                        AllValues.put(1, "W");
                    }

                }

            }
            else if(yTotal != y){
                if(y > 0){
                    if(y > yTotal){
                        AllValues.put(1, "N");
                    }
                    else{
                        AllValues.put(1, "S");
                    }

                }
                else{
                    if(y > yTotal){
                        AllValues.put(1, "N");
                    }
                    else{
                        AllValues.put(1, "S");
                    }

                }

            }

            String output = AllValues.values().toString().replace("[", ""). replace("]", "").replace(",", "").replace(" ", "");

            Print_Result(ident, output);

        }
        else{
            Print_Result(ident, "IMPOSSIBLE");
        }
    }
        public static void Print_Result(int ident, String output){
        //Print result
        System.out.println("Case #" + ident + ": " + output);
    }
}