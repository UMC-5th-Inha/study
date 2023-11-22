package umc5th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByIdAndStateTrue(Long storeId);
}
