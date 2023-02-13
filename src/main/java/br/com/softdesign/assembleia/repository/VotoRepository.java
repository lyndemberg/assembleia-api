package br.com.softdesign.assembleia.repository;

import br.com.softdesign.assembleia.entity.VotoEntity;
import br.com.softdesign.assembleia.entity.VotoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<VotoEntity, Long> {
    Optional<VotoEntity> findById(VotoId votoId);
    List<VotoEntity> findById_SessaoId(String sessaoInternalId);
}
