package approver.role;

import approver.Approver;
import approver.PurchaseRequest;

public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount()<50000){
            System.out.println("主任"+ this.name+"审批采购单: "+request);
        }else {
            this.successor.processRequest(request);
        }
    }

}
