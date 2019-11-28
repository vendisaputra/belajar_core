package id.perpus.core.entity;

import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * contributor novendiuseksaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@Table(name = id.perpus.core.constant.Table.PENGADAAN)
@NoArgsConstructor
@DynamicUpdate
public class Pengadaan implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tgl_pengadaan")
    private Date tgl_pengadaan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_buku")
    private Buku buku;

    @Column(name = "asal_buku")
    private String asal_buku;

    @Column(name = "jumlah")
    private int jumlah;

    @Column(name = "keterangan")
    private String keterangan;

    public Pengadaan(Long id) {
        this.id = id;
    }
}
