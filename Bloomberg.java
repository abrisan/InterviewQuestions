public class Bloomberg{
    
    static void findSum(int[] arr, int k){
	boolean[] b = new boolean[256];
	for(int i = 0 ; i < arr.length ; ++i){
	    if(b[k-arr[i]]){
		System.out.printf("%d %d\n", k-arr[i], arr[i]);
		b[k-arr[i]] = false;
	    }else{
		b[arr[i]] = true;
	    }
	}
    }



    public static void main(String[] args){
	int[] test = {1,2,1,2,1};
	findSum(test,3);
    }


}
