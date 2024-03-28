package arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
//		Input: nums = [1,1,2]
//				Output: 2, nums = [1,2,_]
//				Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//				It does not matter what you leave beyond the returned k (hence they are underscores).
		int[] nums = {1,1,2};
		int k = removeDuplicates(nums);
	}

	private static int removeDuplicates(int[] arr) {
		int i = 0;
        for(int j = 1; j < arr.length; j++) {
            if(arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
	}
}
