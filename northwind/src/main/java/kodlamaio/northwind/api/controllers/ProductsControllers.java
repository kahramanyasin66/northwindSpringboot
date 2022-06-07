package kodlamaio.northwind.api.controllers;
//her dilden uygulama anlayacağı bir api yazıyoruz

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController // uygulamayı ayağa kaldıran sınıf projede gezdiğinde buranın bir api olduğunu
				// anlayacak
@RequestMapping("/api/products") // bu istek gelirse burası karşılayacak
public class ProductsControllers {
	private ProductService productService;

	@Autowired // productService'in somut sınıfı olan ve implemente eden peroductManager'ı
				// new'leyip productServise değişkenine yerleştiriyor.
	// birden fazla somut sınıf varsa Autowired patlar.
	public ProductsControllers(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") // getall isteğinde burası çalışacak
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	/*----------------------------------------------*/
	
	// requestParam kullanıcı bir değer yazacak onu bu şekilde al
	@GetMapping("/getByProductName")
	public DataResult<Product> 
	getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);

	}

	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> 
	getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory(productName,categoryId);
	}
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> 
	getByProductNameOrCategory(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory(productName,categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);		
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}

}
