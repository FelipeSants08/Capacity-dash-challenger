package fiap.com.capacitydash.service;

import fiap.com.capacitydash.model.Movement;
import fiap.com.capacitydash.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository movementRepository;

    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    public Movement create(Movement movement) {
        return movementRepository.save(movement);
    }

}
