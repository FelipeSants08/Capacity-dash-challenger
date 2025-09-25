package fiap.com.capacitydash.service;

import fiap.com.capacitydash.model.Motorcycle;
import fiap.com.capacitydash.repository.MotorcycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotorcycleService {

    private final MotorcycleRepository repository;

    private final QrCodeService qrCodeService;

    public List<Motorcycle> getAllMotorcycles(){
        return repository.findAll();
    }

    public Motorcycle getMotorcycleById(long id){
         Motorcycle moto = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("ID não encontrado"));
         qrCodeService.generateQRCode(moto.getIdMotorcycle());
         return moto;
    }

    public Motorcycle save(Motorcycle motorcycle) {
        return repository.save(motorcycle);
    }

}
