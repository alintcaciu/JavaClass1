
public class Tema3_maximum_subarray {

	public static int max_subarray(int[] a) 
	{
		int max_ending_here = 0;
		int max_so_far = 0;
		for (int x : a) 
		{
			max_ending_here = Math.max(0, max_ending_here + x);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
return max_so_far;
		
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] x = new int [9];
		x[0] = -2;
		x[1] = 1;
		
		x[2] = -3;
		x[3] = 4;
		
		x[4] = -1;
		x[5] = 2;
		
		x[6] = 1;
		x[7] = -5;
		
		x[8] = 4;
		
		 System.out.println(max_subarray(x));;
		 
		 
	}

}
