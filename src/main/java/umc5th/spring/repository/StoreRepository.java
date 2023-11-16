package umc5th.spring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findById(Long id);

}
