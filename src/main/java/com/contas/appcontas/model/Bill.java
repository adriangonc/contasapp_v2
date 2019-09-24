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

    @NotBlank(message = "bill-error-1")
    private String name;

    private String observation;

    @NotNull(message = "bill-error-2")
    private String frequency;

    @DecimalMin(value = "0", message = "bill-error-3")
    private double value;

    private Date expirationDate;
}
