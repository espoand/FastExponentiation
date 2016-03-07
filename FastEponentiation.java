import java.util.ArrayList;
import java.util.Scanner;

public class FastExpoentiation {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		ArrayList<Integer> holderArray = new ArrayList<Integer>();
		
		System.out.println("This program makes use of fast exponentiation to calculate X ^ Y modulus Z.");
		System.out.println("Any decmimal values will be rounded down. \n");
		System.out.print("Enter the base: ");
			int base = (int) Math.floor(input.nextInt());
		System.out.print("Enter the exponent: ");
			int expo = (int) Math.floor(input.nextInt());		
		System.out.print("Enter the modulus: ");
			int modBy = (int) Math.floor(input.nextInt());

		int holderValue = expo;

		 while(holderValue >= 1){
			holderArray.add(holderValue);
			holderValue = Math.floorDiv(holderValue, 2);
		}
		holderArray.add(0);
	
		int answer = 0;
		for(int position = holderArray.size() - 1; position >= 0; position--){
			if(holderArray.get(position) == 0) {
				answer = Math.floorMod((int) Math.pow(base, 0), modBy);
			}
			else if(Math.floorMod(holderArray.get(position), 2) == 0){
				answer = Math.floorMod((int) Math.pow(answer, 2), modBy);
			}
			else if(Math.floorMod(holderArray.get(position), 2) != 0){
				answer = Math.floorMod(Math.floorMod((int) Math.pow(answer, 2), modBy) * base, modBy);
			}
		}
		System.out.printf("%d ^ %d mod %d = %d", base, expo, modBy, answer);
		input.close();
	}
}
