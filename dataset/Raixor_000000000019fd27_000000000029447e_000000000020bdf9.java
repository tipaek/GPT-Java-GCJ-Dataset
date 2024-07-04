import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();
        for (int i = 1; i <= cases; i++) {
            int activities = scan.nextInt();
            String result = "";
            boolean impossible = false;
            boolean [] cameron = new boolean[1441];
            boolean [] jamie = new boolean[1441];
            for (int j = 0; j < activities; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                if(checkSchedule(start, end, cameron)){
                    setSchedule(start, end, cameron);
                    for (int k = 0; k < cameron.length; k++) {
                        //System.out.println("stelle: " + k + " " + cameron[k]);
                    }
                    result += "C";
                }else {
                    if(checkSchedule(start, end, jamie)){
                        setSchedule(start, end, jamie);
                        result += "J";
                    }else{
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }if(!impossible)
            System.out.println("Case #" + i + ": " + result);

        }
    }

    public static boolean checkSchedule(int start, int end, boolean [] array){
        if(start == 0 && array[0] ){
            return false;
        }
        if(end == 1440 && array[1440]){
            return false;
        }
        if(end-start == 1 && (array[start] && array[end])){
            if(!array[start-1] && !array[end+1]){
                return true;
            }
            return false;
        }
        if(end-start == 2 && (array[start] && !array[start+1] && array[end])){
            if(!array[start-1] && !array[end+1]){
                return true;
            }
            return false;
        }
        if((array[start] && array[start-1] && !array[start+1]) || !array[start]){
            //System.out.println("1. if");
            if((array[end] && array[end+1] && !array[end-1]) || !array[end]){
                //System.out.println("2. if");
                for (int i = start+1; i < end ; i++) {
                    //System.out.println("start: " + start + " end: " + end);
                    if(array[i]){
                        //System.out.println("rausgeflogen");
                        return false;
                    }
                }
            } else{
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    public static void setSchedule(int start, int end, boolean [] array){
        for (int i = start; i <= end; i++) {
            array[i] = true;
        }
    }


}

