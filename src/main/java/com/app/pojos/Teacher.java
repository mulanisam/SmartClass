package com.app.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher extends BaseEntity{

    @NotBlank(message = "Teacher Name is required!")
    @Column(length = 50,nullable = false)
    private String teacherName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("teacher")
    private Subject subject;

}
