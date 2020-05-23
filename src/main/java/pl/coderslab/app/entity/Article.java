package pl.coderslab.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=200)
    @NotBlank
    @Size(max = 200)
    private String title;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @NotNull
    @Size(min=500)
    private String content;

    private LocalTime created;

    private LocalTime updated;

//    public Article(@Max(value = 200) String title, Author author, List<Category> categories, String content, LocalTime created, LocalTime updated) {
//        this.title = title;
//        this.author = author;
//        this.categories = categories;
//        this.content = content;
//        this.created = created;
//        this.updated = updated;
//    }



    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getContent() {
        return content;
    }

    public LocalTime getCreated() {
        return created;
    }

    public LocalTime getUpdated() {
        return updated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(LocalTime created) {
        this.created = created;
    }

    public void setUpdated(LocalTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", categories=" + categories +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
