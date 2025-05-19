package com.pndev.library.exceptions;

public class AlreadyLoanedException extends BusinessRuleException {
    public AlreadyLoanedException(String bookTitle) {
        super("O livro '" + bookTitle + "' já está emprestado");
    }
}
