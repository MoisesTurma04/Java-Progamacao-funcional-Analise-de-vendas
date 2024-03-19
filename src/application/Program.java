package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Entre o caminho do arquivo: ");
			String path = sc.nextLine();
			List<Sale> list = new ArrayList<>();

			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] parts = line.split(",");
					if (parts.length >= 5) {
						try {
							Integer month = Integer.parseInt(parts[0]);
							Integer year = Integer.parseInt(parts[1]);
							String seller = parts[2];
							Integer items = Integer.parseInt(parts[3]);
							Double total = Double.parseDouble(parts[4]);

							Sale sale = new Sale(month, year, seller, items, total);
							list.add(sale);
						} catch (NumberFormatException e) {
							System.out.println("Error parsing line: " + line);
						}
					}
				}
			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
				return;
			}
			System.out.println();

			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");
			List<Sale> topSales2016 = list.stream().filter(sale -> sale.getYear() == 2016)
					.sorted((s1, s2) -> Double.compare(s2.getTotal() / s2.getItems(), s1.getTotal() / s1.getItems()))
					.limit(5).collect(Collectors.toList());

			for (Sale sale : topSales2016) {
				System.out.println(String.format("%d/%d, %s, %d, %.2f, pm = %.2f", sale.getMonth(), sale.getYear(),
						sale.getSeller(), sale.getItems(), sale.getTotal(), sale.averagePrice()));
			}

			System.out.println();

			System.out.print("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = ");
			Double totalSoldByLogan = list.stream()
					.filter(sale -> sale.getSeller().equals("Logan") && (sale.getMonth() == 1 || sale.getMonth() == 7))
					.mapToDouble(Sale::getTotal).sum();

			System.out.println(totalSoldByLogan);

		}
	}
}
