package sortingAndSearching;

/**
 * @author Taeho Kim
 * @date 2020. 5. 9. 오후 8:38:38
 * @subject Merge Sort(병합정렬)
 * @content 	모든 엘리먼트를 분할하고 크기를 비교하여 하나의 그룹으로 병합
 * 					시간 복잡도 O(nlogn)
 */
public class Merge_Sort {
	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
		
	}
	
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start+end) /2;
			mergeSort(arr, tmp, start, mid);			//	데이터를 1개 단위까지 쪼개고 2개로 
			mergeSort(arr, tmp, mid+1, end);		//	재귀함수가 돌아왔을 땐 두 방이 정렬된 상태.
			merge(arr,tmp, start, mid, end);	
			
		}
	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {		// tmp에  arr배열을 복사
			tmp[i] = arr[i];				
		}
		int part1 = start;		// 첫번째 배열의 첫 index
		int part2 = mid+1;	// 두번째 배열의 첫 index
		int index = start;
		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for (int i = 0; i <= mid - part1; i++) {		// 앞쪽 포인터가 배열의 끝에서 남은 만큼을 돌면서 최종적으로 저장할 배열에 남은값들을 붙여줌.
			arr[index + i] = tmp[part1 + i];
		}		
		//	뒤쪽 배열에 데이터가 남아있는 경우, arr배열에 이미 뒤쪽에 위치해 있기 때문에 따로 코드를 줄 필요가 없다.
		
	}
	
	
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
		
	}

}
