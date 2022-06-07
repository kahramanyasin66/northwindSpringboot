package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"}) // ürünün categorisinden tekrardan ürünler oradan tekrar category sonsuz döngüsüne girmesin diye 
public class Category {
	@Id	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name ="category_name")
	private String categoryName;
	
	// category olarak kendi tablomda 1 kere geçerim yani One ama gidecwğim yerde çok geçebilirim many oneToMany olur.
	@OneToMany(mappedBy="category")    // Product Tablosu bile aralarında bire çok ilişki var 	
	private List<Product> products;      // categori'nin ürünleri var.ürün listesi verecek

}
