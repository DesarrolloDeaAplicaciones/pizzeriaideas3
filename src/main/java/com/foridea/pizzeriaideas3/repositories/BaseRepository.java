
package com.foridea.pizzeriaideas3.repositories;

import com.foridea.pizzeriaideas3.entities.Base;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //no instanciar
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
    
}
