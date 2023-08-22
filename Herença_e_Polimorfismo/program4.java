package Herença_e_Polimorfismo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.Product2;
import entities.UsedProduct;

public class program4 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product2> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.printf("Product #%d data: ", i);
			System.out.println("Cammon, used or imported (c/u/i)?: ");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Taxa de importacao: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			} else if(ch == 'u') {
				System.out.print("Data de fabricacao (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			} else {
				list.add(new Product2(name, price));
				
			}
			
		}
		System.out.println();
		System.out.println("ETIQUETAS DE PRECO:");
		for (Product2 prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	
	}

}
