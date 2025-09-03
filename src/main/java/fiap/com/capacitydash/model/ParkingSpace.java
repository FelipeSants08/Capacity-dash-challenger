package fiap.com.capacitydash.model;

import jakarta.persistence.*;

@Entity
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingSpaceId;

    private String code;

    private SpaceStatus spaceStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

}
