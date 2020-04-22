package pl.coderslab.app.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(name="created_on")
    private LocalDateTime createdOn;
    @Column(name="updated_on")
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist(){
        createdOn=LocalDateTime.now();
    }
    @PreUpdate
    public  void preUpdate(){
        updatedOn = LocalDateTime.now();
    }
}
