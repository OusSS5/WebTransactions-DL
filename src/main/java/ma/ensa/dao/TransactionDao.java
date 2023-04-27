package ma.ensa.dao;

import java.util.List;
import ma.ensa.Transaction;

public interface TransactionDao {
	int save(Transaction transaction);
	List<Transaction> selectAll();
}
