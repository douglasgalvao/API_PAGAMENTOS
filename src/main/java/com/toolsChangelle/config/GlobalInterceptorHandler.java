package com.toolsChangelle.config;
import com.toolsChangelle.exceptions.BusinessError;
import com.toolsChangelle.exceptions.BusinessException;
import com.toolsChangelle.mapper.BusinessErrorMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@NoArgsConstructor
@ControllerAdvice(annotations = {RestController.class})
public class GlobalInterceptorHandler {
    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<BusinessError> businessHandler(BusinessException exception) {
        BusinessError error = BusinessErrorMapper.toDTO(exception.getMessage(),exception.getStatus());
        return new ResponseEntity<BusinessError>(error, error.getStatus());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<BusinessError> globalHandlerException(RuntimeException exception) {
        log.error("Erro inesperado aconteceu!. {}",exception.getMessage(),exception);
        BusinessError error = BusinessErrorMapper.toDTO("Internal server error, something bad happened." + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<BusinessError>(error, error.getStatus());
    }

}
