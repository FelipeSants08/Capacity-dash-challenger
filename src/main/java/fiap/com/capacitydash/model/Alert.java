package fiap.com.capacitydash.model;

import jakarta.persistence.*;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LevelAlert levelAlert;

    @ManyToOne
    private Department department;

}
