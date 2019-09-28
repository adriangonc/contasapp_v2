package com.contas.appcontas.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class MonthPayment {
    @Id
    @SequenceGenerator(name = "month_sequence", sequenceName = "month_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "month_sequence")
    private int id;

    @NotNull
    private MonthEnum name;

    private String observation;

    @NotNull
    private Date date;
}

