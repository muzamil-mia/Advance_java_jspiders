package arrays;

import java.util.HashMap;

public class FirstNonRepeating {

	public static void main(String[] args) {
		int[] arr = {9,4,9,6,7,4};
		int result = firstNonRepeating(arr);
		System.out.println(result);
	}

	private static int firstNonRepeating(int[] arr) {
//		for(int i = 0; i < arr.length-1; i++) {
//			for(int j = 0; j < arr.length; j++) {
//				if(i != j && arr[j] == arr[i]) {
//					break;
//				}
//				if(j == arr.length-1) {
//					return arr[i];
//				}
//			}
//		}
//		return -1;
		
		
		
		
		//using hashmap
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		//traverse array again and return first element with count 1
		for(int i = 0; i < arr.length; i++) {
			if(map.get(arr[i]) == 1) {
				return arr[i];
			}
		}
		return -1;
		
	}
}
