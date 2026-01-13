package org.esprim.tpfoyer.Repository;

import org.esprim.tpfoyer.Entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {



}
