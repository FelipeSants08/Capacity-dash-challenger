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

    public ParkingSpace findById(Long idParkingSpace) {
        return parkingSpaceRepository.findById(idParkingSpace)
                .orElseThrow(() -> new RuntimeException("ID não encontrado"));
    }

    public void verificarOcupacao(Long idParkingSpace) {
        ParkingSpace parkingSpace = findById(idParkingSpace);
        if (parkingSpace.getMotorcycle() != null){
            parkingSpace.setOccupied(true);
        }
        else {
            parkingSpace.setOccupied(false);
        }
        parkingSpaceRepository.save(parkingSpace);
    }



}
