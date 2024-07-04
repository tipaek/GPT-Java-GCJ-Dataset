
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HimelSaha
 */
class Depth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();

        while (number > 0) {
            Scanner str = new Scanner(System.in);
            String s = str.nextLine();
            list.add(s);
            number--;
        }

        Depth d = new Depth();

        ArrayList<String> iter = d.method(list);

        for (int k = 0; k < iter.size(); k++) {
            System.out.println("Case #" + (k + 1) + ": " + iter.get(k));
        }
    }

    private ArrayList<String> method(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();

        for (int k = 0; k < list.size(); k++) {

            String newStr = null;
            String depthDone = null;

            String str = list.get(k);
            //System.out.println(str);

            for (int i = 0; i < str.length(); i++) {
                String temp = "" + str.charAt(i);
                int num = Integer.parseInt(temp);

                if (num == 0) {
                    newStr = "0";
                }
                if (num != 0) {
                    newStr = "(" + num + ")";
                    num--;
                }
                while (num != 0) {
                    if (newStr != null) {
                        newStr = "(" + newStr + ")";
                        num--;
                    }
                }

                if (depthDone == null) {
                    depthDone = newStr;
                } else {
                    depthDone += newStr;
                }

                //System.out.println(depthDone);
            }
            newList.add(depthDone);
        }
        return newList;
    }

}
