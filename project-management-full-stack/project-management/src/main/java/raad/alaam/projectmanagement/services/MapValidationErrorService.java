package raad.alaam.projectmanagement.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapValidationErrorService.class);

    public ResponseEntity<?> mapValidationErrorService(BindingResult result){
        if (result.hasErrors()){

            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return  null;
    }
}
