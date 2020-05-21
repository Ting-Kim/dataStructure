package sortingAndSearching;

/*
 * Quick Sort(퀵소트) - 시간복잡도 : O(nlog(n))
 * 정렬되지 않은 배열 안에서 랜덤으로 하나의 값을 기준으로 정하고,
 * 기준값을 기준으로 작은 값들은 왼쪽, 큰 값들은 오른쪽으로 정렬한다.
 * 재귀호출을 통해 반복해서 파티션의 단위가 낱개가 될 때까지 나누어 정렬하는 방법이다.
 * 재귀함수를 반환할 떄는 
 * 선택한 기준값이 반복해서 가장 작거나 큰값만을 선택하는 최악의 경우에는 O(n^2)
 * start point , end point를 정하고 pivot 값을 기준으로 호인터를 한개씩 이동
 * start, end가 범위를 벗어나면 반복함수 종료.
 */
public class Quick_Sort {
	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);	//	시작위치, 끝위치를 받아서 재귀함수 호출
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);	//	나눈 파티션의 오른쪽 방 첫번째 값
		if (start < part2 -1 ) {
			quickSort(arr, start, part2 - 1 );
		}
		if (part2 < end) {
			quickSort(arr, part2, end);
		}
		
	}
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];
		while (start <= end) {
			while (arr[start] < pivot) start++;
			while (arr[end] > pivot) end--;
			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	
	private static void printArray(int [] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		int [] arr = {3,9,6,2,7,0,1,5,4,8};
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}
	
}
