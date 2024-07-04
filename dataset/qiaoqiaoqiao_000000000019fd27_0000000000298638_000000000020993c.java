class Solution{
    public int[] pro(int[][] matrix) {
        int[] res = new int[]{0,0,0};
    
        for (int i = 0; i < matrix.length; i++) {
            res[0] += matrix[i][i];
        }
        for (int i = 0; i < matrix.length; i++) {
            Map<Integer,Integer> s = new HashMap<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j],0);
                }
                map.put(matrix[i][j],map.get(matrix[i][j])+1);
                if (map.get(matrix[i][j])>res[1] && map.get(matrix[i][j])!=1) {
                    res[1] = map.get(matrix[i][j]);
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            Map<Integer,Integer> s = new HashMap<>();
            for (int i = 0; i < matrix.length; i++) {
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j],0);
                }
                map.put(matrix[i][j],map.get(matrix[i][j])+1);
                if (map.get(matrix[i][j])>res[2] && map.get(matrix[i][j])!=1) {
                    res[2] = map.get(matrix[i][j]);
                }
            }
        }
        return res;
    }
}