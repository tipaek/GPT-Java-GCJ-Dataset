public class CodeJamProblem1 {
    public static void main(String[] args) {
//        int[][] nums={{2,2,2,2},{2,3,2,3},{2,2,2,3},{2,2,2,2}};
//        int[][] nums={{2,1,3},{1,3,2},{1,2,3}};
        int[][] nums={{1,2,3,4},{2,1,4,3},{3,4,1,2},{4,3,2,1}};


        int trace=0, numOfRows=0, numOfCol=0;
//FINDING TRACE
        for (int i=0; i<nums.length; i++)
        {
            for (int j=0; j<nums[i].length; j++)
            {
                System.out.print(nums[i][j]+" ");
                if (i==j)
                    trace+=nums[i][j];
            }
            System.out.println();
        }
        //FINDING REPEATING ROWS
        label1:
        for (int i=0; i<nums.length; i++)
        {
            int a=nums[i][0];
            int b=nums[i][0];

            for (int j=0; j<nums.length-1;j++)
                if (a!=nums[i][j+1]&&b!=nums[i][j+1])
                {
                    a = Math.max(nums[i][j], nums[i][j+ 1]);
                    b = Math.min(nums[i][j], nums[i][j+ 1]);
                }
                else {
                    numOfRows++;
                    continue  label1;
                }


        }
//FINDING REPEATING COLOUMNS
        label:
        for (int i=0; i<nums.length; i++)
        {
            int c = nums[0][i];
            int d = nums[0][i];
            for (int j=0; j<nums.length-1; j++) {
                if (c != nums[j+1][i] && d != nums[j + 1][i]) {
                    c = Math.max(nums[j][i], nums[j + 1][i]);
                    d = Math.min(nums[j][i], nums[j + 1][i]);
                } else {
                    numOfCol++;
                    continue label;
                }
            }
        }
        System.out.println("Answer is: "+ trace+" "+numOfRows+" "+numOfCol);
    }

}
