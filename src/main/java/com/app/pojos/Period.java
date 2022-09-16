package com.app.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "period")
public class Period extends BaseEntity{

    @NotBlank(message = "Period Start Time is required!")
    @Column(length = 50,nullable = false)
    private LocalTime startTime;

    @NotBlank(message = "Period End Time is required!")
    @Column(length = 50,nullable = false)
    private LocalTime endTime;

    @NotBlank(message = "Period Date is required!")
    @Column(length = 50,nullable = false)
    private LocalDate date;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("subject")
    private Subject subject;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("teacher")
    private Teacher teacher;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("classStandard")
    private ClassStandard std;
}
