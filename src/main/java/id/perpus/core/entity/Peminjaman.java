package id.perpus.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * contributor novendiusekasaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@Table(name = id.perpus.core.constant.Table.PINJAMAN)
@NoArgsConstructor
@DynamicUpdate
public class Peminjaman implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tgl_pinjam")
    private Date tglPinjaman;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_siswa")
    private Siswa siswa;

//    @OneToMany(mappedBy = "peminjaman", cascade = {CascadeType.ALL}, orphanRemoval = true)
//    @JoinColumn(name = "id")
//    Set<PinjamanItem> pinjamanItems = new HashSet<>();

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "lama_pinjam")
    private int lamaPinjaman;

    @Column(name = "Status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public Peminjaman(Long id) {
        this.id = id;
    }
}
