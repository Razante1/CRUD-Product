package exemplo.crud.crud.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name ="product")
@Table(name ="product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    
    private String name;
    private Integer price;


    public Product(RequestProduct requestproduct) {
        this.name = requestproduct.name();
        this.price =  requestproduct.price(); 
    }
}
