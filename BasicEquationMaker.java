/**
 * Basic Equation Maker
 * Code by SCIT
 * 
 * Given a string of numbers, turn it into a valid equation by inserting only one operator (+, -, *, /, or %) and one equals sign ('=') and return it. If it is not possible, return "Not possible" instead.
 * For example : 123123246
 * Return: 123+123=246
 */
import java.util.Scanner;

/* ===== Testing =====
class test1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Input: ");
		while (!in.hasNextLine()){
			System.out.print("Input: ");
		}
		String num = in.nextLine();
		BasicEquationMaker bem = new Calc(num);
		System.out.printf("Output: %s %n",bem.kq());
	}
}
*/

// ===== Real class =====
class BasicEquationMaker{
	private String num;
	
	public BasicEquationMaker(String str){
		num = str;
	}

	public String kq(){
		String kq="";
		int i=1;
		while (i<num.length()){
			long a = Long.parseLong(num.substring(0,i));
			int j = i+1;
			while (j<num.length()){
				long b = Long.parseLong(num.substring(i,j));
				long c = Long.parseLong(num.substring(j,num.length()));
				if (a+b == c){
					kq += a+"+"+b+"="+c+" | ";
				}else if (a-b == c){
					kq += a+"-"+b+"="+c+" |  ";
				}else if (a*b == c){
					kq += a+"*"+b+"="+c+" | ";
				}else if (a*1.0/b == c && b!=0){
					kq += a+"/"+b+"="+c+" | ";
				}else if (a*1.0%b == c && b!=0){
					kq += a+"%"+b+"="+c+" | ";
				}
				j++;
			}
			i++;
		}
		if (kq == ""){
			return "Not found!";
		}else{
			return kq.substring(0,kq.length()-2);
		}
	}
}

