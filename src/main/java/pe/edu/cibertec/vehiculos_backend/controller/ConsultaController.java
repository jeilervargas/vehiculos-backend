package pe.edu.cibertec.vehiculos_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.vehiculos_backend.dto.ConsultaRequestDTO;
import pe.edu.cibertec.vehiculos_backend.dto.ConsultaResponseDTO;
import pe.edu.cibertec.vehiculos_backend.service.ConsultaService;

import java.io.IOException;

@RestController
@RequestMapping("/inicio")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @PostMapping("/consultar")
    public ConsultaResponseDTO consultar(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        //try catch

        try {
            String[] datosConsulta = consultaService.consultarVehiculo(consultaRequestDTO);
            if (datosConsulta == null) {
                return new ConsultaResponseDTO("01", "Error: Ocurrió un problema", "", ""
                        , "", "","");

            }
            return new ConsultaResponseDTO("00", "Exito: Vehiculo encontrado", datosConsulta[0], datosConsulta[1]
                    , datosConsulta[2], datosConsulta[3], datosConsulta[4]);

        }catch (IOException e) {
            return new ConsultaResponseDTO("99", "Error: Ocurrió un problema", "", ""
                    , "", "","");
        }

    }
}
