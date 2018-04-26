package pl.weglarz.believo.model.entities;

import java.io.Serializable;

public interface IEntity extends Serializable {
    Long getId();

    void setId(Long id);
}
