package pl.chris.spring.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BusinessEntitiesData extends PrimaryKeyData {

    @Column(nullable = false)
    private String domainUuid;

    public BusinessEntitiesData(UUID uuid, String domainUuid) {
        super(uuid);
        this.domainUuid = domainUuid;
    }
}