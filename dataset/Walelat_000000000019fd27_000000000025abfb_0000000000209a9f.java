import java.util.Scanner;

public class Solution{

    public static void main(String []args){
        int amount;

        Scanner in = new Scanner(System.in);
        amount = Integer.parseInt(in.nextLine());

        for (int i = 0; i<amount; i++){

            String mainS = in.nextLine();

            char[]main = mainS.toCharArray();
            StringBuilder[] array = new StringBuilder[mainS.length()];
            for (int g = 0; g< mainS.length(); g++){
                array[g] = new StringBuilder("");
            }

            usefulFunction('9', main, array);
            usefulFunction('8', main, array);
            usefulFunction('7', main, array);
            usefulFunction('6', main, array);
            usefulFunction('5', main, array);
            usefulFunction('4', main, array);
            usefulFunction('3', main, array);
            usefulFunction('2', main, array);
            usefulFunction('1', main, array);

            StringBuilder order = new StringBuilder("");

            for (int g = 0; g< mainS.length(); g++){
                if (array[g].toString().equals("")){
                    order.append("0");
                } else order.append(array[g]);
            }

            System.out.println("Case #" + (i + 1) + ": " + order);
        }
    }

    public static void usefulFunction(Character maxDigit, char [] main, StringBuilder[] array ){
        for (int j =0; j< main.length; j++){
            if (maxDigit.equals(main[j])){
                int ind1 = j, ind2 = j;
                int left = 0, right = 0;
                if (j!=0) {
                    while (maxDigit.equals(main[ind1 - 1])) {
                        ind1--;
                    }
                    left = Character.getNumericValue(main[ind1 - 1]);
                }

                while (ind2!= main.length-1 && maxDigit.equals(main[ind2 + 1])) {
                    ind2++;
                }
                if (ind2!= main.length-1) {
                    right = Character.getNumericValue(main[ind2 + 1]);
                }

                int max = Math.max(left, right);
                int curr = Character.getNumericValue(maxDigit);

                for (int f = ind1; f< ind2+1; f++){
                    if (array[f].toString().equals("")){
                        array[f].append(main[f]);
                    }
                    main[f] = Character.forDigit(max,10);
                }
                array[ind1].insert(0, new String(new char[curr-max]).replace("\0", "("));
                array[ind2].append(new String(new char[curr-max]).replace("\0", ")"));
            }
        }
    }
}