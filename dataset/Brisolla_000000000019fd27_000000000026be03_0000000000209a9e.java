import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        Integer numberOfBits = in.nextInt();

        for (int i = 1; i <= cases; i ++) {
            
            String currentArray = readAnArray(numberOfBits);
            
            List<String> possibilities = getPossibilities(currentArray);
            
            for (int j = 0; j < numberOfBits; j++){
                
                System.out.println(j);
                
                Integer currentBit = in.nextInt();
                
                for (String array : possibilities) {
                    if (array.toCharArray()[j] != currentBit)
                        possibilities.remove(array);
                }
                if (possibilities.size() == 1 || j == numberOfBits / 2 + 1) {
                    currentArray = possibilities.get(0);
                    break;
                }
            }
            System.out.println(currentArray);
        }
    }

    public static String readAnArray(Integer size) {

        Scanner in = new Scanner(System.in);

        String array = "";

        for (int j = 1; j <= size; j++) {

            System.out.println(j);

            array += in.nextInt();
        }
        
        return array;
    }

    public static List<String> getPossibilities(String array) {
    
        String complemented = complement(array);
        String reversed = reverse(array);
        String complementedReversed = complement(reversed);

        return Arrays.asList(array, complemented, reversed, complementedReversed);
    }


    private static String complement(String array) {

        String result = "";

        for (Character c : array.toCharArray()) {
            if (c == '0') result += "1";
            else result += "0";
        }
        return result;
    }

    private static String reverse(String array) {

        return new StringBuffer(array).reverse().toString();
    }

}
