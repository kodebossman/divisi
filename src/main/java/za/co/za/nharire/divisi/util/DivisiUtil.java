package za.co.za.nharire.divisi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DivisiUtil {

    public static String logData(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception exception) {
            log.error("FAILED TO LOG DATA {}", exception.getMessage());
            return exception.getMessage();
        }
    }
}
