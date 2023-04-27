package ma.ensa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.ensa.Transaction;
import ma.ensa.dao.TransactionDao;



	public class TransactionDaoImpl implements TransactionDao {

		@Override
		public int save(Transaction transaction) {
			int r = 0;
			ConDB db = new ConDB();
			String req = "INSERT INTO transaction values('" + transaction.getRef() + "','" + transaction.getCptDeb() + "','"
					+ transaction.getCptCred() + "','" + transaction.getMontant() + "','" + transaction.getType() + "','" + transaction.getDate() + "')";
			try {
				r = db.getSt().executeUpdate(req);
				db.getCon().close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return r;
		}

		@Override
		public List<Transaction> selectAll() {
			List<Transaction> transactions = new ArrayList<Transaction>();
			
			ConDB db = new ConDB();
			String req = "SELECT * FROM transaction;";
			try {
			ResultSet rs=db.getSt().executeQuery(req);
			
			while(rs.next()) {
				Transaction transaction =new Transaction(rs.getString("ref"), rs.getString("cptDeb"), rs.getString("cptCred"), rs.getDouble("montant"));
			transactions.add(transaction);
			
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
			return transactions;
		}

	}



