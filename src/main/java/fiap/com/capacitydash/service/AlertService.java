package fiap.com.capacitydash.service;

import fiap.com.capacitydash.model.Alert;
import fiap.com.capacitydash.model.Department;
import fiap.com.capacitydash.model.LevelAlert;
import fiap.com.capacitydash.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;
    private final DepartamentService departamentService;

    public List<Alert> getAllAlertsCritical(){
        return alertRepository.findAll()
                .stream()
                .filter(a -> a.getLevelAlert() == LevelAlert.CRITICAL)
                .toList();
    }
    public List<Alert> getAllAlerts(){
        return alertRepository.findAll();
    }

//    public void criarAlerta(Department department){
//        double porcentagemRestante = capacidadeRestante(department);
//        LevelAlert levelAlert = gerarLevelAlert(porcentagemRestante);
//        String message = mensagemAlert(porcentagemRestante);
//        LocalDateTime date = LocalDateTime.now();
//        if(!message.equals("OK!")){
//            Alert alert = new Alert(null, message, levelAlert, date, department);
//            alertRepository.save(alert);
//        }
//    }

//    public double capacidadeRestante(Department department){
//        double totalCapacidade = department.getTotalCapacity();
//        double atualCapacidade = department.getParkingSpaces().size();
//
//        var porcenagemRestante = (totalCapacidade / atualCapacidade) * 100;
//
//        return porcenagemRestante;
//    }
//    public  LevelAlert gerarLevelAlert(double porcentagemRestante){
//        if (porcentagemRestante >= 90){
//            return LevelAlert.CRITICAL;
//        } else if (porcentagemRestante >= 60){
//            return LevelAlert.WARNING;
//        } else {
//            return LevelAlert.INFO;
//        }
//    }

    public String mensagemAlert(double porcentagemRestante){
        if (porcentagemRestante >= 90){
            return "RISCO DE SUPER LOTAÇÃO";
        } else if (porcentagemRestante >= 50){
            return "Mais da metade está ocupada...";
        } else {
            return "OK!";
        }
    }
}
