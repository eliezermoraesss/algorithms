package algorithms;

public class BinarySearch {
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] sortedArray = {20, 12, 1, 3, 5, 7, 9, 11, 13, 15};
		System.out.println("Binary Search (7): " + binarySearch(sortedArray, 20));
	}
}
