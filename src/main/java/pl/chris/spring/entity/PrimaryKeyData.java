package pl.chris.spring.entity;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
public class PrimaryKeyData implements HoldsStringFormattedId {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Id
    @Column(unique = true, nullable = false, columnDefinition = "uuid")
    private UUID uuid = UUID.randomUUID();

    PrimaryKeyData(UUID uuid) {
        this.uuid = Optional.ofNullable(uuid).orElseGet(UUID::randomUUID);
    }

    @Override
    public String getIdFormattedToString() {
        return uuid.toString();
    }
}
