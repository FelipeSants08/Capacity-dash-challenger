package fiap.com.capacitydash.service;

import fiap.com.capacitydash.model.ParkingSpace;
import fiap.com.capacitydash.repository.ParkingSpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;

    public List<ParkingSpace> findAll() {
        return parkingSpaceRepository.findAll();
    }


}
