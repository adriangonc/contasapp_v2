package com.contas.appcontas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bill {
    @Id
    @SequenceGenerator(name = "bill_sequence", sequenceName = "bill_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_sequence")
    //@EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    private String name;

    private String observation;

    @NotNull
    private String frequency;

    @DecimalMin("0")
    private double value;

    private Date expirationDate;
}
