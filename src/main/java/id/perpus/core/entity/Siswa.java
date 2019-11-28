package id.perpus.core.entity;

import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * contributor novendiusekasaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@Table(name = id.perpus.core.constant.Table.SISWA)
@NoArgsConstructor
@DynamicUpdate
public class Siswa implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nisn")
    private String nisn;

    @Column(name = "gender")
    private String gender;

    @Column(name = "religion")
    private String religion;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private Date tglLahir;

    @Column(name = "address")
    private String address;

    @Column(name = "telp")
    private String telp;

    @Column(name = "image")
    private String image;

    public Siswa(Long id) {
        this.id = id;
    }
}
