package org.esprim.tpfoyer.Repository;

import org.esprim.tpfoyer.Entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {



}
