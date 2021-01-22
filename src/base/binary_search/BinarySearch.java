package base.binary_search;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] array = {1, 3, 8, 11, 44, 378, 999};
		int target = 44;
		
		int answer = binarySearch(array, target);

		System.out.println(answer);
		System.out.println(7/2);
	}
	
	public static int binarySearch(int[] array, int target) {
		
		int start = 0;
		int end = array.length - 1;		
		int mid = (start + end) / 2;
		
		while(end - start >= 0) {
			if(array[mid] == target) {
				return mid;
			}else if(array[mid] < target) {
				start = mid + 1;
			}else if(array[mid] > target) {
				end = mid - 1;
			}
			mid = (start + end) / 2;		
		}
		
		return -1;
	}	
}
