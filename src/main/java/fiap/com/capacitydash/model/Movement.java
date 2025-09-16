package fiap.com.capacitydash.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovement;

    @ManyToOne
    private Motorcycle motorcycle;

    @ManyToOne
    private ParkingSpace parkingSpace;

    private LocalDateTime dateTimeMovement;

}
