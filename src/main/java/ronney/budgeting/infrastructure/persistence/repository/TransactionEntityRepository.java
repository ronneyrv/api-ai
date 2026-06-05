package ronney.budgeting.infrastructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ronney.budgeting.domain.Category;
import ronney.budgeting.infrastructure.persistence.entity.TransactionEntity;

import java.util.List;
import java.util.UUID;

public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findAllByCategory(Category category);
}
