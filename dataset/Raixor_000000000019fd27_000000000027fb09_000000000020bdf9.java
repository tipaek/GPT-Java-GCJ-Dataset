import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();
        for (int i = 1; i <= cases; i++) {
            int activities = scan.nextInt();
            boolean [] cameron = new boolean[1442];
            boolean [] jamie = new boolean[1442];
            boolean impossible = false;
            String result = "";
            for (int j = 0; j < activities; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                if(check(start, end, cameron)){
                    result += "C";
                } else{
                    if(check(start, end, jamie)){
                        result += "J";
                    } else{
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }
            if(!impossible)
            System.out.println("Case #" + i + ": " + result);

        }
    }

    public static boolean check(int start, int end, boolean [] array){
        boolean [] copy = array.clone();
        if(end-start == 1){
            if (!array[start] && !array[end]){
                array[start] = true;
                array[end] = true;
                return true;
            }else{
                return false;
            }
        }
        //noch nichts steht da
        if(start == 0 && array[start]){
            return false;
        }
        if(!array[start] || (array[start] && array[start-1] && !array[start+1])){
            for (int i = start+1; i <= end; i++) {
                //das letzte ist schon wahr, aber das danach auch, dann passt alles
                if(!array[end-1] && array[end] && array[end+1]){
                    //System.out.println("abgefangen");
                    array = copy.clone();
                    return false;
                }
                if(array[end] && array[end+1]){
                    //System.out.println("hallo");
                    return true;
                }
                if(array[i]){
                    //System.out.println("hier");
                    array = copy.clone();
                    return false;
                }
                array[i] = true;
            }
        }else{
            //System.out.println("hae");
            array = copy.clone();
            return false;
        }
        //System.out.println("was");
        return true;
    }
}

/*public static boolean check(int start, int end, boolean [] array){
        boolean [] copy = array.clone();
        //noch nichts steht da
        if(!copy[start] || (copy[start] && copy[start-1] && !copy[start+1])){
            for (int i = start; i <= end; i++) {
                //das letzte ist schon wahr, aber das danach auch, dann passt alles
                if(copy[end] && copy[end+1]){
                    array = copy;
                    return true;
                }
                if(copy[i]){
                    return false;
                }
                copy[i] = true;
            }
        }else{
            return false;
        }
        array = copy;
        return true;
    }*/
