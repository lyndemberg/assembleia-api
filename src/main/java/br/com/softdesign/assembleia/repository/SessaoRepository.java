package br.com.softdesign.assembleia.repository;

import br.com.softdesign.assembleia.entity.SessaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoEntity, Long> {

    Optional<SessaoEntity> findByInternalId(String internalId);
}
