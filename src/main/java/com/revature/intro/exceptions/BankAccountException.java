package com.revature.intro.exceptions;

public class BankAccountException extends RuntimeException
{
    public BankAccountException( String message )
    {
        super( "Invalid Transaction -- " + message );
    }
}
