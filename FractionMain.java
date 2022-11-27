import java.util.*;
public class FractionMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		estimatePi();
		fractionGame();
	}
	public static void estimatePi() {
		Fraction Milu = new Fraction(355, 113);
		Fraction approx = Milu;
		final double Epsilon = Math.abs(Math.PI-Milu.toDecimal());
		while (Math.abs(Math.PI-approx.toDecimal())>=Epsilon) {
			if(approx.toDecimal()>Math.PI) {
				approx.setDen(approx.getDen()+1);
			}
			else if(approx.toDecimal()<Math.PI) {
				approx.setNum(approx.getNum()+1);
			}
			else 
				break;
		}
		System.out.println(approx);
	}
	public static void fractionGame() {
		Fraction key = new Fraction(1,1);
		String answer;
		int total=0;
		int score=0;
		while(true) {
			Fraction f1 = new Fraction();
			Fraction f2 = new Fraction();
			int i = (int)(Math.random()*4+1);
			switch(i) {
				case 1:
					key = f1.add(f2); 
					System.out.println(f1 + " + " + f2); break;
				case 2:
					key = f1.substract(f2); 
					System.out.println(f1 + " - " + f2); break;
				case 3:
					key = f1.multiply(f2); 
					System.out.println(f1 + " * " + f2); break;
				case 4:
					key = f1.divide(f2); 
					System.out.println(f1 + " / " + f2); break;
				default:
					System.out.println("Error");
			}
			answer=scan.next();
			if(answer.equals("quit")==false) {
				if(new Fraction(answer).equals(key)) {
					score++;
					total++;
					System.out.println("Correct!\n");
				}
				else {
					total++;
					System.out.println("Wrong, the answer is "+ key + "\n");
				}
			}
			else {
				System.out.println("Your win loss ratio was "+ score + "/"+ total+ " for a score of "+ 100*new Fraction(score,total).toDecimal() + " percent");
				break;
			}
				
		}
	}
	public static void debug() {
		Fraction frac1=new Fraction();
		Fraction frac2=new Fraction(1,0);
		Fraction frac3=new Fraction("3/0");
		Fraction frac4=new Fraction(frac3);
		Fraction frac5=new Fraction(252,105);
		Fraction frac6=new Fraction(1,2);
		Fraction frac7=new Fraction(1,3);
		Fraction frac8=Fraction.multiply(frac6, frac7);
		Fraction frac9=Fraction.divide(frac7, frac6);
		Fraction frac10=Fraction.add(frac6, frac7);
		Fraction frac11=Fraction.substract(frac6, frac7);
		frac5.reduce();
		System.out.println("Fraction 1's value is: " + frac1);
		System.out.println("Fraction 2's value is: " + frac2);
		System.out.println("Fraction 3's value is: " + frac3);
		System.out.println("Fraction 4's value is: " + frac4);
		System.out.println(frac5);
		System.out.println(frac8);
		System.out.println(frac9);
		System.out.println(frac10);
		System.out.println(frac11);
		System.out.println(frac6.multiply(frac7));
		System.out.println(frac7.divide(frac6));
		System.out.println(frac7.add(frac6));
		System.out.println(frac6.substract(frac7));
	}
}
