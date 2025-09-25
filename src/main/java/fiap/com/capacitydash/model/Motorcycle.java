package fiap.com.capacitydash.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMotorcycle;

    private String plate;

    private String model;

    private String color;

    @OneToOne(optional = true)
    @JoinColumn(name = "parking_space_id", unique = true)
    private ParkingSpace parkingSpace;
}
