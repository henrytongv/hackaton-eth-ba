package demoethba;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.Hbar;
import com.hedera.hashgraph.sdk.PrivateKey;
import com.hedera.hashgraph.sdk.Status;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.hedera.hashgraph.sdk.TransactionResponse;
import com.hedera.hashgraph.sdk.TransferTransaction;
import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.PrivateKey;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.ScheduleCreateTransaction;
import com.hedera.hashgraph.sdk.TransferTransaction;
import com.hedera.hashgraph.sdk.Hbar;
import com.hedera.hashgraph.sdk.TransactionResponse;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.hedera.hashgraph.sdk.Status;
import com.hedera.hashgraph.sdk.ScheduleId;
import java.time.Instant;
import java.time.Duration;

public class SchedulePayments {

	public static void main(String[] args) {
		System.out.println("***START");
		Client client = null;
		try {

			// Your account ID and private key from string value
			AccountId MY_ACCOUNT_ID = AccountId.fromString("0.0.6214184");
			PrivateKey MY_PRIVATE_KEY = PrivateKey.fromStringED25519(
					"*************************************");

			// Pre-configured client for test network (testnet)
			client = Client.forTestnet();

			// Set the operator with the account ID and private key
			client.setOperator(MY_ACCOUNT_ID, MY_PRIVATE_KEY);

			// **********************
			
			TransferTransaction transactionToSchedule = new TransferTransaction()
			        .addHbarTransfer(MY_ACCOUNT_ID, Hbar.fromTinybars(-1))
			        .addHbarTransfer(AccountId.fromString("0.0.7279544"), Hbar.fromTinybars(1));
			

	        for (int i = 1; i <= 6; i++) {
	            System.out.println("*** creating scheduled transaction for day: " + i);
	            Instant timeInTheFuture = Instant.now().plus(Duration.ofDays(i));


				// Create a scheduled transaction
				ScheduleCreateTransaction transaction = new ScheduleCreateTransaction().setScheduledTransaction(transactionToSchedule).setExpirationTime(timeInTheFuture).setWaitForExpiry(true);

				TransactionResponse txResponse = transaction.execute(client);
				TransactionReceipt receipt = txResponse.getReceipt(client);
				String scheduledTransactionId = txResponse.transactionId.toString();
				//System.out.println("Receipt status                     : " + statusScheduleTx.toString());
				//System.out.println("Transaction ID                     : " + txScheduledId);
				System.out.println("Hashscan URL                       : " + "https://hashscan.io/testnet/transaction/" + scheduledTransactionId);
				//System.out.println("Scheduled Transaction ID           : " + scheduleId.toString());	            
	        }
	        
	        


		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
				}
				;
			}
		}
		System.out.println("***END");
	}

}
