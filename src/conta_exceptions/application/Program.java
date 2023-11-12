package conta_exceptions.application;

import java.util.Locale;
import java.util.Scanner;

import conta_exceptions.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe os dados da conta");
		System.out.println("Numero: ");
		int number = scanner.nextInt();

		System.out.println("Titular: ");
		scanner.next();
		String holder = scanner.nextLine();

		System.out.println("Saldo Inicial: ");
		Double balance = scanner.nextDouble();

		System.out.println("Limite do saque: ");
		Double withDraw = scanner.nextDouble();

		Account account = new Account(number, holder, balance, withDraw);

		System.out.println();
		System.out.println("Informe uma quantia para sacar: ");
		Double amount = scanner.nextDouble();

		try {
			account.withDraw(amount);
			System.out.printf("Novo saldo: %.2f%n", account.getBalance());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		scanner.close();

	}
}
