package pe.edu.cibertec.vehiculos_backend.service;

import pe.edu.cibertec.vehiculos_backend.dto.ConsultaRequestDTO;

import java.io.IOException;

public interface ConsultaService {

    String[] consultarVehiculo(ConsultaRequestDTO consultaRequestDTO) throws IOException;
}
