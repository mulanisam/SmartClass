package com.app.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classStandard")
public class ClassStandard extends BaseEntity{

    @NotBlank(message = "Std is required!")
    @Column(length = 50,nullable = false, unique = true)
    private String std;

    @OneToOne()
    @JsonIgnoreProperties("classStandard")
    private Teacher classTeacher;
}
