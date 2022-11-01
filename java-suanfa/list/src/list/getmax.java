package list;

//递归求最大值
public class getmax {
	public static int Getmax(int[] arr) {
		return process(arr,0,arr.length-1);
		
	}
	public static int process(int[] arr,int L,int R) {
		if (L==R) {
			return arr[L];
		}
		int mid = L + ((R-L)>>1);
		int leftmax = process(arr, L, mid);
		int rightmax = process(arr, mid+1, R);
		return Math.max(leftmax, rightmax);
	}
//归并排序
	public static void mergesort(int[] arr) {
		if (arr==null||arr.length<2) {
			return;
		}
		process1(arr,0,arr.length-1);
		
	}
	public static void process1(int[] arr,int L,int R) {
		if (L==R) {
			return;
		}
		int mid = L + ((R-L)>>1);
		process1(arr, L, mid);
		process1(arr, mid+1, R);
		merge(arr, L, mid, R);
	}
	public static void merge(int[] arr,int L,int M,int R) {
		int[] help = new int [R-L+1];
		int i =0;
		int p1 = L;
		int p2 = M+1;
		while (p1<=M&&p2<=R) {
			help[i++] = arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
		}
		while (p1<=M) {
			help[i++]=arr[p1++];
		}
		while (p2<=M) {
			help[i++]=arr[p2++];
		}
		for (int j = 0; j < help.length; j++) {
			arr[L+j]=help[j];
		}
	}
	
}
