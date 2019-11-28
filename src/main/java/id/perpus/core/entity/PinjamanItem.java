package id.perpus.core.entity;

import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

/**
 * contributor novendiusekasaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@Table(name = id.perpus.core.constant.Table.PINJAMAN_ITEM)
@NoArgsConstructor
@DynamicUpdate
public class PinjamanItem implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_buku")
    private Buku buku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pinjam")
    private Peminjaman peminjaman;


    @Column(name = "jumlah")
    private int jumlah;

    public PinjamanItem(Long id) {
        this.id = id;
    }
}
