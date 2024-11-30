package com.example.indentity_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@IdClass(ChitietcuutroId.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chitietcuutro {

    LocalDate ngaycuutro;
    String dexuatcaithien;

    @Id @ManyToOne
    @JoinColumn( name = "masv")
    Sinhvien sinhvien;

    @Id @ManyToOne
    @JoinColumn( name = "matruong")
    Truong truong;

    @Id @ManyToOne
    @JoinColumn( name = "madotcuutro")
    Dotcuutro dotcuutro;

}

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class ChitietcuutroId implements Serializable {

    String sinhvien;
    String truong;
    String dotcuutro;

    // equals và hashCode để đảm bảo tính toàn vẹn của khóa phức hợp
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChitietcuutroId that = (ChitietcuutroId) o;
        return Objects.equals(sinhvien, that.sinhvien) &&
                Objects.equals(truong, that.truong) &&
                Objects.equals(dotcuutro, that.dotcuutro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhvien, truong, dotcuutro);
    }
}
