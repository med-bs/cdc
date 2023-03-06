package cdc.service;

import cdc.entitie.Transaction;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransactionService {
    /**
     * Sauvgarder la transaction donnee en argument
     * @param transaction Transaction
     * @return Transaction
     */
    Transaction saveTransaction(Transaction transaction);

    /**
     * Sauvgarder la list trasnactions donnees en argument
     * @param transactions List<Transaction>
     * @return List<Transaction>
     */
    List<Transaction> saveBatchTransaction(List<Transaction> transactions);

    /**
     * Mettre a jour la transaction donner en argument
     * @param transaction Transaction
     * @param id int l'id de la transaction a mettre a jour
     * @return Transaction
     */
    Transaction updateTransaction(Transaction transaction, int id);

    /**
     * Supprime la transaction donner en argument
     * @param transaction Transaction
     */
    void deleteTransaction(Transaction transaction);

    /**
     * Rupprime la transaction avec l'id donner en argument
     * @param id int l'id de la transaction a supprimer
     */
    void deleteTransactionById(int id);

    /**
     * Retourne la transaction avec l'id donner en argument
     * @param id int l'id de la transaction a retourner
     * @return Transaction
     */
    Transaction getTransaction(int id);

    /**
     * Retourne toutes les transactions
     * @return List<Transaction>
     */
    List<Transaction> getAllTransactions();

    /**
     * Retourn un lot des transactions de taille pageSize donnee en argument ayon l'index numPage donner en argument
     * cette methode devise la taille de toutes les transactions par l'argument pageSize en des lot
     * @param numPage l'idex du lot
     * @param pageSize int taille du lot
     * @return List<Transaction>
     */
    Page<Transaction> getSomeTransactions(int numPage, int pageSize);
}
