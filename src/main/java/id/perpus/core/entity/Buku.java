package id.perpus.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * contributor novendiusekasaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = id.perpus.core.constant.Table.BUKU)
@DynamicUpdate
public class Buku implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "judul")
    private String judul;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_kategori")
    @JsonIgnore
    private Kategori kategori;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_penerbit")
    @JsonIgnore
    private Publiser publiser;

//    @OneToMany(mappedBy = "buku")
//    @JoinColumn(name = "id")
//    private PinjamanItem pinjamanItem;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "pengarang")
    private String pengarang;

    @Column(name = "halaman")
    private int halaman;

    @Column(name = "thn_terbit")
    private Date thn_terbit;

    @Column(name = "image")
    private String image;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "barcode")
    private String barcode;
}
