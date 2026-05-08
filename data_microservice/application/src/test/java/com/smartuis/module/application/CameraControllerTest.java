package com.smartuis.module.application;

import com.smartuis.module.application.controller.CameraController;
import com.smartuis.module.application.mapper.CameraMapper;
import com.smartuis.module.domain.entity.Camera;
import com.smartuis.module.domain.entity.CameraDTO;
import com.smartuis.module.domain.entity.StateCamera;
import com.smartuis.module.domain.repository.CameraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CameraControllerTest {

    @Mock
    private CameraRepository cameraRepository;

    @Mock
    private CameraMapper cameraMapper;

    @InjectMocks
    private CameraController cameraController;


    private Camera camera;
    private List<Camera> camerasList = List.of(
            new Camera(null,"CamaraTest", "http://example.com/camara", null),
            new Camera(null,"Camara2Test", "http://example2.com/camara", null),
            new Camera(null,"Camara3Test", "http://example3.com/camara", null));

    @BeforeEach
    public void setUp() {
        camera = new Camera("2","CamaraTest",
                "http://example.com/camara", StateCamera.Stopped);
    }


    @Test
    public void addCamera() {
        when(cameraRepository.existsByName(camera.getName())).thenReturn(false);
        when(cameraRepository.existsByUrl(camera.getUrl())).thenReturn(false);


        Camera cameraSave = new Camera("2","CamaraTest",
                "http://example.com/camara", StateCamera.Stopped);;

        when(cameraRepository.save(any(Camera.class))).thenReturn(cameraSave);
        CameraDTO cameraSaveDTO = new CameraDTO("CamaraTest","http://example.com/camara",StateCamera.Stopped);

        when(cameraMapper.mapCameraToCameraDTO(any(Camera.class)))
        .thenReturn(cameraSaveDTO);
        when(cameraMapper.mapCameraToCameraDTO(any(Camera.class))).thenReturn(cameraSaveDTO);

        ResponseEntity<?> response = cameraController.addCamera(camera);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cameraSaveDTO, response.getBody());
    }


    @Test
    public void listAllCamera(){
        when(cameraRepository.findAll()).thenReturn(camerasList);

        ResponseEntity<?> response = cameraController.listAllCamera();
        List<CameraDTO> CamerasDTOList = List.of(
        new CameraDTO("Cam1", "url1", StateCamera.Stopped),
        new CameraDTO("Cam2", "url2", StateCamera.Stopped),
        new CameraDTO("Cam3", "url3", StateCamera.Stopped)
        );

        when(cameraMapper.mapCameraToCameraDTO(camerasList))
        .thenReturn(CamerasDTOList);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat((List<CameraDTO>) response.getBody())
                .usingRecursiveComparison()
                .isEqualTo(CamerasDTOList);
    }


    @Test
    public void deleteCamera(){
        when(cameraRepository.findById(camera.getId()))
        .thenReturn(camera);
        ResponseEntity<?> response = cameraController.deleteCamera(camera.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se ha eliminado la camara exitosamente", response.getBody());
    }
}
