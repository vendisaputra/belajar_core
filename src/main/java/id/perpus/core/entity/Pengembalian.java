package id.perpus.core.entity;


import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;

/**
 * contributor novendiuseksaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@Table(name = id.perpus.core.constant.Table.PENGEMBALIAN)
@NoArgsConstructor
@DynamicUpdate
public class Pengembalian implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pinjam")
    private Peminjaman peminjaman;

    @Column(name = "tgl_kembali")
    private Date tglKembali;

    @Column(name = "denda")
    private int denda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public Pengembalian(Long id) {
        this.id = id;
    }
}
