import com.gabby.Exception.CurrentCustomerSessionException;
import com.gabby.Exception.CustomerException;
import com.gabby.model.CurrentCustomerSession;
import com.gabby.model.Customer;

public interface CurrentCustomerSessionService {

	public CurrentCustomerSession getCurrentCustomerSession(String key) throws CurrentCustomerSessionException;

	public Customer getCustomerDetails(String key) throws CurrentCustomerSessionException, CustomerException;

	public Integer getCurrentUserCustomerId(String key) throws CurrentCustomerSessionException;

}
