package br.com.softplan.sienge.repository;

import br.com.softplan.sienge.entity.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository <StreetEntity, Long> {
}
