package it.sogei.svildep.angraficaRTS.exception;

import it.sogei.svildep.common.exception.SvildepException;

public class AuthorizationException extends SvildepException {

    public AuthorizationException() { super(Messages.nonAutorizzato); }
}
