package dbexperiment;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name="Product",catalog="testDB",schema="")
@XmlRootElement

public class Product implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Long productID;

    @Column(name = "product_name")
    private String productName;


    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!getProductID().equals(product.getProductID())) return false;
        return getProductName().equals(product.getProductName());
    }

    @Override
    public int hashCode() {
        int result = getProductID().hashCode();
        result = 31 * result + getProductName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                '}';
    }
}
