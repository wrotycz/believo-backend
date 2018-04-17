package pl.weglarz.believo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.weglarz.believo.model.entities.IEntity;
import pl.weglarz.believo.model.entities.Role;

import javax.persistence.*;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements IEntity {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean locked;
    private Set<String> roles;

}
