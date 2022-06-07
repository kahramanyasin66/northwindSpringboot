package kodlamaio.northwind.business.abstracts;

import java.util.List;


import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	// List<Product> getAll(); eski kod
	DataResult<List<Product>> getAll();
	
	// bir sayfada kaç ürün görüntülenecek 
	DataResult<List<Product>> getAll(int pageNo , int pageSize);
	
	DataResult<List<Product>> getAllSorted();


	Result add(Product product);

	/*--------------------ders8'den sonra----------------------*/
	
	// Category eklendikten sonra gün 8 de
	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

	DataResult<List<ProductWithCategoryDto>>  getProductWithCategoryDetails();
}
