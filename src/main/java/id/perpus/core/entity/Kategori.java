package id.perpus.core.entity;

import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * contributor novendiusekasaputra
 * create date 12/11/2019
 */

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = id.perpus.core.constant.Table.KATEGORI)
@DynamicUpdate
public class Kategori implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
