package rest.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Юыху on 19.01.2016.
 */
@XmlRootElement
public class Product {

    private int id;
    private int ownerId;
    private String name;
    private String description;
    private double value;
    private Date createdDate;

    public Product( int ownerId, String name, String description, double value, Date createdDate) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.value = value;
        this.createdDate = createdDate;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public Product setOwnerId(int ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getValue() {
        return value;
    }

    public Product setValue(double value) {
        this.value = value;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Product setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", createdDate=" + createdDate +
                '}';
    }
}
