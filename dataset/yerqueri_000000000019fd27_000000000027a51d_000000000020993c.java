public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int size = in.nextInt();
        for(int x=0;x<size;x++) {
            in.nextLine();
            int mats = in.nextInt();
            in.nextLine();
            int r = 0;
            int c = 0;
            int k = 0;
            for (int i = 0; i < mats; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                boolean flag = false;
                for (int j = 0; j < mats; j++) {
                    int temp = in.nextInt();
                    row.add(temp);
                    flag &= set.add(temp);
                }
                if (flag) {
                    r++;
                }
                in.nextLine();
                matrix.add(row);
            }
            for (int i = 0; i < mats; i++) {
                for (int j = 0; j < mats; j++) {
                    if (i == j) {
                        k += matrix.get(j).get(i);
                    }
                }
                boolean flag = false;
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < mats; j++) {
                    flag &= set.add(matrix.get(j).get(i));
                }
                if (flag) {
                    c++;
                }
            }
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        }
    }
}