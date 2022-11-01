package list;

import java.awt.image.RescaleOp;

public class radixsort {

	public static void radixSort(int[] arr) {
		if (arr == null|| arr.length < 2) {
			return;
		}
		radixSort(arr, 0, arr.length - 1, maxbits(arr));
	}
	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int res = 0;
		while (max != 0) {
			res++;
			max /=10;
		}
		return res;
	}
	public static void radixSort(int[] arr,int L,int R,int digit) {
		final int radix = 10;
		int i = 0,j = 0;
		//count[1] ��ǰλ��d����1��0�������ж��ٸ�
		//count[1] ��ǰλ��d����1,2��0�������ж��ٸ�
		//count[i] ��ǰλ��d����i~0�������ж��ٸ�
		int[] bucket = new int[R-L+1];
		for (int d = 1; d <= digit; d++) {
			int[] count = new int[radix];
			for (i = L; i <=R; i++) {
			j = getDigit(arr[i], d);
			count[j]++;
			}
			for(i=1;i<radix;i++) {
				count[i] = count[i] + count[i-1];
			}
			for(i = R;i>=L;i--) {
				j =getDigit(arr[i], d);
				bucket[count[j]-1] = arr[i];
				count[j]--;
			}
			for(i = L,j=0;i<=R;i++,j++) {
				arr[i] = bucket[j];
			}
		}
	}
	public static int getDigit(int x,int d) {
		return((x/((int)Math.pow(10, d-1)))%10);
	}
}
