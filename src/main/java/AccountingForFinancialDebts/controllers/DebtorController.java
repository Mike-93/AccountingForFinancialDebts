package AccountingForFinancialDebts.controllers;

import AccountingForFinancialDebts.models.Debtor;
import AccountingForFinancialDebts.services.DebtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DebtorController {

    @Autowired
    private final DebtorService debtorService;

    @PostMapping("/debtor")
    public ResponseEntity addDebtor(@RequestBody Debtor debtor) {
        debtorService.addDebtor(debtor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/debtor")
    public ResponseEntity<List<Debtor>> getAllDebtors() {
        List<Debtor> debtorList = debtorService.getAllDebtors();
        if (debtorList != null && !debtorList.isEmpty()) {
            return new ResponseEntity<>(debtorList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/debtor/active")
    public ResponseEntity<List<Debtor>> getActiveDebtors() {
        List<Debtor> debtorList = debtorService.getActiveDebtors();
        if (debtorList != null && !debtorList.isEmpty()) {
            return new ResponseEntity<>(debtorList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/debtor/{id}")
    public ResponseEntity<Debtor> isDebtor(@PathVariable int id) {
        Debtor debtor = debtorService.getDebtor(id);
        if (debtorService.chekDebtor(id)) {
            return new ResponseEntity<>(debtor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
