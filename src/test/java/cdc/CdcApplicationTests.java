package cdc;

import cdc.entitie.Transaction;
import cdc.repository.TransactionRepository;
import cdc.service.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
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
        Transaction trans=new Transaction(null,100,"orig",120,130,"dest",200,220);
        tt.saveTransaction(trans);
    }

    @Test
    public void testCreatBatchTransaction(){
        Transaction trans=new Transaction(null,169,"2orig",1020,130,"dest",200,220);
        Transaction trans2=new Transaction(null,69,"1orig",1020,130,"dest",200,220);

        ArrayList<Transaction> listTrans = new ArrayList();
        listTrans.add(trans);
        listTrans.add(trans2);
        System.out.println("------\n\n"+listTrans.size()+"\n\n---------");
        List<Transaction> l= tt.saveBatchTransaction(listTrans);
        System.out.println("------\n\n"+l.size()+"\n\n---------");
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

    @Test
    public void testGetSomeTransactions(){
        Page<Transaction> page = tt.getSomeTransactions(0,5);
        System.out.println("-----------\n\n"+page.toList().size()+"\n\n------------------");
    }
}
