package fr.dawan.formationspring.entities;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long id;

}