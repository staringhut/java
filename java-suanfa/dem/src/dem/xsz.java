package dem;

public class xsz {
	
public static int getMax(int[] arr)
{
	return process(arr,0,arr.length-1);
}

int a,b;

int eor = a^b;
int onebye = eor&(~eor+1);


//≤Â»Î≈≈–Ú
public static void insertion(int []arr)
{
	for(int i = 1;i<arr.length;i++)
	{
		for(int j =i-1;j>=0 && arr[j]>arr[i+1];j--)
		{
			swap(arr,j,j+1);
				
		}
	}
}

public static void swap(int []arr,int i,int j)
{
	arr[i]=arr[i]^arr[j];
	arr[j]=arr[i]^arr[j];
	arr[i]=arr[i]^arr[j];
}

//µ›πÈ≈≈–Ú
public static int process(int[] arr,int L,int R) {
	// TODO Auto-generated method stub
	if(L == R)
	{
		return arr[L];
	}
	int mid = L + ((R-L)>>1);
	int leftmax = process(arr,L,mid);
	int rightmax = process(arr,mid+1,R);
	return Math.max(leftmax, rightmax);
}	

public static void process1(int[] arr,int L,int R) {
	// TODO Auto-generated method stub
	if(L == R)
	{
		return;
	}
	int mid = L + ((R-L)>>1);
	process1(arr,L,mid);
	process1(arr,mid+1,R);
	merge(arr,L,mid, R);
}	
public static void merge(int[] arr,int L,int M,int R) 
{
	int help[] = new int[R-L+1];
	int i= 0;
	int p1 = L;
	int p2 = M+1;
	while(p1<=M && p2 <= R)
	{
		help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
	}
	while(p1<=M)
	{
		help[i++] = arr[p1++];	
	}
	while(p2 <= R) {
		
		help[i++] = arr[p2++];
	}
	for (i=0 ;i<help.length;i++) {
		arr[L+i] = help[i];
	}
}
}


