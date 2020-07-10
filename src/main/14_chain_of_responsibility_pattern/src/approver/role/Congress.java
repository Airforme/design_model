package approver.role;

import approver.Approver;
import approver.PurchaseRequest;

public class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事会审批采购单 :"+request);
    }
}
