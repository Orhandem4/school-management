package com.schoolmanagement.entity.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolmanagement.entity.concretes.UserRole;
import com.schoolmanagement.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass // DB de user tablosu olusmadan bu sınıfın anac sınıf olarak kullanilmasini saglıyor
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder // Alt sınıfların user sınıfının builder özelliklerini kullanabilmesine izin verir
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String snn;

    private String name;

    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy--MM-dd")
    private LocalDate birthDay;

    private String birthPlace;

    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY) // hassas veri olduğu için okuma işlemlerinde kullanılmasın
    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne
    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    private UserRole userRole;

    private Gender gender;



}
