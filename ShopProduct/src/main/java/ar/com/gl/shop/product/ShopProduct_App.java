package ar.com.gl.shop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient

public class ShopProduct_App {

	public static void main(String[] args) {
//
//		final Stock stock = new Stock(1L, 200, "Estanteria 1");
//		final Category category = new Category("Golosinas", "Alfajor", 1L, true);
//		final Product product = new Product(1L, "Alfajor jorgito", "Alfajor de chocolate", 70.5, category, stock);
//
//		final Stock stock2 = new Stock(2L, 356, "Estanteria 2");
//		final Category category2 = new Category("Golosinas", "Chupetines", 2L, true);
//		final Product product2 = new Product(2L, "Chupetin Pop's", "Chupetin sabores variados", 15.5, category2,
//				stock2);
//
//		final Stock stock3 = new Stock(3L, 80, "Estanteria 3");
//		final Category category3 = new Category("Bebidas", "Bebida con gas", 3L, true);
//		final Product product3 = new Product(3L, "Fanta", "Bebida sabor naranja", 90.0, category3, stock3);
//
//		final Stock stock4 = new Stock(4L, 31, "Estanteria 3");
//		final Category category4 = new Category("Bebidas", "Bebida con gas", 4L, true);
//		final Product product4 = new Product(4L, "Pepsi", "Bebida sabor Cola", 79.9, category4, stock4);
//
//		final Stock stock5 = new Stock(5L, 40, "Estanteria 1");
//		final Category category5 = new Category("Golosinas", "Alfajor", 5L, true);
//		final Product product5 = new Product(5L, "Alfajor Havanna", "Alfajor de chocolate", 70.5, category5, stock5);
//
//		ArrayList<Stock> listaStock = new ArrayList<Stock>();
//
//		listaStock.add(stock);
//		listaStock.add(stock2);
//		listaStock.add(stock3);
//		listaStock.add(stock4);
//		listaStock.add(stock5);
//
//		ArrayList<Category> listaCategory = new ArrayList<Category>();
//
//		listaCategory.add(category);
//		listaCategory.add(category2);
//		listaCategory.add(category3);
//		listaCategory.add(category4);
//		listaCategory.add(category5);
//
//		ArrayList<Product> listaProducts = new ArrayList<Product>();
//
//		listaProducts.add(product);
//		listaProducts.add(product2);
//		listaProducts.add(product3);
//		listaProducts.add(product4);
//		listaProducts.add(product5);
//
//		System.out.println(
//				"Tienda de productos de Global Logic, seleccione 1 para ver informacion completa o 2 para ver solo los productos cargados");
//
//		Scanner reader = new Scanner(System.in);
//		int numero = 0;
//		int contador;
//		numero = reader.nextInt();
//
//		while (numero >= 3) {
//			System.out.println("Valor ingresado incorrecto, Elija los valores 1 o 2 ");
//			numero = reader.nextInt();
//		}
//
//		if (numero == 1) {
//			System.out.println("==============================");
//			System.out.println("Opcion 1");
//			System.out.println("==============================");
//
//			contador = 1;
//
//			for (Product productLeer : listaProducts) {
//
//				System.out.println(contador);
//				System.out.println("Producto: " + productLeer.getName());
//				System.out.println("Categoria: " + productLeer.getCategory().getName());
//				System.out.println("Stock: " + productLeer.getStock().getQuantity());
//				System.out.println("Precio: " + productLeer.getPrice());
//				System.out.println("==============================");
//				contador++;
//			}
//
//		} else {
//			System.out.println("==============================");
//			System.out.println("Opcion 2");
//			System.out.println("==============================");
//
//			contador = 1;
//
//			for (Product productLeer : listaProducts) {
//
//				System.out.println(contador);
//				System.out.println("Producto: " + productLeer.getName());
//				System.out.println("Stock: " + productLeer.getStock().getQuantity());
//
//				System.out.println("==============================");
//				contador++;
//			}
//		}
//

		SpringApplication.run(ShopProduct_App.class, args);

	}

}
