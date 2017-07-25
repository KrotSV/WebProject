package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CardRequest implements Serializable{
    private Calendar date;
    private int clientId;
    private TypeCard typeCard;
    private boolean approval;

    public CardRequest(){};

    public CardRequest(Calendar date, int clientId, TypeCard typeCard, boolean approval) {
        this.date = date;
        this.clientId = clientId;
        this.typeCard = typeCard;
        this.approval = approval;
    }

    public Calendar getDate() {
        return date;
    }

    public int getClientId() {
        return clientId;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setDate(Calendar date) {
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
}
