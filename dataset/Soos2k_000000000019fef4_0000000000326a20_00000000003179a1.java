import java.util.*;

public class Solution {
    public static final int queries = 10;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            int U = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[queries];
            String[] numStr = new String[queries];
            String[] encoded = new String[queries];
            for (int j = 0; j < queries; j++){
                String[] inputs = sc.nextLine().split(" ");
                numStr[j] = inputs[0];
                nums[j] = Integer.parseInt(inputs[0]);
                encoded[j] = inputs[1];
            }
            results[i] = "Case #" + (i+1) + ": " + randomized(U,nums,numStr,encoded);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String randomized(int U, int[] nums, String[] numStr, String[] encoded){
        char[] chars = new char[10];
        Set<Character> mark = new HashSet<>();
        int index = 0;
        int i = 0;
        while (index < 10){
            for (int j = 0; j < encoded[i].length(); j++){
                if (!mark.contains(encoded[i].charAt(j))){
                    chars[index] = encoded[i].charAt(j);
                    index++;
                    mark.add(encoded[i].charAt(j));
                }
            }
            i++;
        }
        for (int i0 = 0; i0 < 10; i0++){
            for (int i1 = 0; i1 < 10; i1++){
                for (int i2 = 0; i2 < 10; i2++){
                    for (int i3 = 0; i3 < 10; i3++){
                        for (int i4 = 0; i4 < 10; i4++){
                            for (int i5 = 0; i5 < 10; i5++){
                                for (int i6 = 0; i6 < 10; i6++){
                                    for (int i7 = 0; i7 < 10; i7++){
                                        for (int i8 = 0; i8 < 10; i8++){
                                            for (int i9 = 0; i9 < 10; i9++){
                                                boolean flag = true;
                                                boolean[] marked = new boolean[10];
                                                marked[i0] = true;
                                                marked[i1] = true;
                                                marked[i2] = true;
                                                marked[i3] = true;
                                                marked[i4] = true;
                                                marked[i5] = true;
                                                marked[i6] = true;
                                                marked[i7] = true;
                                                marked[i8] = true;
                                                marked[i9] = true;
                                                for (int j = 0; j < 10; j++){
                                                    if (!marked[j]) flag = false;
                                                }
                                                if (flag){
                                                    char[] getCharArr = new char[10];
                                                    Map<Character,Integer> decoded = new HashMap<>();
                                                    decoded.put(chars[i0],0);
                                                    getCharArr[0] = chars[i0];
                                                    getCharArr[1] = chars[i1];
                                                    getCharArr[2] = chars[i2];
                                                    getCharArr[3] = chars[i3];
                                                    getCharArr[4] = chars[i4];
                                                    getCharArr[5] = chars[i5];
                                                    getCharArr[6] = chars[i6];
                                                    getCharArr[7] = chars[i7];
                                                    getCharArr[8] = chars[i8];
                                                    getCharArr[9] = chars[i9];
                                                    decoded.put(chars[i1],1);
                                                    decoded.put(chars[i2],2);
                                                    decoded.put(chars[i3],3);
                                                    decoded.put(chars[i4],4);
                                                    decoded.put(chars[i5],5);
                                                    decoded.put(chars[i6],6);
                                                    decoded.put(chars[i7],7);
                                                    decoded.put(chars[i8],8);
                                                    decoded.put(chars[i9],9);
                                                    boolean check = true;
                                                    //System.out.println(Arrays.toString(getCharArr));
                                                    for (int j = 0; j < queries; j++){
                                                        if (decoded.get(encoded[j].charAt(0)) == 0){
                                                            check = false;
                                                            break;
                                                        }
                                                        int num = decoded.get(encoded[j].charAt(0));
                                                        for (int k = 1; k < encoded[j].length(); k++){
                                                            num = num*10 + decoded.get(encoded[j].charAt(k));
                                                        }
                                                        if (num > nums[j]) {
                                                            check = false;
                                                            break;
                                                        }
                                                    }
                                                    if (check){
                                                        return new String(getCharArr);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }
    
}