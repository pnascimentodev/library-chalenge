package com.pndev.library.exceptions;

public class UserHasPendingLoansException extends BusinessRuleException {
    public UserHasPendingLoansException(int loanCount) {
        super("Usuário possui " + loanCount + " empréstimo(s) pendente(s)");
    }
}
