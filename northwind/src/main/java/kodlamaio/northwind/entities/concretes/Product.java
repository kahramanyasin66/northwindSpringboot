package kodlamaio.northwind.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                    // lombok'tan geliyor getter and setter'larını hazırlıyor
@AllArgsConstructor      // lombok'tan geliyor dolu constructor'ını yaratıyor
@NoArgsConstructor       // lombok'tan geliyor boş constructor'ını yaratıyor
@Entity                  // JPA'dan geliyor bu class'ın bir entity veritabanı nesnesi olduğunu söylüyoruz.
@Table(name="products")  // Veritabanında hangi tabloya karşılık geliyor 
public class Product {
	@Id                          // Bu değerin kolonda primary key olduğunu söylüyoruz 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Değerin otomatik artan olduğunu söylüyoruz
	@Column(name="product_id") //  Tabloda  hangi kolona karşılık geliyor
	private int id;	
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;	
	
	/*@Column(name="category_id")
	private int categoryId;  buna gerek kalmadı altta joinledik */
	
	// Burada her bir product'ın bir category'si olduğunu biliyoruz list olmayacak yani
	// ve kendi tablomda benim bir çok product'ım aynı category değerine sahip olabilir many to one
	@ManyToOne()
	@JoinColumn(name="category_id") // bunu yaptığımız zaman bu product'ın category'si nedir ortaya çıkarıyoruz ve tutuyoruz.
	private Category category;
	
	
}
