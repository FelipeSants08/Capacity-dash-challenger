package fiap.com.capacitydash.controller;

import fiap.com.capacitydash.model.Department;
import fiap.com.capacitydash.service.AlertService;
import fiap.com.capacitydash.service.DepartamentService;
import fiap.com.capacitydash.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DepartamentService departamentService;
    private final AlertService alertService;
    private final ParkingSpaceService parkingSpaceService;

    @GetMapping
    public String index(Model model){
        List<Department> departments = departamentService.findAllDepartments();
        var alerts = alertService.getAllAlerts();
        var parking = parkingSpaceService.findAll();
        model.addAttribute("departments", departments);
        model.addAttribute("alerts", alerts);
        model.addAttribute("parking", parking);
        return "dashboard";
    }

    @GetMapping("/{id}")
    public String departmentDetails(@PathVariable Long id, Model model){
        var department = departamentService.findDepartmentById(id);

        if (department == null) {
            return "redirect:/dashboard";
        }

        var parkingSpaces = parkingSpaceService.findAll();
        var alerts = alertService.getAllAlerts();

        model.addAttribute("department", department);
        model.addAttribute("allParkingSpaces", parkingSpaces); // Renomeei para evitar conflito
        model.addAttribute("allAlerts", alerts); // Renomeei para evitar conflito
        return "dashboard-details";
    }

}
