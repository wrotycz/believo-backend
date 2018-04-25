package pl.weglarz.believo.model.entities;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class Character implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Integer experience;

    private String player;

    @RestResource
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @RestResource
    @ManyToMany
    @JoinTable(name = "character_trait",
            joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trait_id", referencedColumnName = "id"))
    private Set<Trait> traits;

    @RestResource
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
}
