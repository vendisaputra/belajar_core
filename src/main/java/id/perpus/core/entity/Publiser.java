package id.perpus.core.entity;

import id.perpus.core.common.EntityAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * contributor novendiusekasaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = id.perpus.core.constant.Table.PUBLISER)
@DynamicUpdate
public class Publiser implements EntityAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Publiser(Long id) {
        this.id = id;
    }
}
