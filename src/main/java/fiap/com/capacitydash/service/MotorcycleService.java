package fiap.com.capacitydash.service;

import fiap.com.capacitydash.model.Motorcycle;
import fiap.com.capacitydash.model.ParkingSpace;
import fiap.com.capacitydash.repository.MotorcycleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotorcycleService {

    private final MotorcycleRepository repository;
    private final ParkingSpaceService parkingSpaceService;

    public List<Motorcycle> getAllMotorcycles(){
        return repository.findAll();
    }

    public Motorcycle getMotorcycleById(long id){
        return repository.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("ID não encontrado"));
    }

    public Motorcycle save(Motorcycle motorcycle) {
        return repository.save(motorcycle);
    }

    public void deleteById(long id){
        Motorcycle motorcycle = getMotorcycleById(id);
        if(motorcycle.getParkingSpace() != null){
            ParkingSpace space = motorcycle.getParkingSpace();
            space.setMotorcycle(null);
            space.setOccupied(false);
            motorcycle.setParkingSpace(null);
            parkingSpaceService.update(space.getParkingSpaceId(), space);
        }
        repository.delete(motorcycle);
    }

    public boolean existsByPlate(String placa){
        return repository.existsByPlate(placa);
    }

    public Motorcycle updateMotorcycle(Long id, Motorcycle motorcycle) {
        Motorcycle motorcycleAntiga = getMotorcycleById(id);
        Motorcycle motorcycleAtualizada = Motorcycle.builder()
                .idMotorcycle(motorcycleAntiga.getIdMotorcycle())
                .plate(motorcycle.getPlate() != null ? motorcycle.getPlate() : motorcycleAntiga.getPlate())
                .model(motorcycle.getModel() != null ? motorcycle.getModel() : motorcycleAntiga.getModel())
                .color(motorcycle.getColor() != null ? motorcycle.getColor() : motorcycleAntiga.getColor())
                .parkingSpace(motorcycle.getParkingSpace() != null ? motorcycle.getParkingSpace() : motorcycleAntiga.getParkingSpace())
                .build();
        return repository.save(motorcycleAtualizada);
    }

    public Motorcycle findByPlate(String plate){
        return repository.findByPlate(plate);
    }

}
