package umc5th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findStoreById(Long storeId);
}
