package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {

	// Category eklendikten sonra gün 8 de
	Product getByProductName(String productName);

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	// select * from products where product_name = abc and category_id=1 olan
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	// select * from products where category_id in(1,2,3,4)
	List<Product> getByCategoryIn(List<Integer> categories);

	// Ürünün ismine göre arama yapmak.
	List<Product> getByProductNameContains(String productName);

	// Ürün isimleri şununla başlayan veya biten araması yaptırmak için
	List<Product> getByProductNameStartsWith(String productName);

	// JPQL C#'daki link gibi
	// select * from products where product_name=bisey and category_id=bisey
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);

	// DTO 9.ders
	// select p.product_id,p.product_name, c.category_name,p.unit_price from
	// products p inner join categories c on p.category_id =c.category_id
	
	// select p.productId,p.productName ,c.categoryName from category c inner join
	// Product p on c.categoryId=p.categoryId
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
