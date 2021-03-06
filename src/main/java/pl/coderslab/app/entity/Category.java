package pl.coderslab.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotNull
    @Size(min=5)
    private String name;

    @Column(nullable = false)
    private String description;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
//    private List<Article> articles = new ArrayList<>();

//    public Category(@Max(value = 100) String name, @Nullable String description) {
//        this.name = name;
//        this.description = description;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
