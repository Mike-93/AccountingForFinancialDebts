package AccountingForFinancialDebts.repositories;

import AccountingForFinancialDebts.models.Debtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorRepository extends CrudRepository <Debtor, Integer> {

}
