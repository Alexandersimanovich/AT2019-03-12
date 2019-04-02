package by.it.okoyro.at08;

import java.util.Scanner;

public class ConsoleRunner {
	public static void main(String[] args) {
		Parser parser = new Parser();
		Printer printer = new Printer();

		Scanner sc = new Scanner(System.in);
		for (; ; ) {
			String expression = sc.nextLine();
			if (expression.equals("end")) {  /* сравнение должно быть через equals потому что литерал нельзя сравнить со
			строкой, полученной в переменной expression */
				break;
			}
			Var var = parser.calc(expression);
			printer.print(var);
		}
	}
}
