package sortingAndSearching;

public class Bubble_Sort {
	
	private static void bubbleSort(int[] arr) {
		bubbleSort(arr,arr.length-1);
	}
	private static void bubbleSort(int[] arr, int last) {
		if (last > 0) {
			for (int i = 1; i <= last; i++) {
				if (arr[i-1]>arr[i]) {
					swap(arr,i-1,i);
				}
			}
			bubbleSort(arr, last-1);
		}
		
//		내가 짰던 코드
//		for (int i = arr.length-1; i >= 0; i--) {
//			for (int j = 0; j < i; j++) {
//				if (arr[j]>arr[j+1]) {
//					swap(arr,j,j+1);
//				}
//			}
//		}
	}
	
	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	
	private static void printArray(int[] array) {
		for (int data : array) {
			System.out.print(data + ", ");
		}	
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,6,1,8,2,4};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
}
