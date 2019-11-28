package id.perpus.core.entity;

import id.perpus.core.common.EntityAware;
import id.perpus.core.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * contributor novendiuskeasaputra
 * create date 12/11/2019
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = id.perpus.core.constant.Table.USER)
@DynamicUpdate
public class User implements EntityAware {

  private static final long serialVersionUID = 5926468583005150707L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
