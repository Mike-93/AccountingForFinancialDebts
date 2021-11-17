package AccountingForFinancialDebts.services;

import AccountingForFinancialDebts.models.Debtor;
import AccountingForFinancialDebts.repositories.DebtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DebtorService {

    @Autowired
    private final DebtorRepository debtorRepository;

    public void addDebtor(Debtor debtor) {
        Debtor newDebtor = new Debtor();
        newDebtor.setSurname(debtor.getSurname());
        newDebtor.setName(debtor.getName());
        newDebtor.setPatronymic(debtor.getPatronymic());
        newDebtor.setAmountOfDebt(debtor.getAmountOfDebt());
        debtorRepository.save(newDebtor);
    }

    public Debtor getDebtor(int id) {
        Debtor debtor = debtorRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        return debtor;
    }

    public boolean chekDebtor(int id) {
        Debtor checkedDebtor = debtorRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        boolean isDebtor = checkedDebtor.getAmountOfDebt() > 0 ? true : false;
        return isDebtor;
    }

    public List<Debtor> getAllDebtors() {
        Iterable<Debtor> debtors = debtorRepository.findAll();
        List<Debtor> debtorList = new ArrayList<>();
        for (Debtor debtor : debtors) {
            debtorList.add(debtor);
        }
        return debtorList;
    }

    public List<Debtor> getActiveDebtors() {
        Iterable<Debtor> debtors = debtorRepository.findAll();
        List<Debtor> debtorList = new ArrayList<>();
        for (Debtor debtor : debtors) {
            if (chekDebtor(debtor.getId())) {
                debtorList.add(debtor);
            }
        }
        return debtorList;
    }
}
