package arrays;

import java.util.Arrays;

public class LeftRotation {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2;
		//rotateArray(arr, d);
		//System.out.println(Arrays.toString(arr));
		
		//second method
		roateArrayByK(arr, d, arr.length);
	}

	private static void roateArrayByK(int[] arr, int d, int n) {
		//store rotated version of array
		int[] temp = new int[n];
		int k = 0;
		//storing n-d elements of array[] to the front of temp[]
		for(int i = d; i < arr.length; i++) {
			temp[k++] = arr[i];
		}
		
		//storing the first d elements in temp
		for(int i = 0; i < d; i++) {
			temp[k++] = arr[i];
		}
		//print the rotated version of array
		System.out.println(Arrays.toString(temp));
	}

	private static void rotateArray(int[] arr, int d) {
		for(int i = 0; i < d; i++) {
			int temp = arr[i];
			for(int j = 0; j < arr.length-1; j++) {
				arr[j] = arr[j+1];
			}
			arr[arr.length-1] = temp;
		}
	}
}
