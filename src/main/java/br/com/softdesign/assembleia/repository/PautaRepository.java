package br.com.softdesign.assembleia.repository;

import br.com.softdesign.assembleia.entity.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PautaRepository extends JpaRepository<PautaEntity, Long> {

    Optional<PautaEntity> findByInternalId(String internalId);
}
