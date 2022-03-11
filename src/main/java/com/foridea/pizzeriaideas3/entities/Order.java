
package com.foridea.pizzeriaideas3.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.foridea.pizzeriaideas3.enums.EnumState;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order extends Base {
    
    @Column(name = "state", nullable = false, updatable = true)
    @Enumerated(value = EnumType.STRING)
    private EnumState enumState;

    @CreationTimestamp
    @Column(name = "registration", updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registration = LocalDateTime.now();
    
    @JoinColumn(name="foods_id")
    @OneToMany(cascade = {}, fetch = FetchType.EAGER)
    private List<Food> foods;

}
