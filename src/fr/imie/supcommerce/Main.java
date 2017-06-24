package fr.imie.supcommerce;

import java.util.ArrayList;

import fr.imie.supcommerce.database.CrudManager;
import fr.imie.supcommerce.entity.Category;
import fr.imie.supcommerce.entity.Product;

public class Main {

	public static void main(String[] args) {
		CrudManager crudManager = null;
		

		try {
			Category category = new Category("lol");
			Category category2 = new Category("lol2");
			
			Product product1 = new Product("test1","test lolokol",5.56F);
			Product product2 = new Product("test2","test lolokol",5.56F);
			
			crudManager = new CrudManager(Category.class);
			crudManager.add(category);
			crudManager.add(category2);
			
			product1.setCategory(category);
			
			crudManager = new CrudManager(Product.class);
			crudManager.add(product1);
			
			product1.setCategory(category2);
			
			crudManager.update(product1);
			
			crudManager = new CrudManager(Category.class);
			
			crudManager.findAll().forEach(item -> {
				System.out.println(((Category) item).getProducts());
			});
			
			
		} catch (ClassCastException e) {
			e.printStackTrace();
		}

	}

}
