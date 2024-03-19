package entities;

public class Sale {

	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double total;

	public Sale() {

	}

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	public String getSeller() {
		return seller;
	}

	public Integer getItems() {
		return items;
	}

	public Double getTotal() {
		return total;
	}

	public Double averagePrice() {
		try {
			if (items == 0) {
				return 0.0;
			}
			return total / items;
		} catch (ArithmeticException e) {
			System.err.println("Erro: Divisão por zero. Verifique o valor de 'items'.");
			return null;
		}
	}

	@Override
	public String toString() {
		return "Sale [month=" + month + ", year=" + year + ", seller=" + seller + ", items=" + items + ", total="
				+ total + ", averagePrice=" + averagePrice() + "]";
	}

}