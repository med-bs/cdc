package cdc;

import cdc.entitie.Transaction;
import cdc.repository.TransactionRepository;
import cdc.service.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CdcApplicationTests {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionServiceImpl tt;

    @Test
    void contextLoads() {
    }
    @Test
    public void testCreatTransaction(){
        Transaction trans=new Transaction(100,"orig",120,130,"dest",200,220);
        tt.saveTransaction(trans);
    }

    @Test
    public void testFindTran(){
        Transaction trans= transactionRepository.findById(2).get();
        System.out.println(trans);
    }
    @Test
    public void testUpdateTransaction(){
        Transaction trans= transactionRepository.findById(1).get();
        trans.setAmount(1100);
        transactionRepository.save(trans);
        System.out.println(trans);
    }
/*
    @Test
    public void testDeletTrensaction(){
        transactionRepository.deleteById(130);
    }

 */

    @Test
    public void testFindAllTransactions(){
        List<Transaction> transactionList= transactionRepository.findAll();
        for (Transaction trans:transactionList) {
            System.out.println(trans);
        }
    }
}
