package arrays;

public class EquilibriumIndex {

	public static void main(String[] args) {
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
//		int index = findEquilibriumIndex(arr, arr.length);
//		System.out.println(index);
		
		//method 2
		int index = findEquilibriumIndex(arr, arr.length,0,0);
		System.out.println(index);
	}

	private static int findEquilibriumIndex(int[] arr, int length, int leftSum, int rightSum) {
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		for(int i = 0; i < arr.length; i++) {
		total = total-arr[i];
			if(leftSum == total) {
				return i;
			}
			leftSum+=arr[i];
		}
		return -1;
	}

	private static int findEquilibriumIndex(int[] arr, int length) {
		int leftsum = 0, rightsum = 0;
		for(int i = 0; i < arr.length; i++) {
			leftsum = 0;
			for(int j = 0; j<i; j++) {
				leftsum += arr[j];
				//System.out.println(leftsum);
			}
			rightsum = 0;
			for(int j = i + 1; j < arr.length; j++) {
				rightsum += arr[j];
				//System.out.println(rightsum);
			}
			if(leftsum == rightsum) {
				return i;
			}
		}
		return -1;
	}
}
