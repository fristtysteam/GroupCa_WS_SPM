package Library;

import java.util.Date;
import java.util.Objects;

public class LoanID {
    private int loanID;

    private Date loanDate;

    private boolean returnStatus;


    public LoanID(int loanID, Date loanDate, boolean returnStatus) {
        this.loanID = loanID;
        this.loanDate = loanDate;
        this.returnStatus = returnStatus;
    }

    public LoanID() {
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanID)) return false;
        LoanID loanID1 = (LoanID) o;
        return getLoanID() == loanID1.getLoanID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoanID());
    }

    @Override
    public String toString() {
        return "LoanID{" +
                "loanID=" + loanID +
                ", loanDate=" + loanDate +
                ", returnStatus=" + returnStatus +
                '}';
    }

    public String isReturned(){
        if( returnStatus == true ){
            return ("Book has been Returned");
        }
        else{
            return ("Book has not been Returned.");
        }
    }




}
