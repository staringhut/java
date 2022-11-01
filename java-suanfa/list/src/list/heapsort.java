package list;

public class heapsort {

	public static void heapSort(int[] arr) {
		if (arr == null||arr.length<2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {//o(n)
			heapinsert(arr, i);
		}
//		for (int i = arr.length-1; i >=0; i--) {
//			heapify(arr, i, arr.length);
//		}
		int heapsize = arr.length;
		swap(arr, 0, --heapsize);
		while (heapsize > 0) {
			heapify(arr, 0, heapsize);//o(logN)
			swap(arr, 0, --heapsize);//o(1)
		}
	}
	
	public static void heapinsert(int[] arr,int index) {
		while (arr[index]>arr[(index-1)/2]) {
			swap(arr, index, (index-1)/2);
			index = (index-1)/2;
		}
	}
	
	public static void heapify(int[] arr,int index,int heapsize) {
		int left = index * 2 +1;
		while (left<heapsize) {
			int largest = left + 1 < heapsize && arr[left + 1]>arr[left]?
					left + 1:left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
		
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i]=arr[j];
		arr[j] = tmp;
	}
}
