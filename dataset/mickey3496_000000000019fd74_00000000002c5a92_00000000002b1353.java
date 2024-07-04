import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	private static List<List<Long>> producePascalList() {
        List<List<Long>> list = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) {
            List<Long> row = new ArrayList<>(32);
            if (i == 0) {
                row.add((long) 1);
            } else {
                row.add((long) 1);
                for (int j = 1; j < i; j++) {
                    row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
                row.add((long) 1);
            }
            list.add(row);
        }
        return list;
    }
 
    private static List<List<Long>> producePascalSumList(List<List<Long>> pascalList) {
        List<List<Long>> list = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) {
            List<Long> row = new ArrayList<>(pascalList.get(i).size());
            row.add((long) 1);
            for (int j = 1; j < i+1; j++) {
                row.add(row.get(j-1) + pascalList.get(i).get(j));
            }
            list.add(row);
        }
        return list;
    }
 
    private static List<Long> compute(List<List<Long>> pascalSumList, long number) {
        if (number <= 0) {
            return new ArrayList<>();
        }
        List<Long> ans = new ArrayList<>();
        long temp = 0;
        int i;
        for (i = 0; i < 32; i++) {
            long temp2 = temp + pascalSumList.get(i).get(i);
            if (temp2 >= number)
                break;
            temp = temp2;
        }
        long remainingNumber = number - temp;
        long temp3 = 0;
        int j;
        for (j = 0; j<=i; j++) {
            temp3 = pascalSumList.get(i).get(j);
            if (temp3 >= remainingNumber) {
                ans.addAll(compute(pascalSumList, number - temp3));
                ans.add((long) (j+1));
                break;
            }
        }
        return ans;
    }
 
    public static void main(String args[]) {
        List<List<Long>> pascalList = producePascalList();
        List<List<Long>> pascalSumList = producePascalSumList(pascalList);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long num = in.nextLong();
            List<Long> list = compute(pascalSumList, num);
            System.out.println("Case #" + (i+1) + ":");
            boolean startLeft;
            if (list.size() % 2 == 0) {
                startLeft = true;
            } else {
                startLeft = false;
            }
            for (int j = 0 ; j < list.size(); j++) {
                if (startLeft) {
                    for (int k = 0; k < list.get(j); k++) {
                        System.out.println((j+1) + " " + (k+1));
                    }
                    startLeft = false;
                } else {
                    for (long k = list.get(j) - 1; k >= 0; k--) {
                        System.out.println((j+1) + " " + (k+1));
                    }
                    startLeft = true;
                }
            }
        }
    }
}