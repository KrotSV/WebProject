package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CardRequest implements Serializable{
    private int requestId;
    private Date date;
    private int clientId;
    private TypeCard typeCard;
    private boolean approval;

    public CardRequest(){};

    public CardRequest(int requestId, Date date, int clientId, TypeCard typeCard, boolean approval) {
        this.requestId = requestId;
        this.date = date;
        this.clientId = clientId;
        this.typeCard = typeCard;
        this.approval = approval;
    }

    public Date getDate() {
        return date;
    }

    public int getClientId() {
        return clientId;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
