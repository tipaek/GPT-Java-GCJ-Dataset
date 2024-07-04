class TestFile {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int argsNumber = 0;
		for (int i = 0; i < n; i++) {
			int size = Integer.parseInt(args[++argsNumber]);
			int finalNumber = 0;
			int rowNumber = 0;
			int colunmNumber = 0;
			int arr[][] = new int[size][size];
			for (int j = 0; j < size; j++) {
				
				for (int k = 0; k < size; k++) {
					arr[j][k] = Integer.parseInt(args[++argsNumber]);
					if (j == k) {
						finalNumber = finalNumber + arr[j][k];
					}
				}
			}
			for (int t = 0; t < size; t++) {
				int rowArr[] = new int[size];
				for (int j = 0; j < size; j++) {
					rowArr[j] = arr[t][j];
				}
				if (checkDuplicate(rowArr)) {
					rowNumber  = ++rowNumber;
				}
			}
			for (int t = 0; t < size; t++) {
				int colArr[] = new int[size];
				for (int j = 0; j < size ; j++) {
					colArr[j] = arr[j][t];
				}
				if (checkDuplicate(colArr)) {
					colunmNumber = ++colunmNumber;
				}
			}
			System.out.println("Case #"+(i+1)+": "+finalNumber +" "+rowNumber +" "+colunmNumber);
		}

	}

	private static boolean checkDuplicate(int[] value) {
	
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value.length; j++) {
				if ((i != j) && value[i] == value[j]) {
					return true;
				}
			}
		}
		return false;
	}

}
