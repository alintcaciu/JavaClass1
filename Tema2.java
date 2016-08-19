import java.util.Scanner;
/**
 * 
 */

/**
 * @author atcaciu
 *
 */
public class Tema2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("rezolvam factorial");
		
			
		//System.out.println("**************************************");
		
		System.out.print("Input n = ");
		Scanner s = new Scanner(System.in);
		int read_n = s.nextInt(); 
		System.out.println("**************************************");
		
				
		int i = 0;
		
		int rezultat_factorial = 1;
		
		while (i < read_n)
		{
			rezultat_factorial = rezultat_factorial * (i+1);
			i++;
		}
		System.out.println("Rezultat factorial pentru N = "  + read_n + " este => " + rezultat_factorial + "\n");
		System.out.println("**************************************");
	}

}
