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
@Table(name = "subject")
public class Subject extends BaseEntity{

    @NotBlank(message = "Subject Name is required!")
    @Column(length = 50,nullable = false)
    private String subName;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "subject")
    @JsonIgnoreProperties("subject")
    private List<Teacher> teacher;



}
